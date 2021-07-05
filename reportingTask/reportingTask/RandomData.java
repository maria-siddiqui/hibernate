package reportingTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RandomData {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	private String fullName;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private long telephone;
	private static String[] namesArray = { "Jhone", "Karry", "Michael", "Anne", "Marie", "Zeby", "Debora", "Max",
			"Harry", "Ronnie", "Jessy", "Katie", "Miley", "Avici", "Marley", "Zayn", "Dexter", "Mark", "Harrison",
			"Roxy" };

	public RandomData() {
		Random r = new Random();
		int fName = r.nextInt(20);
		int lName = r.nextInt(20);
		firstName = namesArray[fName];
		lastName = namesArray[lName];
		fullName = firstName + " " + lastName;
		telephone =  1000000+r.nextInt(8999999);
		dateOfBirth = (1+r.nextInt(27)) + "-" + (1+r.nextInt(12)) + "-" + (1959 + r.nextInt(30));
		
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the telephone
	 */
	public long getTelephone() {
		return telephone;
	}

	@Override
	public String toString() {
		return "RandomData [fullName=" + fullName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", telephone=" + telephone + "]";
	}

	/**
	 * @return the namesArray
	 */
	public static String[] getNamesArray() {
		return namesArray;
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
		  	for (int i = 0; i <30000; i++) {
				RandomData r= new  RandomData();
				System.out.println(r.toString());
		      System.out.println("Inserting records into the table...");
		     
		      pstmt = conn.prepareStatement("INSERT INTO employee(fullname,fname,lname,dob,phone) " +
	                   "VALUES (?,?,?,?,?)");
		      pstmt.setString(1, r.fullName);
		      pstmt.setString(2, r.firstName);
		      pstmt.setString(3, r.lastName);
		      pstmt.setString(4, r.dateOfBirth);
		      pstmt.setLong(5, r.telephone);
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
