package br.org.pastoraldacrianca.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.org.pastoraldacrianca.DAO.CadastroDeMortesDAO;
import br.org.pastoraldacrianca.DAO.CriancaDAO;
import br.org.pastoraldacrianca.domain.CadastroDeMortes;
import br.org.pastoraldacrianca.domain.Crianca;
import java.io.Serializable;
import java.util.List;

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
			criancas = criancaDAO.lista();

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
			criancas = criancaDAO.lista();

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
			criancas = criancaDAO.lista();

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
			criancas = criancaDAO.lista();

			CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
			setMortes(cadastroDAO.lista());

			cadastroDAO.excluir(morte);

			Messages.addGlobalInfo("Morte removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao remover a morte");
		}
	}

}
