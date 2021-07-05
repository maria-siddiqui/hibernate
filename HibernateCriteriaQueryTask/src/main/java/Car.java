import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String regno;
private String model;


public Car() {
Random r= new Random();
String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
regno=""+abc.charAt(r.nextInt(abc.length()-1))+abc.charAt(r.nextInt(abc.length()-1))+abc.charAt(r.nextInt(abc.length()-1));
regno+=r.nextInt(9);
regno+=r.nextInt(9);
regno+=r.nextInt(9);
model=""+abc.charAt(abc.length()-1)+abc.charAt(abc.length()-1)+(1+r.nextInt(9));
}

/**
 * @param regno
 * @param model
 */
public Car(String regno, String model) {
	this.regno = regno;
	this.model = model;
}


/**
 * @return the regno
 */
public String getRegno() {
	return regno;
}


/**
 * @param regno the regno to set
 */
public void setRegno(String regno) {
	this.regno = regno;
}


/**
 * @return the model
 */
public String getModel() {
	return model;
}


/**
 * @param model the model to set
 */
public void setModel(String model) {
	this.model = model;
}


/**
 * @return the id
 */
public int getId() {
	return id;
}


@Override
public String toString() {
	return "Car [id=" + id + ", regno=" + regno + ", model=" + model + "]";
}



}
