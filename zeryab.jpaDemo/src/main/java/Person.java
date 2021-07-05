import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "person")
public class Person {
	private static int count=1;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "gender")
	private String gender;

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
		this.id=count++;
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

	@Override
	public String toString() {
		return "Person [ name=" + name + ", address=" + address + ", dob=" + dob + ", gender=" + gender
				+ "]";
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Person p = new Person();
			System.out.println(p.toString());
		}
	}
}
