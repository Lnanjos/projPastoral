package br.org.pastoraldacrianca.DAO;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.domain.Lider;
import br.org.pastoraldacrianca.domain.NaoAtendimento;

public class NaoAtendimentoDAOTest {

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

		NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
		NaoAtendimento naoAtendimento = new NaoAtendimento();

		naoAtendimento.setCrianca(crianca);
		naoAtendimento.setLider(lider);
		naoAtendimento.setDataNA(new Date("01/01/16"));
		naoAtendimento.setEncaminhado("Pronto Atendimento");
		naoAtendimento.setRespAt("Maria Atendente da Silva");
		naoAtendimento.setMotivoNaoAT("Não tinha febre alta");
		naoAtendimento.setSintoma("Tosse e vômito");

		naoAtendimentoDAO.salvar(naoAtendimento);

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
		NaoAtendimento naoAtendimento = naoAtendimentoDAO.buscar(codigo);

		System.out.println(naoAtendimento.getCrianca().getNome());
		System.out.println(naoAtendimento.getLider().getNome());
		System.out.println(naoAtendimento.getDataNA().getDay() + "/"
				+ naoAtendimento.getDataNA().getMonth() + "/"
				+ naoAtendimento.getDataNA().getYear());
		System.out.println("Para onde foi encaminhado?"
				+ naoAtendimento.getEncaminhado());
		System.out.println("Responsável pelo Atendimento do SUS :"
				+ naoAtendimento.getRespAt());
		System.out.println("Motivo do não atendimento: "
				+ naoAtendimento.getMotivoNaoAT());
		System.out.println("Sintomas apresentados: "
				+ naoAtendimento.getSintoma());

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {

		Long codigo = 1L;

		NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
		NaoAtendimento naoAtendimento = naoAtendimentoDAO.buscar(codigo);

		System.out.println(naoAtendimento.getCrianca().getNome());
		System.out.println(naoAtendimento.getLider().getNome());
		System.out.println(naoAtendimento.getDataNA().getDay() + "/"
				+ naoAtendimento.getDataNA().getMonth() + "/"
				+ naoAtendimento.getDataNA().getYear());
		System.out.println("Para onde foi encaminhado?"
				+ naoAtendimento.getEncaminhado());
		System.out.println("Responsável pelo Atendimento do SUS :"
				+ naoAtendimento.getRespAt());
		System.out.println("Motivo do não atendimento: "
				+ naoAtendimento.getMotivoNaoAT());
		System.out.println("Sintomas apresentados: "
				+ naoAtendimento.getSintoma());

		Long codCrianca = 1L;
		Long codLider = 1L;

		CriancaDAO criancaDAO = new CriancaDAO();
		Crianca crianca = criancaDAO.buscar(codCrianca);

		LiderDAO liderDAO = new LiderDAO();
		Lider lider = liderDAO.buscar(codLider);

		naoAtendimento.setCrianca(crianca);
		naoAtendimento.setLider(lider);
		naoAtendimento.setDataNA(new Date("01/01/16"));
		naoAtendimento.setEncaminhado("Pronto Atendimento");
		naoAtendimento.setRespAt("Maria Não Atendente da Silva");
		naoAtendimento.setMotivoNaoAT("Não tinha");
		naoAtendimento.setSintoma("Alergia no corpo");

		naoAtendimentoDAO.editar(naoAtendimento);

	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void listar() {

		NaoAtendimentoDAO naoAtendimentoDAO = new NaoAtendimentoDAO();
		List<NaoAtendimento> naoAtendimentos = naoAtendimentoDAO.lista();

		for (NaoAtendimento naoAtendimento : naoAtendimentos) {
			System.out.println(naoAtendimento.getCrianca().getNome());
			System.out.println(naoAtendimento.getLider().getNome());
			System.out.println(naoAtendimento.getDataNA().getDay() + "/"
					+ naoAtendimento.getDataNA().getMonth() + "/"
					+ naoAtendimento.getDataNA().getYear());
			System.out.println("Para onde foi encaminhado?"
					+ naoAtendimento.getEncaminhado());
			System.out.println("Responsável pelo Atendimento do SUS :"
					+ naoAtendimento.getRespAt());
			System.out.println("Motivo do não atendimento: "
					+ naoAtendimento.getMotivoNaoAT());
			System.out.println("Sintomas apresentados: "
					+ naoAtendimento.getSintoma());
		}

	}
}
