package project;

public class TeamMember extends Entity implements Comparable<TeamMember> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;
	private static int count = 1;

	/**
	 * @param name
	 */
	public TeamMember(String name) {
		super(count++, name);
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + getId() + ", name=" + getName() + ", role=" + role + "]";
	}

	@Override
	public int compareTo(TeamMember o) {
		return this.getId() - o.getId();
	}

	@Override
	public boolean equals(Object obj) {
		return compareTo((TeamMember) obj) == 0;
	}
}
