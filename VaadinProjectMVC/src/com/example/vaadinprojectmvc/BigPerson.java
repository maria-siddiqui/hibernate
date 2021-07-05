package com.example.vaadinprojectmvc;

import java.util.ArrayList;

public class BigPerson extends Person {
	private ArrayList<Person> childrens = new ArrayList<Person>();

	public int getChildCount() {
		return getChildrens().size();
	}

	public void addChildAt(int i, Person child) {
		getChildrens().add(i, child);
	}

	public Person getChild(int i) {
		return getChildrens().get(i);
	}

	public void removeChildAt(int index) {
		getChildrens().remove(index);
	}

	/**
	 * @return the childrens
	 */
	public ArrayList<Person> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(ArrayList<Person> childrens) {
		this.childrens = childrens;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
