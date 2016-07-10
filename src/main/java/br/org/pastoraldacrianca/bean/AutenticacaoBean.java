package br.org.pastoraldacrianca.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.org.pastoraldacrianca.DAO.UsuarioDAO;
import br.org.pastoraldacrianca.domain.Usuario;

//managed permite manipular o Bean atraves da tela,
//a ligação da tela com o autenticacaoBean
@ManagedBean
// SessionScoped: cria uma sessao que dura enquanto a aplicação estiver aberta.
// quando se abre o software, ela cria uma sessao até que seja fechado o
// software
// ja o view so dura enquanto ambas as telas estiverem abertas, quando fecha ela
// desativa aoutra
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;
	private boolean tipoUsuario; 

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	// inicia o usuario e a pessoa atrelada
	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			// usuarioLogado recebe o resultado do metodo que esta no usuario
			// DAO
			usuarioLogado = usuarioDAO.autenticar(usuario.getEmail(),
					usuario.getSenha());

			if (usuarioLogado == null) {
				Messages.addGlobalError("Email e/ou senha incorretos");
				return;
			}
			if (usuarioLogado.getTipo().equals('C')) {
				Faces.redirect("./pages/lider.xhtml");
				tipoUsuario = false;
			} else {
				Faces.redirect("./pages/visita.xhtml");
				tipoUsuario = true;
			}

		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}

}
