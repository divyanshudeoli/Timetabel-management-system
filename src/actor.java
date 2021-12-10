package source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import scheduler.SchedulerMain;

public class actor extends JFrame implements ActionListener{

	private JPanel panel;
    private JButton student,teacher,admin;

	public actor() {
	setBackground(new Color(169, 169, 169));	
    setBounds(600, 300, 600, 400);
		
    panel = new JPanel();
	panel.setBackground(new Color(76, 133, 199));
	setContentPane(panel);
	panel.setLayout(null);

	student = new JButton("Student");	            
	student.setForeground(new Color(46, 139, 87));
	student.setBackground(new Color(250, 250, 210));
	student.setBounds(180, 100, 240, 60);
	student.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	panel.add(student);
	student.addActionListener(this);

		
    /*teacher = new JButton("Teacher");
	teacher.setForeground(new Color(46, 139, 87));
	teacher.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	teacher.setBackground(new Color(250, 250, 210));
	teacher.setBounds(180, 170, 240, 60);
	panel.add(teacher);
	teacher.addActionListener(this);*/

	admin = new JButton("Admin");
	admin.setForeground(new Color(46, 139, 87));
	admin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	admin.setBackground(new Color(250, 250, 210));
	admin.setBounds(180, 240, 240, 60);
	panel.add(admin);
	admin.addActionListener(this);
	}


    public void actionPerformed(ActionEvent ae){
    		if(ae.getSource()==student){
    			this.setVisible(false);
    			new selectstudentgroup().setVisible(true);
				//new printtimetable().setVisible(true);
			}   
    		if(ae.getSource()==admin){
    			this.setVisible(false);
    			new loginadmin().setVisible(true);
    		}
    	} 

  	public static void main(String[] args) {
        new actor().setVisible(true);
	}
}