package com.dataentry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Delete extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
JLabel l1;
Object obj;
JComboBox cmb;
JButton b1;
Connection con1=null,con2=null,con3=null;
Statement st=null;
ResultSet rs=null,rs1=null;
Statement st1=null,st2=null;


public Delete() {
	setSize(1000, 600);
	setLayout(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	c.insets=new Insets(10, 10, 4, 4);
	cmb=new JComboBox();
	cmb.addItem("--None--");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
       	String user="root";
       	String pass="root";
       	String url="jdbc:mysql://localhost:3306/handler";
       	String sql="select * from data";
       	
       	con1=DriverManager.getConnection(url, user, pass);
       	System.out.println("Connected");
       	
       	st=con1.createStatement();
       	rs=st.executeQuery(sql);
       	
		
       	while (rs.next()) {
			cmb.addItem(rs.getString(1));
		}
       	
	} catch (Exception e) {
	e.printStackTrace();
	
	}
	cmb.addItemListener(new ItemListener() {
		
		
		public void itemStateChanged(ItemEvent arg0) {
		obj=cmb.getSelectedItem();
		
		}
	});

	c.gridx=1;
	c.gridy=0;
	c.ipadx=90;
	c.ipady=4;
	add(cmb,c);
	Font fn=new Font("Lucida Bright", Font.BOLD,16);
	l1=new JLabel("Select Name");
	c.gridx=0;
	c.gridy=0;
	add(l1, c);
	
	l1.setForeground(Color.blue);
	l1.setFont(fn);
	b1=new JButton("Delete");
    b1.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
		try {
			
			String sql1="delete from data where nam ='"+obj.toString()+"'";
			String sql2="select * from data";
			st1=con1.createStatement();
			st1.executeUpdate(sql1);
			Frame fob=new Frame("");
		    JOptionPane.showMessageDialog(fob,"Item Deleted");
		    cmb.removeAllItems();
		    cmb.addItem("--None--");
		     
		    st2=con2.createStatement();
		    rs1=st2.executeQuery(sql2);
		    
		    while (rs.next()) {
				cmb.addItem(rs1.getString(1));
			}
			
			con1.close();
			con2.close();
			con3.close();
			st.close();
            st1.close();
            st2.close();
            rs.close();
            rs1.close();
	   
		} 
		
		catch (Exception e) {
		e.printStackTrace();
		Frame fob1=new Frame();
		JOptionPane.showMessageDialog(fob1, "No Item is selected/Not any Item");
		}
		
		}
	});
    
    c.gridx=0;
    c.gridy=1;
    c.ipadx=30;
    c.ipady=10;
    
    b1.setForeground(Color.blue);
    b1.setFont(fn);
    add(b1,c);
    
}}
