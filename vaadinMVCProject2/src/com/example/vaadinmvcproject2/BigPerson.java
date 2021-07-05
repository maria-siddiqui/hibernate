package com.example.vaadinmvcproject2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class BigPerson extends Person {
	private ArrayList<Person> childrens = new ArrayList<Person>();
	
	public int getChildCount() {
		return getChildrens().size();
	}

	public void addChildAt(int i, Person child) {
		System.out.println("AT CHILD AT");
	
		getChildrens().add(i, child);
		PropertyChangeEvent event = new PropertyChangeEvent(this, "childrens", null, childrens);
		getPropChangeSupp().firePropertyChange(event);
	}

	public Person getChild(int i) {
		return getChildrens().get(i);
	}

	public void removeChildAt(int index) {
		getChildrens().remove(index);
		PropertyChangeEvent event = new PropertyChangeEvent(this, "childrens", null, childrens);
		getPropChangeSupp().firePropertyChange(event);
	}

	/**
	 * @return the childrens
	 */
	public ArrayList<Person> getChildrens() {
		return childrens;
	}

	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		super.addPropertyChangeListener(listener);
		System.out.println("BigPerson addPropertyChangeListener");	
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
