package source;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;
import scheduler.SchedulerMain;

public class adminmenu extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton baddteacher,baddstudent,bupdateteacher,bviewtimetable,bupdatestudent;
    public adminmenu() {
    	setBounds(600, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(76, 133, 199));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		baddteacher = new JButton("Add Teacher");
		baddteacher.addActionListener(this);
		baddteacher.setFont(new Font("Tahoma", Font.BOLD, 14));
		baddteacher.setBounds(33, 80, 145, 65);
	    baddteacher.setBackground(Color.BLACK);
	    baddteacher.setForeground(Color.WHITE);
		contentPane.add(baddteacher);

		baddstudent = new JButton("Add Student Group");
		baddstudent.addActionListener(this);
		baddstudent.setFont(new Font("Tahoma", Font.BOLD, 10));
		baddstudent.setBounds(228, 80, 145, 65);
	    baddstudent.setBackground(Color.BLACK);
	    baddstudent.setForeground(Color.WHITE);
		contentPane.add(baddstudent);

		bviewtimetable = new JButton("View Timetable");
		bviewtimetable.addActionListener(this);
		bviewtimetable.setFont(new Font("Tahoma", Font.BOLD, 10));
		bviewtimetable.setBounds(423, 80, 145, 65);
	    bviewtimetable.setBackground(Color.BLACK);
	    bviewtimetable.setForeground(Color.WHITE);
		contentPane.add(bviewtimetable);

		/*bupdatestudent = new JButton("Add Book");
		bupdatestudent.addActionListener(this);
		bupdatestudent.setFont(new Font("Tahoma", Font.BOLD, 10));
		bupdatestudent.setBounds(115, 230, 145, 65);
	    bupdatestudent.setBackground(Color.BLACK);
	    bupdatestudent.setForeground(Color.WHITE);
		contentPane.add(bupdatestudent);

		bupdateteacher = new JButton("Search Book");
		bupdateteacher.addActionListener(this);
		bupdateteacher.setFont(new Font("Tahoma", Font.BOLD, 10));
		bupdateteacher.setBounds(330, 230, 145, 65);
	    bupdateteacher.setBackground(Color.BLACK);
	    bupdateteacher.setForeground(Color.WHITE);
		contentPane.add(bupdateteacher);*/
	}
	public void actionPerformed(ActionEvent ae){
    	try{
    		if(ae.getSource()==baddteacher){
    			this.setVisible(false);
    			new addteacher().setVisible(true);
    		}
    		if(ae.getSource()==baddstudent){
    			this.setVisible(false);
    			new addstudent().setVisible(true);		
    		}
    		if(ae.getSource()==bviewtimetable){
    			this.setVisible(false);
    			new selectstudentgroup().setVisible(true);
    		}
    		/*if(ae.getSource()==bupdatestudent){
    			this.setVisible(false);
    		}
    		if(ae.getSource()==bupdateteacher){
    			this.setVisible(false);
    		}*/

    	}
    	catch(Exception e){e.printStackTrace();}

    }
    public static void main(String[] args){
    	new adminmenu().setVisible(true);
    }
}
