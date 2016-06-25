package br.org.pastoraldacrianca.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.Visita;

public class VisitaDAOTest {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Long codCrianca = 1L;
		Long codLider = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codCrianca);

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codLider);

		VisitaDAO visitaDAO = new VisitaDAO();
		Visita visita = new Visita();

		visita.setCrianca(crianca);
		visita.setLider(lider);
		visita.setDataVisita(new Date("11/12/11"));
		visita.setAtendimento("sem necessidade");
		visita.setPeso(new BigDecimal(2.100));
		visita.setObservacao("Nada a declarar");

		visitaDAO.salvar(visita);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		VisitaDAO visitaDAO = new VisitaDAO();
		Visita visita = visitaDAO.buscar(codigo);

		System.out.println(visita.getCrianca().getNome());
		System.out.println(visita.getLider().getNome());
		System.out.println(visita.getPeso());
		System.out.println(visita.getDataVisita().getDay() + "/"
				+ visita.getDataVisita().getMonth() + "/"
				+ visita.getDataVisita().getYear());
		System.out.println("Atendimento = " + visita.getAtendimento());

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {

		Long codigo = 1L;

		VisitaDAO visitaDAO = new VisitaDAO();
		Visita visita = visitaDAO.buscar(codigo);

		System.out.println(visita.getCrianca().getNome());
		System.out.println(visita.getLider().getNome());
		System.out.println(visita.getPeso());
		System.out.println(visita.getDataVisita().getDay() + "/"
				+ visita.getDataVisita().getMonth() + "/"
				+ visita.getDataVisita().getYear());
		System.out.println("Atendimento = " + visita.getAtendimento());

		Long codCrianca = 1L;
		Long codLider = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codCrianca);

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codLider);

		visita.setCrianca(crianca);
		visita.setLider(lider);
		visita.setDataVisita(new Date("11/01/12"));
		visita.setAtendimento("sem necessidade");
		visita.setPeso(new BigDecimal(2.600));
		visita.setObservacao("gripe");

		visitaDAO.editar(visita);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void listar() {

		VisitaDAO visitaDAO = new VisitaDAO();
		List<Visita> visitas = visitaDAO.lista();

		for (Visita visita : visitas) {
			System.out.println(visita.getCrianca().getNome());
			System.out.println(visita.getLider().getNome());
			System.out.println(visita.getPeso());
			System.out.println(visita.getDataVisita().getDay() + "/"
					+ visita.getDataVisita().getMonth() + "/"
					+ visita.getDataVisita().getYear());
			System.out.println("Atendimento = " + visita.getAtendimento());
		}
	}
	
	

}
