import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class App {
	private static Logger logs = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		try {
			House p = new House();
			p.addRoom(new Room(15));
			p.addRoom(new Room(15));
			p.addRoom(new Room(15));
			p.addRoom(new Room(15));
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
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
