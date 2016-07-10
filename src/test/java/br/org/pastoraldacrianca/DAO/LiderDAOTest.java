package br.org.pastoraldacrianca.DAO;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.Usuario;

public class LiderDAOTest {

	@Test
	public void salvar() {

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = new Lider();

		lider.setNome("Lider 1");
		lider.setEndereco("lider1endereco");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario.setEmail("email1@email.com");
		usuario.setSenha("123456");
		usuario.setTipo('L');
		
		SimpleHash hash = new SimpleHash("md5",usuario.getSenha());
		
		usuario.setSenha(hash.toHex());
		
		lider.setUsuario(usuarioDAO.salvar(usuario));
		liderDAO.salvar(lider);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());

		lider.setNome("Lider 2");
		liderDAO.editar(lider);

		liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
	}

	@Test
	@Ignore
	public void listar() {

		LiderDAO liderDAO = new LiderDAO();
		List<Lider> lideres = liderDAO.lista();

		for (Lider lider : lideres) {
			System.out.println(lider.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
		
		liderDAO.excluir(lider);
	}

}
