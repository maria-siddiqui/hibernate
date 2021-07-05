package com.example.vaadinmvcproject2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonEditor extends VerticalLayout implements PropertyChangeListener{
	/**
	 * 
	 */
	private java.beans.PropertyChangeSupport propChangeSupp;
	private static final long serialVersionUID = 1L;
	private Person person;
	private TextField idTf;
	private TextField nameTf;
	private TextField ageTf;
	private CheckBox marriedTf;
	private BeanItem<Person> bt;
private Label className=new Label();
	private void initUI() {
		addComponent(className);
		idTf = new TextField();
		nameTf = new TextField();
		ageTf = new TextField();

		marriedTf = new CheckBox("Married");
		idTf.setImmediate(true);
		nameTf.setImmediate(true);
		ageTf.setImmediate(true);
		marriedTf.setImmediate(true);

		Label idlbl = new Label("Id");
		Label namelbl = new Label("Name");
		Label agelbl = new Label("Age");
		Label marriedlbl = new Label("check if married");
		addComponent(idlbl);
		addComponent(idTf);
		addComponent(namelbl);
		addComponent(nameTf);
		addComponent(agelbl);
		addComponent(ageTf);
		addComponent(marriedlbl);
		addComponent(marriedTf);	
	}

	public PersonEditor(Person person) {

		this();
		setPerson(person);
		setBean();
		className.setCaption(person.getClass().getSimpleName()+" EDITOR");
	}

	public void setBean() {
		bt = new BeanItem<Person>(this.person);
		idTf.setPropertyDataSource(bt.getItemProperty("id"));
		nameTf.setPropertyDataSource(bt.getItemProperty("name"));
		ageTf.setPropertyDataSource(bt.getItemProperty("age"));
		marriedTf.setPropertyDataSource(bt.getItemProperty("married"));
	}

	private PersonEditor() {
		super();
		propChangeSupp = new java.beans.PropertyChangeSupport(this);
		initUI();

	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		Person old = this.person;
		this.person = person;
		setBean();
		person.addPropertyChangeListener(this);
		propChangeSupp.firePropertyChange("person", old, person);

	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.removePropertyChangeListener(listener);
	}

	public void updateToId() {
		idTf.setPropertyDataSource(bt.getItemProperty("id"));
	}

	public void updateToName() {
		nameTf.setPropertyDataSource(bt.getItemProperty("name"));
	}

	public void updateToAge() {
		ageTf.setPropertyDataSource(bt.getItemProperty("age"));
		}

	public void updateToMarried() {
		marriedTf.setPropertyDataSource(bt.getItemProperty("married"));
	}

	public void propertyChange(PropertyChangeEvent event) {
		propChangeSupp.firePropertyChange(event);
		System.out.println("Person Editor Proper Change Event");
		if (event.getPropertyName().equals("id")) {
			updateToId();
		} else if (event.getPropertyName().equals("name")) {
			updateToName();
		} else if (event.getPropertyName().equals("age")) {
			updateToAge();
		}
		else if(event.getPropertyName().equals("married")) {
			updateToMarried();
		}
		
	
	}

	public void applyToId() {
		person.setId(Integer.parseInt(idTf.getValue().toString()));
	}

	public void applyToName() {
		person.setName(nameTf.getValue().toString());
	}

	public void applyToAge() {
		person.setAge(Integer.parseInt(ageTf.getValue().toString()));
	}

	public void applyToMarried() {
		person.setMarried(marriedTf.booleanValue());
	}

	/**
	 * @return the bt
	 */
	public BeanItem<Person> getBt() {
		return bt;
	}

	/**
	 * @param bt the bt to set
	 */
	public void setBt(BeanItem<Person> bt) {
		this.bt = bt;
	}

	/**
	 * @return the propChangeSupp
	 */
	public java.beans.PropertyChangeSupport getPropChangeSupp() {
		return propChangeSupp;
	}

}
