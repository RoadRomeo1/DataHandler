package com.dataentry;

import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class View extends JPanel {
	
	Connection con1,con2,con3;
	Statement st1,st2,st3;
	ResultSet rs1,rs2,rs3;
	JTable jt;
	JScrollPane jsp;
	int ln;
	String user="root";
	String pass="root";
	String url="jdbc:mysql://localhost:3306/handler";
	String sql="select * from data";
	String sql1="select * from data";
	
	
	  View() {
	    String tt[]= {"First Name","Last Name","Education1","Education2","Education3","Address","City","State","Date of Birth","Contact No","Email Id"};
       
	    try {
	       Class.forName("com.mysql.jdbc.Driver");
	        con1=DriverManager.getConnection(url, user, pass);
	        st1=con1.createStatement();
	        rs1=st1.executeQuery(sql);
	        ln=0;
	        con1.close();
	        } catch (Exception e) {
		e.printStackTrace();
		}
	    
	    String dt[][]=new String[ln][13];
	    
	    try {
	    	
	    	con2=DriverManager.getConnection(url, user, pass);
	    	st2=con2.createStatement();
	    	rs2=st2.executeQuery(sql1);
	    	String s1[]=new String[13];
	    	int i=0;
	    	while(rs2.next()) {
	    		s1[0]=rs2.getString(1);
	    		s1[1]=rs2.getString(2);
	    		s1[2]=rs2.getString(3);
	    		s1[3]=rs2.getString(4);
	    		s1[4]=rs2.getString(5);
	    		s1[5]=rs2.getString(6);
	    		s1[6]=rs2.getString(7);
	    		s1[7]=rs2.getString(8);
	    		s1[8]=rs2.getString(9);
	    		s1[9]=rs2.getString(10);
	    		s1[10]=rs2.getString(11);
	    		s1[11]=rs2.getString(12);
	    		s1[12]=rs2.getString(13);
	    		for(int j=0;j<13;j++) {
	    			dt[i][j]=s1[j];
	    		}
	    		i++;
	    	}
	    	rs2.close();
	    	st2.close();
	    	con2.close();
	    }catch (Exception e) {
		e.printStackTrace();
	    }
	    
	 jt=new JTable(dt,tt);
	 jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	 jsp=new JScrollPane(jt);
	 add(jsp);
	   }}
