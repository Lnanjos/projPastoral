package br.org.pastoraldacrianca.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.org.pastoraldacrianca.domain.Crianca;
import br.org.pastoraldacrianca.util.HibernateUtil;

public class CriancaDAO extends GenericDAO<Crianca>{

	@SuppressWarnings("unchecked")
	public List<Crianca> listaOrCriancasViva(){
		//acessa a fábrica de e...
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			//atribui a classe em execução a consulta
			Criteria consulta = sessao.createCriteria(Crianca.class);
			//define restrição para retornar apenas crianças vivas
			consulta.add(Restrictions.eq("vivo", true));
			//define a ordenação
			consulta.addOrder( Order.asc("nome"));
			//atribui a consulta ao resultado do tipo List
			List<Crianca> resultado = consulta.list();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
		
	}
	
}
