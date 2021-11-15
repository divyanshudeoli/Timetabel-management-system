package scheduler;
public class Slot{
	public StudentGroup studentgroup;
	public int teacherid;
	public String subject;
	Slot(){};
	Slot(StudentGroup studentgroup,int teacherid,String subject){
		this.studentgroup=studentgroup;
		this.subject=subject;
		this.teacherid=teacherid;
	}
}