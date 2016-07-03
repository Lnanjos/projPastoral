package br.org.pastoraldacrianca.DAO;

import java.util.Date;
import org.hibernate.Session;
import br.org.pastoraldacrianca.domain.CadastroDeMortes;
import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.util.HibernateUtil;

public class CadastroDeMortesDAO extends GenericDAO<CadastroDeMortes> {

	//Método para buscar a data da primeira visita de uma criança 
	public Date buscarDataCadastro(Crianca crianca) {
		Date dataCadastro = null;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Date data = (Date) sessao.createSQLQuery("select MIN(datavisita) from visita where crianca_codigo ="+crianca.getCodigo()).uniqueResult();
			
			dataCadastro = data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataCadastro;
	}

}
