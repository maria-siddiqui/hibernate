package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Scanner;
import java.util.TreeSet;

public class WorkSpace {
	public static TreeSet<TeamManager> teamManagers= new TreeSet<TeamManager>();
	public static TreeSet<TeamMember> teamMembers= new TreeSet<TeamMember>();
	public static TreeSet<Project> projects= new TreeSet<Project>();
	public static TreeSet<Customer> customers= new TreeSet<Customer>();
	public static void main(String[] args) {
		try {
			readFromFile();
		} catch (Exception e) {
			System.out.println("Files contain no data or invalid data");
		}
		Scanner sc = new Scanner(System.in);
		int choise = -1;
		while (choise != 6) {
			System.out.println("Enter 1 to add Project");
			System.out.println("Enter 2 to add Customer");
			System.out.println("Enter 3 to add Team members");
			System.out.println("Enter 4 to add Team manager");
			System.out.println("Enter 5 to add view details");
			System.out.println("Enter 6 to Exit and Save Data");
			choise = sc.nextInt();
			doAction(choise);
		}
		sc.close();
	}

	private static void doAction(int choise) {
		switch (choise) {
		case 1:
			addProject();
			break;
		case 2:
			addCustomer();
			break;
		case 3:
			addTeamMember();

			break;
		case 4:
			addTeamManager();

			break;
		case 5:
			viewDetails();
			break;
		case 6:
			System.out.println("Thanks for Using");
			savetoFile();
			break;

		default:
			break;
		}
	}

	private static void savetoFile(	) {
		
		try
        {   
            FileOutputStream file = new FileOutputStream("members.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(teamMembers);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
		try
        {   
            FileOutputStream file = new FileOutputStream("managers.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(teamManagers);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
		try
        {   
            FileOutputStream file = new FileOutputStream("projects.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(projects);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
		
		try
        {   
            FileOutputStream file = new FileOutputStream("customers.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(customers);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
		

	}
	@SuppressWarnings("unchecked")
	private static void readFromFile() {
		try {
			  
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         ("members.ser");
            ObjectInputStream in = new ObjectInputStream
                                         (file);
  
            // Method for deserialization of object
            teamMembers = (TreeSet<TeamMember>)in.readObject();
  
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
           
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
		try {
			  
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         ("managers.ser");
            ObjectInputStream in = new ObjectInputStream
                                         (file);
  
            // Method for deserialization of object
            teamManagers = (TreeSet<TeamManager>)in.readObject();
  
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
           
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
		try {
			  
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         ("projects.ser");
            ObjectInputStream in = new ObjectInputStream
                                         (file);
  
            // Method for deserialization of object
            projects = (TreeSet<Project>)in.readObject();
  
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
           
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
		try {
			  
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         ("customers.ser");
            ObjectInputStream in = new ObjectInputStream
                                         (file);
  
            // Method for deserialization of object
            customers = (TreeSet<Customer>)in.readObject();
  
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
           
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
	}
	private static void viewDetails() {
		System.out.println("Customers");
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
		System.out.println("Projects");

		for (Project project : projects) {
			System.out.println(project.toString());
		}
	}

	private static void addTeamManager() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Team Manager");
		String name=sc.nextLine();
		teamManagers.add(new TeamManager( name));
	}

	private static void addTeamMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Team Member");
		String name=sc.nextLine();
		System.out.println("Enter role of Team Member");
		String role=sc.nextLine();
		TeamMember tm=new TeamMember( name);
		tm.setRole(role);
		teamMembers.add(tm);
	}

	private static void addCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Customer");
		String name=sc.nextLine();
		Customer c=new Customer( name);
		System.out.println("Enter no of Projects");
		int n=sc.nextInt();
		for (int i = 0; i < n; i++) {
			sc=new Scanner(System.in);
			System.out.println("Enter name of Project");
			String pName=sc.nextLine();
			for (Project pp : projects) {
				if(pp.getName().toLowerCase().equals(pName.toLowerCase())) {
				c.addProject(pp);	
				}
			}
		}
		customers.add(c);
		
	}

	private static void addProject() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Project");
		String name=sc.nextLine();
		System.out.println("Enter name of Project Manager");
		String name1=sc.nextLine();
		TeamManager x=null;
		for (TeamManager t : teamManagers) {
			if(t.getName().toLowerCase().equals(name1.toLowerCase())) {
				x=t;
				break;
			}
		}
		if(x!=null) {
			Project p=new Project(name,x);
			System.out.println("Enter no of team members");
			int n=sc.nextInt();
			sc=new Scanner(System.in);
			for (int i = 0; i < n; i++) {
				System.out.println("Enter name of team member");
				String tmName=sc.nextLine();
				for (TeamMember tx : teamMembers) {
					if(tx.getName().toLowerCase().equals(tmName.toLowerCase())) {
						p.addTeam(tx);
						break;
					}
				}
			}
			projects.add(p);
			
		}
		else
			System.out.println("No Manager Exist with this name");
	}
}
