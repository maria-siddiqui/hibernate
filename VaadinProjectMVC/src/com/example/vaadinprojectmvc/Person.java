package com.example.vaadinprojectmvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Person {
	private static int count=1;
	
	private int id;
	private String name;
	private int age;
	private boolean married;
	private static String[] namesArray = { "Kia", "Jhon", "Mark", "Max", "Ronie", "Julie", "Alex", "Randy" };
	private PropertyChangeSupport propChangeSupp;
	public Person() {
		id=count++;
		Random r = new Random();
		int fName = r.nextInt(namesArray.length);
		int lName = r.nextInt(namesArray.length);
		String fname = namesArray[fName];
		String lname = namesArray[lName];
		name = fname + " " + lname;
		age = 20 + r.nextInt(30);
		int x = r.nextInt(namesArray.length);
		if (x % 2 == 0)
			married = true;
		else
			married = false;
		
		propChangeSupp = new PropertyChangeSupport(this);

	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param married
	 */
	public Person(int id, String name, int age, boolean married) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.married = married;
		propChangeSupp = new PropertyChangeSupport(this);
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
		String oldname = this.name;
		this.name = name;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "name", oldname, name);
		propChangeSupp.firePropertyChange(event);
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		int oldage = this.age;
		this.age = age;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "age", oldage, age);
		propChangeSupp.firePropertyChange(event);
	}

	/**
	 * @return the married
	 */
	public boolean isMarried() {
		return married;
	}

	/**
	 * @param married the married to set
	 */
	public void setMarried(boolean married) {
		boolean oldstatus = this.married;
		this.married=married;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "married", oldstatus, married);
		propChangeSupp.firePropertyChange(event);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		int oldid = this.id;
		this.id = id;
		PropertyChangeEvent event = new PropertyChangeEvent(this, "id", oldid, id);
		propChangeSupp.firePropertyChange(event);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.addPropertyChangeListener(listener);
		System.out.println("Person addPropertyChangeListener");
	}
	
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.removePropertyChangeListener(listener);
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + " [name=" + name + ", age=" + age + ", married=" + married + "]";
	}

}
