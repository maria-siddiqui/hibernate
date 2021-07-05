import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomid;
	private String type;
	private double size;
	
	/**
	 * @param size
	 */
	public Room(double size) {
		this.type = "Bedroom";
		this.size = size;
	}

	/**
	 * @param type
	 * @param size
	 */
	public Room(String type, double size) {
		this.type = type;
		this.size = size;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	
	@Override
	public String toString() {
		return "Room [id=" + roomid + ", type=" + type + ", size=" + size + "]";
	}

}
