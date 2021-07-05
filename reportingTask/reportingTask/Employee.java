package reportingTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Employee {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
private String fname;
private String lname;
private String department;
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


public static void main(String[] args) {

	
	Connection conn = null;
	PreparedStatement pstmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      
	      //STEP 4: Execute a query
	  	for (int i = 0; i <30; i++) {
			Employee r= new  Employee();
			System.out.println(r.toString());
	      System.out.println("Inserting records into the table...");
	     
	      pstmt = conn.prepareStatement("INSERT INTO empdata(fname,lname,department,salary) " +
                   "VALUES (?,?,?,?)");
	      pstmt.setString(1, r.fname);
	      pstmt.setString(2, r.lname);
	      pstmt.setString(3, r.department);
	      pstmt.setDouble(4, r.salary);
	      pstmt.executeUpdate();
	    
	      System.out.println("Inserted records into the table...");
	  	}
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(pstmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
}

}

}
