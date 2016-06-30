package br.org.pastoraldacrianca.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.CadastroDeMortes;
import br.org.pastoraldacrianca.domain.Crianca;


public class CadastroDeMortesDAOTest {


	@Test
	public void salvar() {

		Long codCrianca = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codCrianca);

		CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
		CadastroDeMortes cadastro = new CadastroDeMortes();

		cadastro.setCrianca(crianca);
		cadastro.setAssistenciaMedica(true);
		cadastro.setCausaDaMorte("H1N1");
		cadastro.setDescricao("A criança manifestou sintomas após tomar a vacina da H1N1,e acabou falecendo");

		cadastroDAO.salvar(cadastro);

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
		CadastroDeMortes cadastro = cadastroDAO.buscar(codigo);

		System.out.println(cadastro.getCrianca().getNome());
		System.out.println(cadastro.getCrianca().getNumSUS());
		System.out.println(cadastro.getCrianca().getNomeMae());
		System.out.println(cadastro.getCrianca().getDataNascimento().getDay()
				+ "/" + cadastro.getCrianca().getDataNascimento().getMonth()
				+ "/" + cadastro.getCrianca().getDataNascimento().getYear());
		System.out.println(cadastro.getCausaDaMorte());
		System.out.println(cadastro.getDescricao());
		System.out.println(cadastro.isAssistenciaMedica());

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {

		Long codigo = 1L;
		Long codCrianca = 1L;

		CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
		CadastroDeMortes cadastro = cadastroDAO.buscar(codigo);

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codCrianca);

		System.out.println(cadastro.getCrianca().getNome());
		System.out.println(cadastro.getCrianca().getNumSUS());
		System.out.println(cadastro.getCrianca().getNomeMae());
		System.out.println(cadastro.getCrianca().getDataNascimento().getDay()
				+ "/" + cadastro.getCrianca().getDataNascimento().getMonth()
				+ "/" + cadastro.getCrianca().getDataNascimento().getYear());
		System.out.println(cadastro.getCausaDaMorte());
		System.out.println(cadastro.getDescricao());
		System.out.println(cadastro.isAssistenciaMedica());

		cadastro.setCrianca(crianca);
		cadastro.setAssistenciaMedica(true);
		cadastro.setCausaDaMorte("H1N1");
		cadastro.setDescricao("A criança manifestou sintomas após tomar a vacina da H1N1,e acabou falecendo");

		cadastroDAO.editar(cadastro);

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void listar() {

		CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
		List<CadastroDeMortes> mortes = cadastroDAO.lista();

		for (CadastroDeMortes cadastro : mortes) {

			System.out.println(cadastro.getCrianca().getNome());
			System.out.println(cadastro.getCrianca().getNumSUS());
			System.out.println(cadastro.getCrianca().getNomeMae());
			System.out
					.println(cadastro.getCrianca().getDataNascimento().getDay()
							+ "/"
							+ cadastro.getCrianca().getDataNascimento()
									.getMonth()
							+ "/"
							+ cadastro.getCrianca().getDataNascimento()
									.getYear());
			System.out.println(cadastro.getCausaDaMorte());
			System.out.println(cadastro.getDescricao());
			System.out.println(cadastro.isAssistenciaMedica());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		CadastroDeMortesDAO cadastroDAO = new CadastroDeMortesDAO();
		CadastroDeMortes cadastro = cadastroDAO.buscar(codigo);


		System.out.println(cadastro.getCrianca().getNome());
		System.out.println(cadastro.getCrianca().getNumSUS());
		System.out.println(cadastro.getCrianca().getNomeMae());
		System.out.println(cadastro.getCrianca().getDataNascimento().getDay()
				+ "/" + cadastro.getCrianca().getDataNascimento().getMonth()
				+ "/" + cadastro.getCrianca().getDataNascimento().getYear());
		System.out.println(cadastro.getCausaDaMorte());
		System.out.println(cadastro.getDescricao());
		System.out.println(cadastro.isAssistenciaMedica());

		cadastroDAO.excluir(cadastro);
	}

}
