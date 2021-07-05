
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Logger logger = Logger.getLogger(HibernateUtil.class);

    public static void main(String[] args) {
    	try {
    		//Creating configuration with specified class
    		//another way of doing is to specify the hibernate config file name 
    		//like Configuration conf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class);

    		Configuration conf=new Configuration().configure().addAnnotatedClass(Person.class);
    		//session factory use to build session from configuration 
    		SessionFactory factory = conf.buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			logger.trace(factory);
			logger.trace(session);
			logger.trace(t);
			for (int i = 0; i < 5; i++) {
				Person ex = new Person();
				session.save(ex);
				logger.trace(ex);
			}

			t.commit();
			logger.debug("successfully saved");
			
			factory.close();
			session.close();
		} catch (HibernateException exception) {
			logger.error(exception.getMessage());
			
		}
    }
}
