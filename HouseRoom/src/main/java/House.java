
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int houseId;
	@Column
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> rooms=new ArrayList<Room>();

	public House() {
		Random r = new Random();
		name = Character.getName(65 + r.nextInt(25));
		
	}

	/**
	 * @param name
	 */
	public House(String name) {
		this.name = name;
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
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	@Override
	public String toString() {
		return "House [id=" + houseId + ", name=" + name + ", rooms=" + rooms.toString() + "]";
	}

}
