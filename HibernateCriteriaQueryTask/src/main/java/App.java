import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class App {
	public static Logger logger=Logger.getLogger(App.class);
public static void main(String[] args) {
	listPerson();
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
//	for (int i = 0; i < 10; i++) {
//		em.persist(new Person());
//	}
	//List<Person> p=(List<Person>)em.createQuery("select p from Person p",Person.class).getResultList();
	
	List<Person> p=(List<Person>)em.createQuery("select p from Person p",Person.class).getResultList();
	System.out.println("List of All person with their cars");
	printPerson(p);
	
	System.out.println("*****************************************************************");
	List<Person> x=new ArrayList<Person>();
for (Person person : p) {
	if(person.getName().charAt(0)=='A') {
		x.add(person);
	}
}
System.out.println("list of persons where person name start with 'A'");
	printPerson(x);

	x.clear();
	System.out.println("*****************************************************************");

	System.out.println("list of persons where gender is male and own more than 2 cars");
	for (Person person : p) {
		if(person.getCars().size()>2&&person.getGender().equals("male"))
		System.out.println(person);
	}
	System.out.println("*****************************************************************");

	System.out.println("All Cars who belong to people whose name begins with a 'A'");
	printPerson(p, 'A');
	
	
	em.getTransaction().commit();
	em.close();
}
public static void printCars(List<Car> cars) {
	for (Car car : cars) {
		System.out.println(car.toString());
	}
}
public static void printPerson(List<Person> persons) {
	for (Person person : persons) {
		System.out.println("Name: "+person.getName());
		System.out.println("****************Cars****************");
		printCars(person.getCars());
	}
}

public static void printPerson(List<Person> persons,char nameStartWith) {
	for (Person person : persons) {
		if(person.getName().charAt(0)=='A') {
			System.out.println("Name: "+person.getName());
		}
	}
}

/* Method to  READ all the person where name start with A */
public static void listPerson( ) {
	   
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "pu" );  
     EntityManager em = emf.createEntityManager();  
     em.getTransaction().begin( );  
       
     CriteriaBuilder cb=em.getCriteriaBuilder();  
       
     AbstractQuery<Person> cq=cb.createQuery(Person.class);  
      
       
    Root<Person> stud=cq.from(Person.class);  
      
 
    cq.where(cb.like(stud.<String>get("name"), "A%"));  
     CriteriaQuery<Person> select = ((CriteriaQuery<Person>) cq).select(stud);  
     TypedQuery<Person> tq = em.createQuery(select);  
     List<Person> list = tq.getResultList();  
       
   System.out.println("Students name starting with A");  
       
     System.out.print("s_id");  
        System.out.print("\t s_name");  
        System.out.println("\t s_age");  
       
     for(Person s:list)  
     {  
     System.out.println(s);  
     }  
  em.getTransaction().commit();  
     em.close();  
     emf.close();    
}
public static List<Person> listPerson(List<Person> persons,char nameStartWith) {
	List<Person> xx=new ArrayList<Person>();
	for (Person person : persons) {
		if(person.getName().charAt(0)=='A') {
			xx.add(person);
		}
	}
	return xx;
}
}
