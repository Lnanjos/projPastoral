package br.org.pastoraldacrianca.bean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.DAO.LiderDAO;
import br.org.pastoraldacrianca.DAO.VisitaDAO;
import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.Visita;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CriancaBean implements Serializable{
	
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

	public void novo(){
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
	
	public void salvar(){
		try {
			CriancaDAO criancaDAO = new CriancaDAO();
			crianca = criancaDAO.salvar(crianca);
			
			if (editar == false) {
				visita.setCrianca(crianca);
				
				VisitaDAO visitaDAO = new VisitaDAO();
				visitaDAO.salvar(visita);
				
				visita = new Visita();
			}else {
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('dialogo').hide();");
			}
			
			if (addVisita == false) {
				crianca = new Crianca();
			}
			
			editar = false;
			criancas = criancaDAO.lista();
			
			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
			
			Messages.addGlobalInfo("Registro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocooreu um erro ao tentar");
			erro.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
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

			criancas = criancaDAO.lista();

			Messages.addGlobalInfo("Estado removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover o estado");
		}
	}
}
