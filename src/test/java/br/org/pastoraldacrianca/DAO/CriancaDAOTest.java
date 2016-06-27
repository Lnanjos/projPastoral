package br.org.pastoraldacrianca.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.Crianca;

public class CriancaDAOTest {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Crianca crianca = new Crianca();
		CriancaDAO criancaDAO = new CriancaDAO();

		crianca.setNome("Criança 1");
		crianca.setNomeMae("Mae crianca 1");
		crianca.setPesoNascimento(new BigDecimal(2));
		crianca.setDataNascimento(new Date("11/11/11"));
		crianca.setEndereco("Rua da Crianca1");

		criancaDAO.salvar(crianca);

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codigo);

		System.out.println(crianca.getNome());
		System.out.println(crianca.getNomeMae());
		System.out.println(crianca.getPesoNascimento());
		System.out.println(crianca.getDataNascimento().getDay() + "/"
				+ crianca.getDataNascimento().getMonth() + "/"
				+ crianca.getDataNascimento().getYear());
		System.out.println(crianca.getEndereco());

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {

		Long codigo = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codigo);

		System.out.println(crianca.getNome());
		System.out.println(crianca.getNomeMae());
		System.out.println(crianca.getPesoNascimento());
		System.out.println(crianca.getDataNascimento().getDay() + "/"
				+ crianca.getDataNascimento().getMonth() + "/"
				+ crianca.getDataNascimento().getYear());
		System.out.println(crianca.getEndereco());

		crianca.setNome("Criança 2");
		crianca.setNomeMae("Mae crianca 2");
		crianca.setPesoNascimento(new BigDecimal(2.900));
		crianca.setDataNascimento(new Date("11/11/11"));
		crianca.setEndereco("Rua da Crianca1");

		criancaDAO.editar(crianca);

		crianca = criancaDAO.buscar(codigo);

		System.out.println(crianca.getNome());
		System.out.println(crianca.getNomeMae());
		System.out.println(crianca.getPesoNascimento());
		System.out.println(crianca.getDataNascimento().getDay() + "/"
				+ crianca.getDataNascimento().getMonth() + "/"
				+ crianca.getDataNascimento().getYear());
		System.out.println(crianca.getEndereco());
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void listar() {

		CriancaDAO criancaDAO = new CriancaDAO();
		List<Crianca> criancas = criancaDAO.lista();

		for (Crianca crianca : criancas) {
			System.out.println(crianca.getNome());
			System.out.println(crianca.getNomeMae());
			System.out.println(crianca.getPesoNascimento());
			System.out.println(crianca.getDataNascimento().getDay() + "/"
					+ crianca.getDataNascimento().getMonth() + "/"
					+ crianca.getDataNascimento().getYear());
			System.out.println(crianca.getEndereco());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codigo);

		System.out.println(crianca.getNome());
		System.out.println(crianca.getNomeMae());
		System.out.println(crianca.getPesoNascimento());
		System.out.println(crianca.getDataNascimento().getDay() + "/"
				+ crianca.getDataNascimento().getMonth() + "/"
				+ crianca.getDataNascimento().getYear());
		System.out.println(crianca.getEndereco());

		criancaDAO.excluir(crianca);
	}

}
