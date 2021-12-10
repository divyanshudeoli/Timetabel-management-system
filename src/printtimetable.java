package source;
import java.awt.*;
import javax.swing.*; 
import javax.swing.*;    
public class printtimetable extends JFrame{    
    public printtimetable(String[][] data){
        setBackground(new Color(169, 169, 169));    
        setBounds(600, 300, 600, 400);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        String[] days ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        JTable jt=new JTable(data,days);    
        jt.setBounds(10,70,580,300);     
        panel.add(jt);
    }
}  