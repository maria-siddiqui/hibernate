import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class App {
	private static Logger logs= Logger.getLogger(App.class); 
public static void main(String[] args) {
	try {
		Person p= new Person();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
		EntityManager em=emf.createEntityManager();
		
		
		//Person p =em.find(Person.class,1);
		em.getTransaction().begin();
		logs.trace(p);
		logs.trace(emf);
		logs.trace(em);
		em.persist(p);
		logs.debug(p);
		logs.debug("successfully saved");
		System.out.println(p);
		em.getTransaction().commit();
		
	} catch (Exception e) {
		logs.error(e.getMessage());
	}
}
}
