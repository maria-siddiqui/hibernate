package com.example.vaadinprojectmvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditorSupport;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ClientWidget;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonEditor extends VerticalLayout implements PropertyChangeListener {
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

	private void initUI() {

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
		

		idTf.addListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {

				person.setId(Integer.parseInt(idTf.getValue().toString()));
				setPerson(person);
			}
		});

		nameTf.addListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				person.setName(nameTf.getValue().toString());
				setPerson(person);
			}
		});
		ageTf.addListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				person.setAge(Integer.parseInt(ageTf.getValue().toString()));
				setPerson(person);
			}
		});

		idTf.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {

				person.setId(Integer.parseInt(idTf.getValue().toString()));
				setPerson(person);
			}
		});
		nameTf.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				person.setName(nameTf.getValue().toString());
				setPerson(person);
			}
		});
		ageTf.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				person.setAge(Integer.parseInt(ageTf.getValue().toString()));
				setPerson(person);
			}
		});
		marriedTf.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				person.setMarried(marriedTf.booleanValue());
				setPerson(person);
			}
		});

	}

	public PersonEditor(Person person) {

		this();
		setPerson(person);
		setBean();
	}

	private void setBean() {
		BeanItem<Person> bt;
		bt = new BeanItem<Person>(this.person);
		idTf.setPropertyDataSource(bt.getItemProperty("id"));
		nameTf.setPropertyDataSource(bt.getItemProperty("name"));
		ageTf.setPropertyDataSource(bt.getItemProperty("age"));
		marriedTf.setPropertyDataSource(bt.getItemProperty("married"));

	}

	public PersonEditor() {
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
		setBean();
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propChangeSupp.removePropertyChangeListener(listener);
	}

	public void propertyChange(PropertyChangeEvent event) {
		propChangeSupp.firePropertyChange(event);
		System.out.println("Person Editor Proper Change Event");
		setBean();
	}
}
