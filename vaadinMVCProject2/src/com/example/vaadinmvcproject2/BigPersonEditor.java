package com.example.vaadinmvcproject2;

import java.beans.PropertyChangeEvent;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class BigPersonEditor extends PersonEditor{
	/**
	 * 
	 */
	Button add;
	Button remove;
	VerticalLayout v=new VerticalLayout();
	private static final long serialVersionUID = 1L;
	
	public BigPersonEditor(BigPerson person) {
		super(person);
		init();
		addComponent(new Label("----------------------CHILD OF "+getPerson().getName()+"----------------------"));
		addComponent(v);
		v.setImmediate(true);
	}

	@Override
	public void setBean() {
		super.setBean();
		
	}
	public void init() {
		add=new Button("add");
		addComponent(add);
		remove=new Button("remove");
		addComponent(remove);
		
		
		add.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				BigPerson b=(BigPerson) getPerson();
				Person p=new Person();
				b.addChildAt(0, p);
//			v.addComponent(new PersonEditor(p));
//			System.out.println(b.getChildrens().toString());
//			
			}
		});
		remove.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				BigPerson b=(BigPerson) getPerson();
				if(b.getChildrens().size()!=0) {
				
					b.removeChildAt(b.getChildrens().size()-1);
					System.out.println(b.getChildrens().toString());
//					if(v.getComponentCount()!=0)
//					v.removeComponent(v.getComponent(v.getComponentCount()-1));
				}
			}
		});
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if(event.getPropertyName().equals("childrens")) {
			getPropChangeSupp().firePropertyChange(event);
			v.removeAllComponents();
			for (Person p : ((BigPerson)getPerson()).getChildrens()) {
				v.addComponent(new PersonEditor(p));
			}
		}
	}

}
