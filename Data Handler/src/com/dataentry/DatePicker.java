package com.dataentry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DatePicker {
int month=java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
int year=java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
JLabel l1=new JLabel("",JLabel.CENTER);
String day="";
JDialog d;
JButton [] button=new JButton[49];


public DatePicker(JFrame parent) {
d=new JDialog();
d.setModal(true);
String [] header= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
JPanel p1=new JPanel(new GridLayout(7,7));
p1.setPreferredSize(new Dimension(430,120));
for(int x=0;x<button.length;x++) {
	final int selection=x;
	button [x]=new JButton();
	button [x].setFocusPainted(false);
	button[x].setBackground(Color.WHITE);
	if(x>6) 
		button[x].addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
		          day=button[selection].getActionCommand();
		          d.dispose();
			}
		});
		if(x<7) {
			button[x].setText(header[x]);
			button[x].setForeground(Color.RED);
		}
		p1.add(button[x]);
	}
 
     JPanel p2=new JPanel(new GridLayout(1,3));
     JButton previous=new JButton("<<Previous");
     previous.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
		month--;
		displayDate();
		}
	}); 
     p2.add(previous);
     p2.add(l1);
     
     JButton next=new JButton(">>Next");
     next.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
		month++;
		displayDate();
		}
	});
    p2.add(next);
    d.add(p1,BorderLayout.CENTER);
    d.add(p2, BorderLayout.SOUTH);
    d.pack();
    d.setLocationRelativeTo(parent);
    displayDate();
    d.setVisible(true);
    
    }

public void displayDate(){
	for(int x=7;x<button.length;x++) 
		button[x].setText("");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("MMMM yyyy");
		
		java.util.Calendar cal=java.util.Calendar.getInstance();
		cal.set(year, month,1);
	    int dayOfWeek=cal.get(java.util.Calendar.DAY_OF_WEEK);
	    int dayInMonth=cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	    cal.getActualMinimum(java.util.Calendar.DAY_OF_MONTH);
	    for(int x=6+dayOfWeek,day=1;day<=dayInMonth;x++,day++) 
        button[x].setText(""+day);
	    l1.setText(sdf.format(cal.getTime()));
	    d.setTitle("Date Picker");
	    }



public String setPickedDate() {
	if(day.equals("")) 
		return day;
	
	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-mm-yy");
	
	java.util.Calendar cal=java.util.Calendar.getInstance();
	cal.set(year, month, Integer.parseInt(day));
	return sdf.format(cal.getTime());
	}



}



