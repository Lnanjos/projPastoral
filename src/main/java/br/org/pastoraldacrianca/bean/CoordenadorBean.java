package br.org.pastoraldacrianca.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.org.pastoraldacrianca.DAO.CoordenadorDAO;
import br.org.pastoraldacrianca.domain.Coordenador;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CoordenadorBean implements Serializable{
private Coordenador coordenador;
	
	private List<Coordenador> coordenadores;
	
	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}
	
	public void novo(){
		coordenador = new Coordenador();
	}

	public void salvar(){
		try {
			CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
			coordenadorDAO.salvar(coordenador);
			
			coordenador = new Coordenador();
			
			coordenadores = coordenadorDAO.lista();
			
			Messages.addGlobalInfo("Coordenador salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocooreu um erro ao tentar");
			erro.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
			coordenadores = coordenadorDAO.lista();
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		coordenador = (Coordenador) evento.getComponent().getAttributes()
				.get("coordenadorSelecionado");
	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			coordenador = (Coordenador) evento.getComponent().getAttributes()
					.get("coordenadorSelecionado");
			CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
			
			coordenadorDAO.excluir(coordenador);

			coordenadores = coordenadorDAO.lista();

			Messages.addGlobalInfo("Registro removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover o registro");
		}
	}
}
