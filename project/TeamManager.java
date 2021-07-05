package project;

public class TeamManager extends Entity implements Comparable<TeamManager>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static int count=1;
	public TeamManager(String name) {
		super(count++, name);
		
	}

	@Override
	public String toString() {
		return "TeamManager [id=" + getId() + ", name=" + getName() + "]";
	}

	@Override
	public int compareTo(TeamManager o) {
		return this.getId()-o.getId();
	}
	@Override
	public boolean equals(Object obj) {
		return compareTo((TeamManager)obj)==0;
	}
}
