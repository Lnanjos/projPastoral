package br.org.pastoraldacrianca.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.DAO.LiderDAO;
import br.org.pastoraldacrianca.DAO.VisitaDAO;
import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.Visita;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VisitaBean implements Serializable {
	private Visita visita;
	private Crianca crianca;
	private Lider lider;
	private boolean editarVisita = false;

	private List<Visita> visitas;
	private List<Crianca> criancas;
	private List<Lider> lideres;

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
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

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public boolean isEditarVisita() {
		return editarVisita;
	}

	public void setEditarVisita(boolean editarVisita) {
		this.editarVisita = editarVisita;
	}

	@PostConstruct
	public void listar() {
		try {
			VisitaDAO visitaDAO = new VisitaDAO();
			visitas = visitaDAO.lista();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			visita = new Visita();
			setEditarVisita(false);

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			visita.setCrianca(crianca);
			visita.setLider(lider);

			VisitaDAO visitaDAO = new VisitaDAO();
			visitaDAO.salvar(visita);

			visita = new Visita();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();

			visitas = visitaDAO.lista();

			Messages.addGlobalInfo("Registro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			visita = (Visita) evento.getComponent().getAttributes().get("visitaSelecionada");

			VisitaDAO visitaDAO = new VisitaDAO();
			visitaDAO.excluir(visita);

			visitas = visitaDAO.lista();

			Messages.addGlobalInfo("Cidade removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a cidade");
			erro.printStackTrace();
		}
	}

	
	public void editar(ActionEvent evento) {
		try {
			visita = (Visita) evento.getComponent().getAttributes()
					.get("visitaSelecionada");

			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();

			CriancaDAO criancaDAO = new CriancaDAO();
			criancas = criancaDAO.lista();			
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar uma nova cidade");
		}
	}

	/*
	 * Método utilizado para buscas as visitas de uma determinada criança com um
	 * oneselectmenu no header public void buscarVC(AjaxBehaviorEvent evento){
	 * VisitaDAO visitaDAO = new VisitaDAO(); visitas = visitaDAO.lista();
	 * visitaC = new ArrayList<Visita>();
	 * 
	 * for(Visita visitaSelecionada : visitas){
	 * 
	 * if (visitaSelecionada.getCrianca().getCodigo() == crianca.getCodigo()) {
	 * visitaC.add(visitaSelecionada); }
	 * 
	 * visitas = visitaC;
	 * 
	 * } }
	 */
}
