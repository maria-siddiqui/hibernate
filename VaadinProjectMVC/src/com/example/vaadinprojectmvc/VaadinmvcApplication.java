package com.example.vaadinprojectmvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.vaadin.Application;
import com.vaadin.data.Container.PropertySetChangeEvent;
import com.vaadin.data.Container.PropertySetChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Paintable.RepaintRequestListener;
import com.vaadin.ui.*;

public class VaadinmvcApplication extends Application {
	
	private Person p =new Person(1,"p1",12,true);
	
	public VaadinmvcApplication() {
	System.out.println("created new instance");
	
	}
	@Override
	public void init() {
		
 Window mainWindow = new Window("Vaadinmvc Application");
 		PersonEditor p1 =new PersonEditor(p);
		
		PersonEditor p2 =new PersonEditor(p);
//		
		mainWindow.addComponent(p1);
mainWindow.addComponent(new Label(""));
		mainWindow.addComponent(p2);
		
		setMainWindow(mainWindow);
		
		
	}
	/*PersonView personView=new PersonView(p);

		personView.setImmediate(true);

		setMainWindow(personView);*/
	
//	@Override
//	public Window getWindow(String name) {
//		Window w = super.getWindow(name);
//        if (w == null) {
//            // If no window found, create it
//            w = new Window(name);
//            // set windows name to the one requested
//            w.setName(name);
//            // add it to this application
//            addWindow(w);
//            // ensure use of window specific url
//            w.open(new ExternalResource(w.getURL().toString()));
//            // add some content
//            w.addComponent(new PersonEditor(p));
//        }
//        return w;
//       }
	
}
