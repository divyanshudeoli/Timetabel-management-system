package source;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;


public class adminmenu extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton baddteacher,baddstudent,bsearch,bchangepass,baddbook;
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

		bchangepass = new JButton("Change Password");
		bchangepass.addActionListener(this);
		bchangepass.setFont(new Font("Tahoma", Font.BOLD, 10));
		bchangepass.setBounds(423, 80, 145, 65);
	    bchangepass.setBackground(Color.BLACK);
	    bchangepass.setForeground(Color.WHITE);
		contentPane.add(bchangepass);

		baddbook = new JButton("Add Book");
		baddbook.addActionListener(this);
		baddbook.setFont(new Font("Tahoma", Font.BOLD, 10));
		baddbook.setBounds(115, 230, 145, 65);
	    baddbook.setBackground(Color.BLACK);
	    baddbook.setForeground(Color.WHITE);
		contentPane.add(baddbook);

		bsearch = new JButton("Search Book");
		bsearch.addActionListener(this);
		bsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		bsearch.setBounds(330, 230, 145, 65);
	    bsearch.setBackground(Color.BLACK);
	    bsearch.setForeground(Color.WHITE);
		contentPane.add(bsearch);
	}
	public void actionPerformed(ActionEvent ae){
    	try{
    		if(ae.getSource()==baddbook){
    			this.setVisible(false);
    		}
    		if(ae.getSource()==bchangepass){
    			this.setVisible(false);
    		}
    		if(ae.getSource()==bsearch){
    			this.setVisible(false);
    		}

    		if(ae.getSource()==baddteacher){
    			this.setVisible(false);
    		}
    		if(ae.getSource()==baddstudent){
    			this.setVisible(false);
    		}

    	}
    	catch(Exception e){e.printStackTrace();}

    }
    public static void main(String[] args){
    	new adminmenu().setVisible(true);
    }
}
