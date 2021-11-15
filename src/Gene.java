package scheduler;
import java.util.Random;
import java.io.*;
public class Gene implements Serializable{
	public int slotno[];
	int days=inputdata.daysperweek;
	int hours=inputdata.hoursperday;
	Random r=new Random();
	Gene(int i){
		boolean[] flag=new boolean[days*hours];
		slotno=new int[days*hours];
		for(int j=0;j<days*hours;j++){
			int rnd;
			while(flag[rnd=r.nextInt(days*hours)]==true){}
			flag[rnd]=true;
			slotno[j]=i*days*hours + rnd;
		}
	}
	public Gene deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Gene) ois.readObject();
		} 
		catch (IOException e) {
			return null;} 
		catch (ClassNotFoundException e) {
			return null;}
	}
}