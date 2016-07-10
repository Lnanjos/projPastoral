package br.org.pastoraldacrianca.DAO;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.org.pastoraldacrianca.domain.Usuario;
import br.org.pastoraldacrianca.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{

	//email e senha serão usados para validação de login
	public Usuario autenticar(String email, String senha){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(Usuario.class);
			//criação do apelido da classe pessoa para chamada dentro do método de consulta

			consulta.add(Restrictions.eq("email",email));
			
			SimpleHash hash = new SimpleHash("md5",senha);
			
			consulta.add(Restrictions.eq("senha",hash.toHex()));
			//Converte a consulta do uniqueResult para resultado do tipo Entidade
			Usuario resultado = (Usuario) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro){
			throw erro;
		} finally{
			sessao.close();
		}
	}

}
