package br.org.pastoraldacrianca.DAO;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.org.pastoraldacrianca.domain.Lider;

public class LiderDAOTest {

	@Test
	public void salvar() {

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = new Lider();

		lider.setNome("Lider 1");
		lider.setEmail("lider@1.com");
		lider.setSenha("lider1");
		lider.setEndereco("lider1endereco");

		liderDAO.salvar(lider);
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
		System.out.println(lider.getEmail());
		System.out.println(lider.getSenha());

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
		System.out.println(lider.getEmail());
		System.out.println(lider.getSenha());

		lider.setNome("Lider 2");
		lider.setEmail("lider@2.com");
		lider.setSenha("lider2");

		liderDAO.editar(lider);

		liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
		System.out.println(lider.getEmail());
		System.out.println(lider.getSenha());
	}

	@Test
	@Ignore
	public void listar() {

		LiderDAO liderDAO = new LiderDAO();
		List<Lider> lideres = liderDAO.lista();

		for (Lider lider : lideres) {
			System.out.println(lider.getNome());
			System.out.println(lider.getEmail());
			System.out.println(lider.getSenha());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codigo);

		System.out.println(lider.getNome());
		System.out.println(lider.getEmail());
		System.out.println(lider.getSenha());
		
		liderDAO.excluir(lider);
	}

}
