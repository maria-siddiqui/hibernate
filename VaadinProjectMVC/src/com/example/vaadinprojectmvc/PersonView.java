package com.example.vaadinprojectmvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.vaadin.ui.Window;

public class PersonView extends Window implements PropertyChangeListener {
	private Person person;
	private PersonEditor personEditor;
	private java.beans.PropertyChangeSupport propChangeSupp;

	public PersonView(Person person) {
		propChangeSupp = new java.beans.PropertyChangeSupport(this);
		setPerson(person);
		setPersonEditor(new PersonEditor(person));
		addComponent(this.personEditor);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		propChangeSupp.firePropertyChange(arg0);
		System.out.println("PersonView Proper Change Event");
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.removePropertyChangeListener(listener);
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		Person old = this.person;
		this.person = person;
		person.addPropertyChangeListener(this);
		propChangeSupp.firePropertyChange("person", old, person);

	}

	/**
	 * @param person the person to set
	 */
	public void setPersonEditor(PersonEditor person) {
		PersonEditor old = this.personEditor;
		this.personEditor = person;
		person.addPropertyChangeListener(this);
		propChangeSupp.firePropertyChange("personEditor", old, person);

	}
}
