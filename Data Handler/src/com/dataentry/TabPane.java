package com.dataentry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabPane {

	JFrame fob;
	JTabbedPane jtp;
	
	
	
	 public TabPane() {
	fob=new JFrame("Data-Handler");
	fob.setSize(300, 300);
    jtp=new JTabbedPane();
	AddTab obj=new AddTab();
    jtp.addTab("Add", new JScrollPane(obj));
	jtp.addTab("Delete", new Delete());
	jtp.addTab("Edit",new Edit());
	jtp.addTab("View",new View());

	fob.add(jtp);
	fob.setVisible(true);
	}



	public static void main(String[] args) {
    
		new TabPane();
		
	}

}
