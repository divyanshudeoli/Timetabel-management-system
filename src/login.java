package source;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
    private JButton button1,button2;


	public login() {
            
	setBackground(new Color(169, 169, 169));	
    setBounds(600, 300, 600, 400);
		
    panel = new JPanel();
	panel.setBackground(new Color(76, 133, 199));
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("User ID : ");
	l1.setBounds(124, 89, 135, 34);
	l1.setFont(new Font("Tahoma", Font.BOLD, 16));
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 164, 135, 34);
	l2.setFont(new Font("Tahoma", Font.BOLD, 16));
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(290, 89, 135, 34);
	textField.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	textField.setColumns(10);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(290, 164, 135, 35);
	passwordField.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	passwordField.setColumns(10);
	panel.add(passwordField);

	button1 = new JButton("Login");	            
	button1.setForeground(new Color(46, 139, 87));
	button1.setBackground(new Color(250, 250, 210));
	button1.setBounds(119, 241, 153, 59);
	button1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	panel.add(button1);
	button1.addActionListener(this);

		
    button2 = new JButton("SignUp");
	button2.setForeground(new Color(46, 139, 87));
	button2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	button2.setBackground(new Color(250, 250, 210));
	button2.setBounds(309, 241, 153, 59);
	panel.add(button2);
	button2.addActionListener(this);

	}


    public void actionPerformed(ActionEvent ae){
    		if(ae.getSource()==button1){
    			try {
                    conn con = new conn();
                    String sql = "select * from user where User_id=? and Password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    calculateBlockHash bhash= new calculateBlockHash(passwordField.getText(),"MD5");
                    st.setString(1, textField.getText());
                    st.setString(2,bhash.hash);

                    int uid=Integer.parseInt(textField.getText());
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                    } else
						JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                con.c.close();
                }
		 		catch (Exception e) {
                    e.printStackTrace();
					}
    		}   
    		if(ae.getSource()==button2){
    			this.setVisible(false);
    			//new signup().setVisible(true);
    		}
    	} 

  	public static void main(String[] args) {
        new login().setVisible(true);
	}
}