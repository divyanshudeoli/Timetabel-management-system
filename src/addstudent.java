package source;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class addstudent extends JFrame implements ActionListener {

    private JPanel contentPane;
 	private JTextField textname;
 	private JTextField textsubjects;
    private JButton  b1,b2;

    public addstudent() {
        setBounds(600, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setBackground(new Color(76, 133, 199));
		contentPane.setLayout(null);

		JLabel lbldesc = new JLabel("Add Student Groups");
		lbldesc.setForeground(new Color(0,0,0));
		lbldesc.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbldesc.setBounds(180, 5, 260, 70);
		contentPane.add(lbldesc);

		JLabel lblname = new JLabel("Name");
		lblname.setForeground(new Color(0,0,0));
		lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblname.setBounds(49, 62, 92, 26);
		contentPane.add(lblname);

		JLabel lblsubjects = new JLabel("Subjects");
		lblsubjects.setForeground(new Color(0,0,0));
		lblsubjects.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblsubjects.setBounds(300, 62, 100, 26);
		contentPane.add(lblsubjects);

		textname =new JTextField();
		textname.setBounds(49, 105,70,26);
		textname.setFont(new Font("Tahoma",Font.PLAIN,14));
		textname.setForeground(new Color(0,0,0));
		contentPane.add(textname);
		
	    textsubjects =new JTextField();
		textsubjects.setBounds(150, 105,400,26);
		textsubjects.setFont(new Font("Tahoma",Font.PLAIN,14));
		textsubjects.setForeground(new Color(0,0,0));
		contentPane.add(textsubjects);

		b1 = new JButton("Back");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b1.setBounds(120, 200, 120, 50);
		b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		b2 = new JButton("Add");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b2.setBounds(360, 200, 120, 50);
		b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		contentPane.add(b2);
    }
  
    public void actionPerformed(ActionEvent ae){
        try{
		    if(ae.getSource() == b1){
		    	this.setVisible(false);
		    	new adminmenu().setVisible(true);
		    }
		    if(ae.getSource() == b2){
		    	conn con=new conn();
		    	String sql = "insert into student values(?,?)";				
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, textname.getText());
				st.setString(2, textsubjects.getText());
				st.close();
				con.c.close();
		    }
		}catch(Exception e){}
  	}
  	public static void main(String[] args) {
  		new addstudent().setVisible(true);
  	}
}
