package source;
import javax.swing.*;    
public class printtimetable {    
    JFrame f;    
    printtimetable(){    
    f=new JFrame();    
    JTable jt=new JTable();    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
}     
}  