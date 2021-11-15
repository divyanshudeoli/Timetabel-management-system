package scheduler;
import java.io.File;
import java.util.*;

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

	boolean classformat(String l) {
		StringTokenizer st = new StringTokenizer(l, " ");
		if (st.countTokens() == 3) return (true);
		else return (false);
	}

	public void takeinput()
	{
		hoursperday = 7;
		daysperweek = 5;
		try {
			File file = new File("C:\\Users\\sampr\\Timetable_Management_System\\input.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.equalsIgnoreCase("studentgroups")) {
					int i = 0, j;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("teachers")) {
						studentgroup[i] = new StudentGroup();
						StringTokenizer st = new StringTokenizer(line, " ");
						studentgroup[i].id = i;
						studentgroup[i].name = st.nextToken();
						studentgroup[i].nosubject = 0;
						j = 0;
						while (st.hasMoreTokens()) {
							studentgroup[i].subject[j] = st.nextToken();
							studentgroup[i].hours[j++] = Integer.parseInt(st.nextToken());
							studentgroup[i].nosubject++;
						}
						i++;
					}
					nostudentgroup = i;
				}

				if (line.equalsIgnoreCase("teachers")) {
					int i = 0;
					while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
						teacher[i] = new Teacher();
						StringTokenizer st = new StringTokenizer(line, " ");
						teacher[i].id = i;
						teacher[i].name = st.nextToken();
						teacher[i].subject = st.nextToken();

						i++;
					}
					noteacher = i;
				}

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assignTeacher();
	}

	public void assignTeacher() {
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
	}/*
	public static void main(String args[]){
		new inputdata();
		System.out.println(nostudentgroup);
	}*/
}