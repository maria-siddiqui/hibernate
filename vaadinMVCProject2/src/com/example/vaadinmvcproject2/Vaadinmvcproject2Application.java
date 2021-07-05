package com.example.vaadinmvcproject2;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class Vaadinmvcproject2Application extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Vaadinmvcproject2 Application");
		BigPerson bp=new BigPerson();
		BigPersonEditor bpEdit1=new BigPersonEditor(bp);
		BigPersonEditor bpEdit2=new BigPersonEditor(bp);
		mainWindow.addComponent(bpEdit1);
		mainWindow.addComponent(bpEdit2);
		setMainWindow(mainWindow);
	}

}
