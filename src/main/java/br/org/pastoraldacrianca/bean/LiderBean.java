package br.org.pastoraldacrianca.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.org.pastoraldacrianca.DAO.LiderDAO;
import br.org.pastoraldacrianca.domain.Lider;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LiderBean implements Serializable{
	
	private Lider lider;
	
	private List<Lider> lideres;
	
	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public List<Lider> getLideres() {
		return lideres;
	}

	public void setLideres(List<Lider> lideres) {
		this.lideres = lideres;
	}
	
	public void novo(){
		lider = new Lider();
	}

	public void salvar(){
		try {
			LiderDAO liderDAO = new LiderDAO();
			liderDAO.salvar(lider);
			
			lider = new Lider();
			
			lideres = liderDAO.lista();
			
			Messages.addGlobalInfo("Lider salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocooreu um erro ao tentar");
			erro.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			LiderDAO liderDAO = new LiderDAO();
			lideres = liderDAO.lista();
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		lider = (Lider) evento.getComponent().getAttributes()
				.get("liderSelecionado");
	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			lider = (Lider) evento.getComponent().getAttributes()
					.get("liderSelecionado");
			LiderDAO liderDAO = new LiderDAO();
			
			liderDAO.excluir(lider);

			lideres = liderDAO.lista();

			Messages.addGlobalInfo("Registro removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover o estado");
		}
	}
}

