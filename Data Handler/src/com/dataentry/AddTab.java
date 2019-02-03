package com.dataentry;

import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.text.rtf.RTFEditorKit;
import com.mysql.jdbc.Driver;

class AddTab extends JPanel{

	JFrame fob;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	TextArea ta1;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	Checkbox ch1,ch2,ch3;
	ButtonGroup g1;
	JComboBox lst;
	JButton b1,b2;
	JRadioButton r1,r2;
	String edu1=null,edu2=null,edu3=null,rad1="M";
	String nam=null,lnam=null,fnam=null,add=null,cty=null,dob=null,cntno=null,email=null;
	Object stat="MP";

	
	public AddTab() {
		
		fob=new JFrame("Add");
		setLayout(new GridBagLayout());
        setSize(800,800);
        
        GridBagConstraints c=new GridBagConstraints();
        
        c.insets=new Insets(2,2,2,2);
        c.gridx=2;
        c.gridy=0;
        c.ipady=10;
        c.gridheight=2;
        c.gridwidth=2;
        c.fill=GridBagConstraints.BOTH;
        l0=new JLabel("Entry Form");
        add(l0,c);
        
        c.gridx=0;
        c.gridy=2;
        l1=new JLabel("First Name");
        add(l1, c);
        
        c.gridx=2;
        c.gridy=2;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t1=new JTextField(12);
        add(t1, c);
        
        c.gridx=0;
        c.gridy=4;
        l2=new JLabel("Last Name");
        add(l2, c);
        
        c.gridx=2;
        c.gridy=4;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t2=new JTextField(12);
        add(t2, c);
        
        c.gridx=0;
        c.gridy=6;
        l3=new JLabel("Father's Name");
        add(l3, c);
        
        c.gridx=2;
        c.gridy=6;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t3=new JTextField(12);
        add(t3, c);
        
        c.gridx=0;
        c.gridy=8;
        l4=new JLabel("Gender");
        add(l4, c);
        
        c.gridx=2;
        c.gridy=8;
        c.gridwidth=1;
        c.fill=GridBagConstraints.BOTH;
        r1=new JRadioButton("Male", true);
        r1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				rad1="M";
			}
		});
        add(r1, c);
        
        c.gridx=3;
        c.gridy=8;
        r2=new JRadioButton("Female");
        r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			rad1="F";
			
			}
		});
        add(r2, c);

        
        c.gridx=0;
        c.gridy=10;
        l5=new JLabel("Education");
        add(l5, c);
        
        
        c.gridx=2;
        c.gridy=10;
        ch1=new Checkbox("BE");
        ch1.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
			if(ch1.getState()) {
				edu1="BE";
			}
			else {
				edu1=null;
			}
			}
		});
        add(ch1, c);
        
     
        
        c.gridx=3;
        c.gridy=10;
        ch2=new Checkbox("MBA");
        ch2.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
			if(ch2.getState()) {	
				edu2="MBA";
			}
			else
				edu2=null;
			}
		});
      add(ch2, c);
        
        
        c.gridx=4;
        c.gridy=10;
        ch3=new Checkbox("MCA");
        ch3.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
			if(ch3.getState()) {
				edu3="MCA";
			}
			else {
				edu3=null;
			}
			}
		});
        add(ch3, c);
        
        
        c.gridx=0;
        c.gridy=12;
        l6=new JLabel("Address");
        add(l6, c);
        
        c.gridx=2;
        c.gridy=12;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        ta1=new TextArea(3,20);
        add(ta1, c);
        
        c.gridx=0;
        c.gridy=16;
        l7=new JLabel("City");
        add(l7, c);
        
        c.gridx=2;
        c.gridy=16;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t7=new JTextField(20);
        add(t7, c);
        
        c.gridx=0;
        c.gridy=18;
        l8=new JLabel("Select State");
        add(l8, c);

        
        c.gridx=2;
        c.gridy=18;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        lst=new JComboBox();
        
        lst.addItem("MP");
        lst.addItem("UP");
        lst.addItem("AP");
        lst.addItem("HP");
        lst.addItem("Punjab");
        lst.addItem("Hariyana");
        lst.addItem("Rajsthan");
        lst.addItem("Gujrat");
        lst.addItem("Udisa");
        
        lst.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent arg0) {
			
				stat=lst.getSelectedItem();
			}
		});
        add(lst, c);
        
        
        c.gridx=0;
        c.gridy=22;
        l9=new JLabel("Date of Birth");
        add(l9, c);
        
        c.gridx=20;
        JButton b=new JButton("Calendar");
        add(b,c);
        
        b.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
			
				final JFrame f=new JFrame("Calendar");
				t9.setText(new DatePicker(f).setPickedDate());
			}
		});
        
        c.gridx=2;
        c.gridy=22;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t9=new JTextField(20);
        t9.setText("00-00-0000");
        add(t9, c);
        
        c.gridx=0;
        c.gridy=24;
        l10=new JLabel("Mobile no.");
        add(l10, c);
        
        c.gridx=2;
        c.gridy=24;
        c.gridwidth=3;
        c.fill=GridBagConstraints.BOTH;
        t10=new JTextField(20);
        add(t10, c);
        
        c.gridx=0;
        c.gridy=26;
        l11=new JLabel("Email-Id");
        add(l11, c);

        
        c.gridx=2;
        c.gridy=26;
        t11=new JTextField(20);
        add(t11, c);
        
        c.gridx=2;
        c.gridy=34;
        c.gridwidth=1;
        c.fill=GridBagConstraints.BOTH;
        b1=new JButton("Save");
        b1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
		         nam=t1.getText();
		         if(nam.length()<1){
		        	 JOptionPane.showMessageDialog(fob, "Enter First Name");
		              t1.requestFocus();
		              return;
		         }
		         
		         if(nam.length()>0){
		        	 
		        	 String v="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
		        	 String k=t1.getText();
		        	 int i=0;
		        	 int j=k.length();
		        	 while(i<j) {
		        		 if(v.indexOf(k.charAt(i))==-1){
		        			 JOptionPane.showMessageDialog(fob,"Only Alphabets");
		        			 t1.setText(" ");
		        			 t1.requestFocus();
		        			 return;
		        		 }
		        		 i++;
		        	 }
		         }
		         
		          lnam=t2.getText();
		         if(lnam.length()<1) {
		        	 JOptionPane.showMessageDialog(fob,"Enter Last Name");
		         	 t2.requestFocus();
		             return;
		         }
		         
		           if(lnam.length()>0) {    
		        	   String v="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
		        	   String k=t2.getText();
		        	   int i=0;
		        	   int j=k.length();
		        	   while(i<j) {
		        		   
		        		   if(v.indexOf(k.charAt(i)) ==-1) {
		        			   JOptionPane.showMessageDialog(fob,"Only Alphabets");
		        		       t2.setText("");
		        		       t2.requestFocus();
		        		       return;
		        		    }
		        		   i++;
		        	   }
		           }
		    
		           
		           fnam=t3.getText();
		           if(fnam.length()>0) {
		        	   JOptionPane.showMessageDialog(fob,"Enter Father's name");
		                t3.requestFocus();
		                return;
		           }
		           
		           
		           if(fnam.length()>0) {
		        	   String v="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
		        	   String k=t3.getText();
		        	   int i=0;
		        	   int j=k.length();
		        	   
		        	   while(i<j) {
		        		   if(v.indexOf(k.charAt(i))==-1) {
		        			   JOptionPane.showMessageDialog(fob,"Alphabets Only");
		        			   t3.setText("");
		        			   t3.requestFocus();
		        			   return;
		        		   }
		        		   i++;
		        		   
		        		   
		        	   }
		           }
		           
		           add=ta1.getText();
		            if(add.length()<1) {
		            	JOptionPane.showMessageDialog(fob,"Enter Address");
		            	ta1.requestFocus();
		            	return;
		            }
		            
		            
		            cty=t7.getText();
		            if(cty.length()<1){
		            JOptionPane.showMessageDialog(fob,"enter City");
		             t7.requestFocus();
		             return;
		             }
		            
		            

			           if(cty.length()>0) {
			        	   String v="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
			        	   String k=t7.getText();
			        	   int i=0;
			        	   int j=k.length();
			        	   
			        	   while(i<j) {
			        		   if(v.indexOf(k.charAt(i))==-1) {
			        			   JOptionPane.showMessageDialog(fob,"Alphabets Only");
			        			   t7.setText("");
			        			   t7.requestFocus();
			        			   return;
			        		   }
			        		   i++;
			        		   
			        		   
			        	   }
			           }
		           
			           
			           
			           
			           dob=t9.getText();
			           if(dob.length()<1) {
			        	   JOptionPane.showMessageDialog(fob,"Enter Date of Birth");
			        	   t9.requestFocus();
			        	   return;
			           }
			           
			           
			           if(dob.equals("00-00-0000")) {
			             JOptionPane.showMessageDialog(fob,"Enter Date properly");
		                 t9.requestFocus();
		                 return;
 			            }
			           
			           
			           cntno=t10.getText();
			           if(cntno.length()<1) {
			        	   JOptionPane.showMessageDialog(fob,"Enter contact number");
			        	   t10.requestFocus();
			        	   return;
			           }
			           
			           
			           if(cntno.length()==10) {
			        	   String v="1234567890";
			        	   String k=t10.getText();
			        	   int i=0;
			        	   int j=k.length();
			        	   while(i<j) {
			        		   if(v.indexOf(k.charAt(i))==-1) {
			        			   JOptionPane.showMessageDialog(fob,"Numbers only");
			        			   t10.requestFocus();
			        			   return;
			        		   }
			        		   i++;
			        	   }
			           }
			           
			           
			          /* email=t11.getText();
			           if(email.length()<1) {
			        	   JOptionPane.showMessageDialog(fob,"enter Email-Id");
			        	   t11.requestFocus();
			        	   return;
			           }
			           
			           if(email.length()>0) {
			        	   EmailValidator obj=new EmailValidator();
			        	   boolean stat1=obj.validate(email);
			        	   if(!stat1) {
			        		   JOptionPane.showMessageDialog(fob,"Enter Proper Email-Id");
			        		   t11.requestFocus();
			        		   return;
			        	   }
			        	   
			           }
			           */
			           
			           try {
			        	   Connection con=null;
			               Statement stmt=null;
                           Class.forName("com.mysql.jdbc.Driver");
			               String user="root";
			               String pass="root";
			               String url="jdbc:mysql://localhost:3306/handler";
			               String sql="insert into data values('"+nam+"','"+lnam+"','"+fnam+"','"+rad1+"','"+edu1+"','"+edu2+"','"+edu3+"','"+add+"','"+cty+"','"+stat+"','"+dob+"','"+cntno+"','"+email+"')";
			              
			               con=DriverManager.getConnection(url, user, pass);
			               System.out.println("Connected");
			               
			               stmt=con.createStatement();
			               stmt.executeUpdate(sql);
			               
			               
			               con.close();
			              }
			           catch (Exception e) {
					e.printStackTrace();
					}
			}
		});
        
         add(b1, c);
         
         
         c.gridx=4;
         c.gridy=34;
         b2=new JButton("Reset");
         b2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
			
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t7.setText(" ");
				t9.setText(" ");
				t10.setText(" ");
				t11.setText(" ");
				ta1.setText(" ");
				ch1.setState(false);
				ch2.setState(false);
                ch3.setState(false);  
 			}
		});
         add(b2,c);
         
        
	}
	


}
