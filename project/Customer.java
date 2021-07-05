package project;

import java.util.Set;
import java.util.TreeSet;

public class Customer extends Entity implements Comparable<Customer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Project> projects;
	private static int count=1;
	
	
	/**
	 * @param name
	 */
	public Customer(String name) {
		super(count++, name);
		projects = new TreeSet<Project>();
		
	}


	public void addProject(Project project) {
		projects.add(project);
	}

	public void removeProject(Project project) {
		projects.remove(project);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + getId() + "\n");
		sb.append("Name: " + getName() + "\n");
		sb.append("-------------Projects-------------\n");
		for (Project project : projects) {
			sb.append("Name: "+project.getName()+"\n");
		}
		sb.append("-----------------------------------\n");
		return sb.toString();
	}

	@Override
	public int compareTo(Customer o) {
		
		return this.getId()-o.getId();
	}
	@Override
	public boolean equals(Object obj) {
		return this.getId()==((Customer)(obj)).getId();
	}
}
