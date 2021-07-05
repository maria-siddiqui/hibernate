
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private LocalDate dob;
	private String gender;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Car> cars=new ArrayList<Car>();
	
	private static String[] namesArray = { "Jhone", "Karry", "Michael", "Anne", "Marie", "Zeby", "Debora", "Max",
			"Harry", "Ronnie", "Jessy", "Katie", "Miley", "Avici", "Marley", "Zayn", "Dexter", "Mark", "Harrison",
			"Roxy" };
	private static char[] areaofCities= {'D','E','F','G','H','I','J','R','B'};
	
	
	/**
	 * @param name
	 * @param address
	 * @param dob
	 * @param gender
	 */
	public Person(String name, String address, LocalDate dob, String gender) {
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}

	/**
	 * Constructor
	 * */
	public Person() {
		Random r = new Random();
		int fName = r.nextInt(namesArray.length);
		int lName = r.nextInt(namesArray.length);
		String fname = namesArray[fName];
		String lname = namesArray[lName];
		name = fname + " " + lname;
		dob = LocalDate.of((1959 + r.nextInt(30)), (1 + r.nextInt(12)), 1 + r.nextInt(27));
		address="Sector "+areaofCities[r.nextInt(areaofCities.length)]+""+(1+r.nextInt(20))+", Street no "+(1+r.nextInt(45))+", House no "+(1+r.nextInt(11000))+" Islamabad.";
		int x = r.nextInt(namesArray.length);
		if (x % 2 == 0)
			gender = "male";
		else
			gender = "female";
		for (int i = 0; i < r.nextInt(6); i++) {
			this.addCar(new Car());
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", gender=" + gender
				+ ", cars=" + cars.toString() + "]";
	}

	public List<Car> getCars() {
		return cars;
	}
//	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			Person p = new Person();
//			System.out.println(p.toString());
//		}
//	}
}
