package scheduler;

import java.io.File;
import java.util.*;
import source.conn;
import java.sql.*;
public class inputdata {
	public static StudentGroup[] studentgroup;
	public static Teacher[] teacher;
	public static double crossoverrate = 0.8, mutationrate = 0.08;
	public static int nostudentgroup, noteacher;
	public static int hoursperday, daysperweek;

	public inputdata() {
		studentgroup = new StudentGroup[100];
		teacher =   new Teacher[100];
		takeinput();
	}

	/*boolean classformat(String l) {
		StringTokenizer st = new StringTokenizer(l, " ");
		if (st.countTokens() == 3) return (true);
		else return (false);
	}*/

	public void takeinput(){
		hoursperday = 7;
		daysperweek = 5;
		try{
			conn con = new conn();
			String sql = "select * from student;";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			int i=0,j=0;
			while(rs.next()){
				studentgroup[i] = new StudentGroup();
				StringTokenizer stn = new StringTokenizer(rs.getString(2), " ");
				studentgroup[i].id = i;
				studentgroup[i].name = rs.getString(1);
				studentgroup[i].nosubject = 0;
				while (stn.hasMoreTokens()) {
					studentgroup[i].subject[j] = stn.nextToken();
					studentgroup[i].hours[j++] = Integer.parseInt(stn.nextToken());
					studentgroup[i].nosubject++;
				}
				i++;
			}
			nostudentgroup = i;
			st.close();
			sql = "select * from teacher;";
			st = con.c.prepareStatement(sql);
			rs=st.executeQuery();
			i = 0;
			while(rs.next()){
				teacher[i] = new Teacher();
				teacher[i].id = i;
				teacher[i].name = rs.getString(1);
				teacher[i].subject = rs.getString(2);
				i++;
			}
			noteacher = i;
			st.close();
			con.c.close();
		}
		catch(Exception e){
			e.printStackTrace(System.out);
			System.out.println("Inside constructor");
		} 
		assignTeacher(); 
	}

	
	public void assignTeacher() {
		try{
		for (int i = 0; i < nostudentgroup; i++) {
			for (int j = 0; j < studentgroup[i].nosubject; j++) {
				int teacherid = -1;
				int assignedmin = -1;
				String subject = studentgroup[i].subject[j];
				for (int k = 0; k < noteacher; k++) {
					if (teacher[k].subject.equalsIgnoreCase(subject)) {
						if (assignedmin == -1) {
							assignedmin = teacher[k].assigned;
							teacherid = k;
						}
						else if (assignedmin > teacher[k].assigned) {
							assignedmin = teacher[k].assigned;
							teacherid = k;
						}
					}
				}
				teacher[teacherid].assigned++;
				studentgroup[i].teacherid[j]= teacherid;
			}
		}
		}
		catch (Exception e){e.printStackTrace(System.out);
			System.out.println("Inside assign");}
	}
	public static void main(String args[]){
		new inputdata();
		System.out.println(nostudentgroup);
	}
}