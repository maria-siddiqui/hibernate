package project;

import java.util.Set;
import java.util.TreeSet;

public class Project extends Entity implements Comparable<Project>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<TeamMember> teamMembers;
	private TeamManager teamManager;
	private static int count=1;
	
	public Project(String name,TeamManager teamManager) {
		super(count++, name);
		teamMembers = new TreeSet<TeamMember>();
		this.teamManager=teamManager;
		
	}

	public void addTeam(TeamMember teamMember) {
		teamMembers.add(teamMember);
	}

	public void removeTeam(TeamMember teamMember) {
		teamMembers.remove(teamMember);
	}

	public TeamManager getTeamManager() {
		return teamManager;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + getId() + "\n");
		sb.append("Name: " + getName() + "\n");
		sb.append("-------------TeamManager-------------\n");
		sb.append(teamManager.toString()+"\n");
		sb.append("-------------TeamMembers-------------\n");
		for (TeamMember teamMember : teamMembers) {
			sb.append(teamMember.toString()+"\n");
		}
		sb.append("-----------------------------------\n");
		return sb.toString();
	}

	@Override
	public int compareTo(Project o) {
		return this.getId()-o.getId();
	}
	@Override
	public boolean equals(Object obj) {
		return compareTo((Project)obj)==0;
	}
}
