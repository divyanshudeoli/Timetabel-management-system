package source;

import java.sql.*;  

public class conn{
    public Connection c;
    public Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///timetable","root","kunnu@555");    
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  