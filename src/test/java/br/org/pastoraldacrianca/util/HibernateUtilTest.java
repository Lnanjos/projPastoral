package br.org.pastoraldacrianca.util;

import org.hibernate.Session;
import org.junit.Test;
import br.org.pastoraldacrianca.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		Session sessao=HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
