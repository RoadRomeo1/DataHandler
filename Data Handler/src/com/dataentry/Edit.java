package com.dataentry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



class Edit extends JPanel 
{
	private static final long serialVersionUID = 1L;
Connection con1=null,con2=null,con3=null;
Statement st1=null,st2=null,st3=null;
ResultSet rs1=null,rs2=null,rs3=null;
JPanel fob;
String jrb,jchk1,jchk2,jchk3,jrb1;
String mystate,mystr6;
JComboBox cmb,cmb1,lst;
Object obj=null;
JButton b1;
JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JTextField t0,t1,t2,t3,t4,t5,t6,t7,tstate;
TextArea ta;
JCheckBox ch1,ch2,ch3;
JRadioButton r1=null,r2=null;
ButtonGroup bg;
String user="root";
String pass="root";
String url="jdbc:mysql://localhost:3306/handler";
String sql="select * from  data";




 Edit() {
fob=new JPanel();
fob.setSize(1000,600);
Font fnt2=new Font("Lucida Bright", Font.BOLD, 16);
fob.setLayout(new GridBagLayout());
GridBagConstraints c=new GridBagConstraints();
c.insets=new Insets(5,5,4,4);


c.weightx=1.0;
c.weighty=1.0;

l0=new JLabel("Select Student Name");
c.gridx=0;
c.gridy=0;
fob.add(l0,c);
l0.setForeground(Color.blue);
Font fn=new Font("Lucida Bright", Font.BOLD, 16);
l0.setFont(fn);
cmb1=new JComboBox();
cmb1.addItem("--None--");

try {
	Class.forName("com.mysql.jdbc.Driver");
	con1=DriverManager.getConnection(url, user, pass);
    st1=con1.createStatement();
    rs1=st1.executeQuery(sql);
    
    while (rs1.next()) {
		cmb.addItem(rs1.getString(1));
	}
    
    rs1.close();
    
} 
catch (Exception e) {
e.printStackTrace();}

c.gridx=0;
c.gridy=1;
fob.add(l1=new JLabel("Firt Name"),c);
l1.setFont(fnt2);

c.gridy=2;
fob.add(l2=new JLabel("Last Name"),c);
l2.setFont(fnt2);

c.gridy=3;
fob.add(l3=new JLabel("Father"),c);
l3.setFont(fnt2);

c.gridy=4;
fob.add(l4=new JLabel("Gender"),c);
l4.setFont(fnt2);

c.gridy=5;
fob.add(l5=new JLabel("Education"),c);
l5.setFont(fnt2);

c.gridy=6;
fob.add(l6=new JLabel("Address"),c);
l6.setFont(fnt2);


c.gridy=7;
fob.add(l7=new JLabel("City"),c);
l7.setFont(fnt2);


c.gridy=8;
fob.add(l8=new JLabel("State"),c);
l8.setFont(fnt2);


c.gridy=9;
fob.add(l9=new JLabel("Date of Birth"),c);
l9.setFont(fnt2);


c.gridy=10;
fob.add(l10=new JLabel("Mobile No."),c);
l10.setFont(fnt2);

c.gridy=11;
fob.add(l11=new JLabel("Email Id"),c);
l11.setFont(fnt2);


c.gridx=1;
c.gridy=1;
t1=new JTextField(20);
fob.add(t1,c);

c.gridy=2;
fob.add(t2=new JTextField(20),c);

c.gridy=3;
fob.add(t3=new JTextField(20),c);

bg=new ButtonGroup();
r1=new JRadioButton("Male",false);
r1.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
         jrb1="M";
	}
});

bg.add(r1);
//c.gridx=1;
c.gridy=4;
r1.setFont(fnt2);
fob.add(r1,c);


r2=new JRadioButton("FEMALE",false);repaint();
r2.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
	jrb1="F";	
	}
});

bg.add(r2);
c.gridx=2;
c.gridy=4;
r2.setFont(fnt2);
fob.add(r2);

ch1=new JCheckBox("BE");
ch1.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
	   if(ch1.isSelected())	{
		   jchk1="BE";
	   }
	   else
		   jchk1=null;
	}
});
c.gridx=1;
c.gridy=5;
ch1.setFont(fnt2);
fob.add(ch1,c);


ch2=new JCheckBox("MBA");
ch2.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
	if(ch2.isSelected())
		jchk2="MBA";	
	else
		jchk2=null;
	}
});
c.gridx=2;
c.gridy=5;
ch2.setFont(fnt2);
fob.add(ch2,c);


ch3=new JCheckBox("MCA");
ch3.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
	    if(ch3.isSelected())
		    jchk3="MCA";
	    else
	    	jchk3=null;
	}
});
c.gridx=3;
c.gridy=5;
ch3.setFont(fnt2);
fob.add(ch3,c);


c.gridx=1;
c.gridy=6;
fob.add(ta=new TextArea(3,20),c);
c.gridy=7;
fob.add(t4=new JTextField(20),c);

c.gridx=1;
c.gridy=8;
fob.add(tstate=new JTextField(20),c);
//-----------------------

c.gridx=2;
c.gridy=8;
lst=new JComboBox();
lst.addItem("---None---");
lst.addItem("MP");
lst.addItem("UP");
lst.addItem("AP");
lst.addItem("HP");
lst.addItem("punjab");
lst.addItem("Hariyana");
lst.addItem("Rajsthan");
lst.addItem("Gujrat");
lst.addItem("Udisa");
lst.addItemListener(new ItemListener() {
	
	
	public void itemStateChanged(ItemEvent arg0) {
	obj=lst.getSelectedItem();
	tstate.setText(obj.toString());
	}
});
fob.add(lst,c);

//---------------------
c.gridx=1;
c.gridy=9;
fob.add(t5=new JTextField(20),c);
c.gridy=2;

JButton b=new JButton("Calendar");
fob.add(b,c);
b.addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent arg0) {
	final JFrame f=new JFrame();
	t5.setText(new DatePicker(f).setPickedDate());
	}
});


c.gridx=1;
c.gridy=10;
fob.add(t6=new JTextField(20),c);
c.gridy=11;
fob.add(t7=new JTextField(20),c);
b1=new JButton("Update");

c.gridx=0;
c.gridy=12;
b1.setFont(fnt2);
fob.add(b1,c);
cmb1.addItemListener(new ItemListener() {
	
	
	public void itemStateChanged(ItemEvent arg0) {
	obj=cmb1.getSelectedItem();
	
	
	
	
	try {
		
		String sql1="select * from data where nam='"+obj.toString()+"' ";
	Class.forName("com.mysql.jdbc.Driver");
	con2=DriverManager.getConnection(sql, user, pass);
	st2=con2.createStatement();
	rs2=st2.executeQuery(sql1);
	
	if(rs2.next()) {
		t1.setText(rs2.getString(1));
		t2.setText(rs2.getString(2));
		t3.setText(rs2.getString(3));
		ta.setText(rs2.getString(8));
		t4.setText(rs2.getString(9));
		tstate.setText(rs2.getString(10));
		t5.setText(rs2.getString(11));
		t6.setText(rs2.getString(12));
		t7.setText(rs2.getString(13));
		jrb1=rs2.getString(4);
		if(jrb1.equals("M")) {
			r1.setSelected(true);
			r2.setSelected(false);
		}
		
		else {
			r1.setSelected(false);
			r2.setSelected(true);
			}
		
		//---------------
		
		String jchk11=rs2.getString(5);
		
		if(jchk11==null) {
			ch1.setSelected(false);
		}
		
		else if(jchk1.equals("BE")) {
			ch1.setSelected(true);
		}
		else {
			ch1.setSelected(false);
		}
		
		
        String jchk21=rs2.getString(6);
		
		if(jchk21==null) {
			ch2.setSelected(false);
		}
		
		else if(jchk21.equals("MBA")) {
			ch2.setSelected(true);
		}
		else {
			ch2.setSelected(false);
		}
		
		
        String jchk31=rs2.getString(7);
		
		if(jchk31==null) {
			ch3.setSelected(false);
		}
		
		else if(jchk31.equals("MCA")) {
			ch3.setSelected(true);
		}
		else {
			ch3.setSelected(false);
		}
		
			
		
	}
	
	
	rs2.close();
	con2.close();
	}
	
	catch (Exception e) {
	e.printStackTrace();
	}
	
	
	}});


    b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
 
          JFrame fob1=new JFrame();
          //------------------
          
		String mytstr1=t1.getText();
		if(mytstr1.length()<1) {
			JOptionPane.showMessageDialog(fob1, "Enter First Name");
			t1.requestFocus();
			return;
		}
		
		
		if(mytstr1.length()>0) {
			String v="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz_";
			String k=t1.getText();
			int i=0;
			int j=k.length();
			
			while (i<j) {
				if(v.indexOf(k.charAt(i))==-1) {
					JOptionPane.showMessageDialog(fob1, "Only Alphabets");
					t1.setText(" ");
					t1.requestFocus();
					return;
			    }
				i++;
				}
			}
		
		
		String mystr2=t2.getText();
		if(mystr2.length()<1){
			JOptionPane.showMessageDialog(fob1, "Enter Last Name");
			t2.requestFocus();
			return;
		}
		
		
		if(mystr2.length()>0) {
			String v="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz_";
			String k=t2.getText();
			int i=0;
			int j=k.length();
		        while(i<j){
				if(v.indexOf(k.charAt(i))==-1) {
					JOptionPane.showMessageDialog(fob1, "Only alphabets");
					t2.setText(" ");
					t2.requestFocus();
					return;
				}
					i++;
			}
			
			
		}
		
		//-----------------
		
		
		String mystr4=t3.getText();
		if(mystr4.length()<1) {
			JOptionPane.showMessageDialog(fob1,"Enter Father Name");
			t3.requestFocus();
			return;
			}
		
		if(mystr4.length()>0){
			String v="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz_";
			String k=t3.getText();
			int i=0;
			int j=k.length();
			while(i<j){
				if(v.indexOf(k.charAt(i))==-1) {
					JOptionPane.showMessageDialog(fob1,"Only Alphabets");
					t3.setText(" ");
					t3.requestFocus();
					return;
					}
				i++;
			}
		}
		
		String mystr3=ta.getText();
		if(mystr3.length()<1) {
			JOptionPane.showMessageDialog(fob1,"Enter Address");
			ta.requestFocus();
			return;
		}
		
		String mystr5=t4.getText();
		if(mystr5.length()<1){
			JOptionPane.showMessageDialog(fob1, "Enter City Name");
			t4.requestFocus();
			return;
		}
		
		if(mystr5.length()>0) {
			String v="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz_";
			String k=t4.getText();
			int i=0;
			int j=k.length();
			while(i<j){
    	     if(v.indexOf(k.charAt(i))==-1) {
    	    	 JOptionPane.showMessageDialog(fob1,"Only alphabets");
    	    	 t4.setText(" ");
    	    	 t4.requestFocus();
    	    	 return;
    	     }
    	     i++;
    }
					
		}
		
		
		mystate=tstate.getText();
		if(mystate.length()<1){
			JOptionPane.showMessageDialog(fob1, "Select State");
			tstate.requestFocus();
			return;
		}
				if(mystate.length()>0) {
					String v="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz_";
					String k=tstate.getText();
					int i=0;
					int j=k.length();
					while(i<j) {
					if(v.indexOf(k.charAt(i))==-1) {	
						JOptionPane.showMessageDialog(fob1, "Only Alphabets");
						tstate.setText(" ");
						tstate.requestFocus();
						return;
						
					}
					i++;
					}
				}
				
				mystr6=t5.getText();
				if(mystr6.length()<1){
					JOptionPane.showMessageDialog(fob1, "Select Date");
					t5.requestFocus();
					return;
				}
				
				
				String mystr7=t6.getText();
				if(mystr7.length()!=10) {
					JOptionPane.showMessageDialog(fob1, "Enter Proper mobile number");
					t6.requestFocus();
					return;
				}
				
				if(mystr7.length()==10) {
					String v="0123456789";
					String k=t6.getText();
					int i=0;
					int j=k.length();
					while(i<j) {
						if(v.indexOf(k.charAt(i))==-1) {
							JOptionPane.showMessageDialog(fob1, "Only Digits");
							t6.setText(" ");
							t6.requestFocus();
							return;
						}
						i++;
					}
				}

				String email=t7.getText();
				if(email.length()<1) {
					JOptionPane.showMessageDialog(fob1,"Enter Email Id");
					t7.requestFocus();
					return;
				}
				
				
				if(email.length()>0){
					EmailValidator obj1=new EmailValidator();
					boolean stat1=obj1.validate(email);
					
					if(!stat1) {
						JOptionPane.showMessageDialog(fob1, "Enter Proper Email Id");
						t7.requestFocus();
						return;
					}
				   }
				
		try {		
			String sql2="update sutudent set nam='"+mytstr1+"',lnam='"+mystr2+"',fnam='"+mystr4+"',rad1='"+jrb1+"',edu1='"+jchk1+"',edu2='"+jchk2+"',edu3='"+jchk3+"',add='"+mystr3+"',cty='"+mystr5+"',stat='"+mystate+"',dob='"+mystr6+"',cntno='"+mystr7+"',email='"+email+"' where nam='"+obj.toString()+"' ";
			con3=null;
			st3=con3.createStatement();
			st3.executeUpdate(sql2);
			st3.close();
			con3.close();
			JOptionPane.showMessageDialog(fob1,"Data Updated");
			}
		  catch (Exception e) {
          e.printStackTrace(); 
     	}
		}});
	
    c.gridx=1;
    c.gridy=0;
    c.ipadx=120;
    c.ipady=4;
    
    fob.add(cmb1,c);
    add(fob);
    }

}