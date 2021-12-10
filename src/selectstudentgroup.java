package source;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import scheduler.SchedulerMain;

public class selectstudentgroup extends JFrame implements ActionListener {
	private JPanel contentPane;
    private JButton button1,button2;
    JComboBox comboBox;
    JLabel lstugroup,lselect;

    public selectstudentgroup() {
        setBounds(600, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(76, 133, 199));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lselect = new JLabel("Select Student group");
		lselect.setForeground(new Color(0,0,0));
		lselect.setFont(new Font("Tahoma", Font.BOLD, 25));
		lselect.setBounds(170, 30, 270, 70);
		contentPane.add(lselect);


		lstugroup = new JLabel("Select");
		lstugroup.setForeground(new Color(0,0,0));
		lstugroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lstugroup.setBounds(140, 140, 130, 40);
		contentPane.add(lstugroup);

		comboBox = new JComboBox();
		comboBox.setBounds(330, 140, 130, 40);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(comboBox);

		try{
			conn con=new conn();
			String sql="select name from student;";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				comboBox.addItem(rs.getString(1));
			}
			st.close();
			con.c.close();
		}
		catch(Exception e){System.out.println(e);}


	    button1 = new JButton("Show");
		button1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
	    button1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		button1.setBounds(130, 270, 148, 53);
	    button1.setBackground(Color.BLACK);
	    button1.setForeground(Color.WHITE);
		contentPane.add(button1);
		button1.addActionListener(this);

		button2 = new JButton("Back");
		button2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		button2.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		button2.setBounds(330, 270, 148, 53);
	    button2.setBackground(Color.BLACK);
	    button2.setForeground(Color.WHITE);
		button2.addActionListener(this);
		contentPane.add(button2);
    }

    public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==button1){
			//System.out.println(comboBox.getSelectedItem());
			new SchedulerMain((String)comboBox.getSelectedItem());		
		}
    	if(ae.getSource()==button2){
    		this.setVisible(false);
    		new actor().setVisible(true);
    	}
    }

    public static void main(String[] args) {
    	new selectstudentgroup().setVisible(true);
    }
}