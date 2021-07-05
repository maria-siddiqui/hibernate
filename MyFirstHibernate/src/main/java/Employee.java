

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="empdata")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private int id;
	 @Column(name="fname")
private String fname;
	 @Column(name="lname")
private String lname;
	 @Column(name="department")
private String department;
	 @Column(name="salary")
private double salary;

private static String[] namesArray = { "Jhone", "Karry", "Michael", "Anne", "Marie", "Zeby", "Debora", "Max",
		"Harry", "Ronnie", "Jessy", "Katie", "Miley", "Avici", "Marley", "Zayn", "Dexter", "Mark", "Harrison",
		"Roxy" };
private static String[] departments= {"SEO","NETWORKING","DEVELOPMENT","DESIGNING","MANAGEMENT","TESTING"};
/**
 * @param fname
 * @param lname
 * @param department
 * @param salary
 */
public Employee(String fname, String lname, String department, double salary) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.department = department;
	this.salary = salary;
}

public Employee() {
	Random r = new Random();
	int fName = r.nextInt(20);
	int lName = r.nextInt(20);
	fname = namesArray[fName];
	lname = namesArray[lName];
	department =  departments[r.nextInt(departments.length)];
	salary=2.5*r.nextInt(150000);
}
/**
 * @return the fname
 */
public String getFname() {
	return fname;
}
/**
 * @param fname the fname to set
 */
public void setFname(String fname) {
	this.fname = fname;
}
/**
 * @return the lname
 */
public String getLname() {
	return lname;
}
/**
 * @param lname the lname to set
 */
public void setLname(String lname) {
	this.lname = lname;
}
/**
 * @return the department
 */
public String getDepartment() {
	return department;
}
/**
 * @param department the department to set
 */
public void setDepartment(String department) {
	this.department = department;
}
/**
 * @return the salary
 */
public double getSalary() {
	return salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [fname=" + fname + ", lname=" + lname + ", department=" + department + ", salary=" + salary + "]";
}



}
