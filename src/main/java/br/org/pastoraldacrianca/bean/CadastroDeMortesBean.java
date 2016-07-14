package br.org.pastoraldacrianca.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import br.org.pastoraldacrianca.util.HibernateUtil;
import br.org.pastoraldacrianca.DAO.CadastroDeMortesDAO;
import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.domain.CadastroDeMortes;
import br.org.pastoraldacrianca.domain.Crianca;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CadastroDeMortesBean implements Serializable {

	private Crianca crianca;
	private CadastroDeMortes morte;

	private List<Crianca> criancas;
	private List<CadastroDeMortes> mortes;

	public List<Crianca> getCriancas() {
		return criancas;
	}

	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public CadastroDeMortes getMorte() {
		return morte;
	}

	public void setMorte(CadastroDeMortes morte) {
		this.morte = morte;
	}

	public List<CadastroDeMortes> getMortes() {
		return mortes;
	}

	public void setMortes(List<CadastroDeMortes> mortes) {
		this.mortes = mortes;
	}	

	public void novo() {
		try {
			morte = new CadastroDeMortes();
			crianca = new Crianca();

			CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
			setMortes(cadastroDAO.lista());

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.listaOrCriancasViva();

		} catch (Exception e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("Ocorreu um erro ao registrar a morte");
		}
	}

	public void salvar() {
		try {
			CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
			morte.setDataCadastro(cadastroDAO.buscarDataCadastro(crianca)); 
			morte.setCrianca(crianca);
			cadastroDAO.salvar(morte);

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.listaOrCriancasViva();

			setMortes(cadastroDAO.lista());

			crianca = new Crianca();
			morte = new CadastroDeMortes();

			Messages.addGlobalInfo("Registro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocoreu um erro ao tentar");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.listaOrCriancasViva();

			CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
			setMortes(cadastroDAO.lista());

		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar as mortes");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			CriancaDAO cDAO = new CriancaDAO();
			criancas = cDAO.lista();
			morte = (CadastroDeMortes) evento.getComponent().getAttributes().get("cadastroSelecionado");
			
			crianca = morte.getCrianca();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(ActionEvent evento) {
		try {
			morte = (CadastroDeMortes) evento.getComponent().getAttributes()
					.get("cadastroSelecionado");
			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.listaOrCriancasViva();

			CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();

			cadastroDAO.excluir(morte);
			setMortes(cadastroDAO.lista());

			Messages.addGlobalInfo("Morte removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover a morte");
		}
	}
	
	public void imprimir(){
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
			Map<String, Object> parametros = tabela.getFilters();
			
			//caminho de acesso ao relatório
			String caminho = Faces.getRealPath("/reports/mortes.jasper");
			
			String logo = Faces.getRealPath("/reports/logo2.png");
			parametros.put("reportlogo", logo);
			
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
