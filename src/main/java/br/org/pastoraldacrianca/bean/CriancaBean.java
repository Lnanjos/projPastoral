package br.org.pastoraldacrianca.bean;


import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.hibernate.exception.ConstraintViolationException;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.DAO.LiderDAO;
import br.org.pastoraldacrianca.DAO.VisitaDAO;
import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.Visita;
import br.org.pastoraldacrianca.util.HibernateUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CriancaBean implements Serializable {

	private Crianca crianca;
	private Visita visita;
	private boolean editar = false;
	private boolean addVisita = false;

	private List<Crianca> criancas;
	private List<Lider> lideres;

	public boolean isAddVisita() {
		return addVisita;
	}

	public void setAddVisita(boolean addVisita) {
		this.addVisita = addVisita;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public List<Crianca> getCriancas() {
		return criancas;
	}

	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}

	public List<Lider> getLideres() {
		return lideres;
	}

	public void setLideres(List<Lider> lideres) {
		this.lideres = lideres;
	}

	public void novo() {
		try {
			crianca = new Crianca();
			visita = new Visita();

			editar = false;
			addVisita = false;

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar nova criança");
		}
	}

	public void salvar() {
		try {
			CriancaDAO criancaDAO = new CriancaDAO();
			crianca.setVivo(true);
			crianca = criancaDAO.salvar(crianca);

			if (editar == false) {
				visita.setCrianca(crianca);

				VisitaDAO visitaDAO = new VisitaDAO();
				visitaDAO.salvar(visita);

				visita = new Visita();
			} else {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogo').hide();");
			}

			if (addVisita == false) {
				crianca = new Crianca();
			}

			editar = false;
			criancas = criancaDAO.listaOrCriancasViva();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();

			Messages.addGlobalInfo("Registro salvo com sucesso");
		} catch (ConstraintViolationException erro) {
			Messages.addGlobalError("Já existe um registro salvo com esse número do SUS");
		} catch (Exception erro) {
			Messages.addGlobalError("Ocooreu um erro ao tentar salvar");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {
		try {
			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.listaOrCriancasViva();
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar as criancas");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		editar = true;
		addVisita = false;
		crianca = (Crianca) evento.getComponent().getAttributes()
				.get("criancaSelecionada");

	}

	public void adicionaVisita(ActionEvent evento) {
		addVisita = true;
		editar = false;
		crianca = (Crianca) evento.getComponent().getAttributes()
				.get("criancaSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			crianca = (Crianca) evento.getComponent().getAttributes()
					.get("criancaSelecionada");
			CriancaDAO criancaDAO = new CriancaDAO();

			criancaDAO.excluir(crianca);

			criancas = criancaDAO.listaOrCriancasViva();

			Messages.addGlobalInfo("Criança removido com sucesso");
		} catch (ConstraintViolationException erro) {
			Messages.addGlobalError("Existe visitas salvas para essa criança");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover a criança");
		}
	}
	
	public void imprimir(){
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
			Map<String, Object> parametros = tabela.getFilters();
			
			//caminho de acesso ao relatório
			String caminho = Faces.getRealPath("/reports/criancas.jasper");
			
			/* Método para usar a imagem no relatório
			String logo = Faces.getRealPath("/reports/logo2.png");
			System.out.println(logo);
			parametros.put("reportlogo", logo);
			*/
			//cria a conexão
			Connection conexao = HibernateUtil.getConexao();
			
			//Criação do relatório
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros,conexao);
			JasperPrintManager.printReport(relatorio, true);
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao gerar relatório");
		}
	}
}
