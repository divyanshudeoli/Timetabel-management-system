package scheduler;
import java.io.*;
import java.util.*;
import javax.swing.*;
import source.printtimetable;

public class Chromosome implements Comparable<Chromosome>,Serializable{
	static double crossoverrate=inputdata.crossoverrate;
	static double mutationrate=inputdata.mutationrate;
	static int hours=inputdata.hoursperday,days=inputdata.daysperweek;
	static int nostgrp=inputdata.nostudentgroup;
	double fitness;
	int point;
	public Gene[] gene;
	Chromosome(){
		gene=new Gene[nostgrp];
		for(int i=0;i<nostgrp;i++)
			gene[i]=new Gene(i);
		fitness=getFitness();		
	}
	public Chromosome deepClone() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Chromosome) ois.readObject();
		} 
		catch (IOException e) {
			return null;}
		catch (ClassNotFoundException e) {
			return null;}
	}

	public double getFitness(){
		point=0;
		for(int i=0;i<hours*days;i++){
			List<Integer> teacherlist=new ArrayList<Integer>();
			for(int j=0;j<nostgrp;j++){
				Slot slot;
				if(TimeTable.slot[gene[j].slotno[i]]!=null)
					slot=TimeTable.slot[gene[j].slotno[i]];
				else slot=null;
				if(slot!=null){
					if(teacherlist.contains(slot.teacherid)) point++;
					else teacherlist.add(slot.teacherid);
				}
			}	
		}
		//System.out.println(point+" "+nostgrp);
		fitness=1-(point/((nostgrp-1.0)*hours*days));
		//System.out.println(fitness);
		point=0;
		return fitness;
	}

	public void printTimeTable(String stugroup){
		String[][] timetabele=new String[days][hours];
		String batch="";
		for(int i=0;i<nostgrp;i++){
			boolean status=false;
			int l=0;
			while(!status){
				if(TimeTable.slot[gene[i].slotno[l]]!=null){
					System.out.println("Batch "+TimeTable.slot[gene[i].slotno[l]].studentgroup.name+" Timetable-");
					batch=TimeTable.slot[gene[i].slotno[l]].studentgroup.name;
					status=true;
				}
				l++;
			}
			if(batch.equals(stugroup)){
				for(int j=0;j<days;j++){
					for(int k=0;k<hours;k++){
						if(TimeTable.slot[gene[i].slotno[k+j*hours]]!=null){
							System.out.print(TimeTable.slot[gene[i].slotno[k+j*hours]].subject+" ");
							timetabele[j][k]=TimeTable.slot[gene[i].slotno[k+j*hours]].subject;
						}
						else {
							System.out.print("*FREE* ");
							timetabele[j][k]="Free";
						}
					}
				}
				new printtimetable(timetabele).setVisible(true);
				System.out.println("\n\n\n");
				break;
			}
		}
	}
	
	public void printChromosome(){
		for(int i=0;i<nostgrp;i++){
			for(int j=0;j<hours*days;j++){
				System.out.print(gene[i].slotno[j]+" ");
			}
			System.out.println("");
		}
	}
	public int compareTo(Chromosome c) {
		if(fitness==c.fitness) return 0;
		else if(fitness>c.fitness) return -1;
		else return 1;
	}
}