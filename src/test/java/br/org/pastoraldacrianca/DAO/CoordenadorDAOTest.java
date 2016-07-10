package br.org.pastoraldacrianca.DAO;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.Coordenador;
import br.org.pastoraldacrianca.domain.Usuario;

public class CoordenadorDAOTest {
	

	@Test
	public void salvar() {

		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		Coordenador coordenador = new Coordenador();

		coordenador.setNome("Coordenador 1");
		coordenador.setEndereco("coordenador1endereco");
		coordenador.setDiocese("diocese1");
		coordenador.setParoquia("paroquia1");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario.setEmail("email@email.com");
		usuario.setSenha("123456");
		usuario.setTipo('C');
		
		SimpleHash hash = new SimpleHash("md5",usuario.getSenha());
		
		usuario.setSenha(hash.toHex());
		
		coordenador.setUsuario(usuarioDAO.salvar(usuario));
		coordenadorDAO.salvar(coordenador);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		Coordenador coordenador = coordenadorDAO.buscar(codigo);

		System.out.println(coordenador.getNome());

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		Coordenador coordenador = coordenadorDAO.buscar(codigo);

		System.out.println(coordenador.getNome());

		coordenador.setNome("Coordenador 2");

		coordenadorDAO.editar(coordenador);

		coordenadorDAO.buscar(codigo);

		System.out.println(coordenador.getNome());
	}

	@Test
	@Ignore
	public void listar() {

		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		List<Coordenador> coordenadores = coordenadorDAO.lista();

		for (Coordenador coordenador : coordenadores) {
			System.out.println(coordenador.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;

		CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
		Coordenador coordenador = coordenadorDAO.buscar(codigo);

		System.out.println(coordenador.getNome());
		
		coordenadorDAO.excluir(coordenador);
	}
}
