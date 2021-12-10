package scheduler;
import java.util.*;
public class SchedulerMain{
	List<Chromosome> firstlist;
	List<Chromosome> newlist;
	double firstlistfitness;
	double newlistfitness;
	int populationsize=1000;
	int maxgenerations=100;
	public static Chromosome finalson;
	static String stugroup;
	public SchedulerMain(String stugroup) {
		this.stugroup=stugroup;
		//Utility.printInputData();
		new TimeTable();
		//Utility.printSlots();
		initialisePopulation();
		createNewGenerations();
	}

	public void createNewGenerations(){
		Chromosome father=null;
		Chromosome mother=null;
		Chromosome son=null;
		int nogenerations=0;
		while(nogenerations<maxgenerations){	
			newlist=new ArrayList<Chromosome>();
			newlistfitness=0;
			int i=0;
			for(i=0;i<populationsize/10;i++){	
				newlist.add(firstlist.get(i).deepClone());		
				newlistfitness+=firstlist.get(i).getFitness();
			}
			while(i<populationsize){
				father=selectParentRoulette();
				mother=selectParentRoulette();
				if(new Random().nextDouble()<inputdata.crossoverrate){
					son=crossover(father,mother);	
				}else
					son=father;
				customMutation(son);
				if(son.fitness==1){
					System.out.println("Selected Chromosome is:-");
					son.printChromosome();
					break;
				}
				
				newlist.add(son);
				newlistfitness+=son.getFitness();
				i++;
			}
			
			if(i<populationsize){
				System.out.println("****************************************************************************************");
				System.out.println("\n\nSuitable Timetable has been generated in the "+i+"th Chromosome of "+(nogenerations+2)+" generation with fitness 1.");
				System.out.println("\nGenerated Timetable is:");
				son.printTimeTable(stugroup);
				finalson=son;
				break;
			}

			firstlist=newlist;
			Collections.sort(newlist);Collections.sort(firstlist);
			System.out.println("**************************     Generation"+(nogenerations+2)+"     ********************************************\n");
			printGeneration(newlist);
			nogenerations++;
		}
	}
	
	public Chromosome selectParentRoulette(){
		firstlistfitness/=10;
		double randomdouble=new Random().nextDouble()*firstlistfitness;
		double currentsum=0;
		int i=0;
		while(currentsum<=randomdouble)
			currentsum+=firstlist.get(i++).getFitness();
		i=i-1;
		System.out.println(i);
		return firstlist.get(i).deepClone();
	}
		
	public void customMutation(Chromosome c){
		double newfitness=0,oldfitness=c.getFitness();
		int geneno=new Random().nextInt(inputdata.nostudentgroup);
		int i=0;
		while(newfitness<oldfitness){
			c.gene[geneno]=new Gene(geneno);
			newfitness=c.getFitness();
			i++;
			if(i>=500000) break;
		}
	}	
	
	public Chromosome crossover(Chromosome father,Chromosome mother){
		int randomint=new Random().nextInt(inputdata.nostudentgroup);
		Gene temp=father.gene[randomint].deepClone();
		father.gene[randomint]=mother.gene[randomint].deepClone();
		mother.gene[randomint]=temp;
		if(father.getFitness()>mother.getFitness())return father;
		else return mother;
	}
	
	public void initialisePopulation(){
		firstlist=new ArrayList<Chromosome>();
		firstlistfitness=0;
		for(int i=0;i<populationsize;i++){
			Chromosome c;
			firstlist.add(c=new Chromosome());
			firstlistfitness+=c.fitness;
		}
		Collections.sort(firstlist);
		System.out.println("----------Initial Generation-----------\n");
		printGeneration(firstlist);
	}
	
	public void printGeneration(List<Chromosome> list){
		System.out.println("Fetching details from this generation...\n");	
		for(int i=0;i<4;i++){
			System.out.println("Chromosome no."+i+": "+list.get(i).getFitness());
			list.get(i).printChromosome();
			System.out.println("");
		}
		System.out.println("Chromosome no. "+(populationsize/10+1)+" :"+list.get(populationsize/10+1).getFitness()+"\n");
		System.out.println("Chromosome no. "+(populationsize/5+1)+" :"+list.get(populationsize/5+1).getFitness()+"\n");
		System.out.println("Most fit chromosome from this generation has fitness = "+list.get(0).getFitness()+"\n");
	}
	
	public Chromosome selectParentBest(List<Chromosome> list){
		Random r=new Random();
		int randomint=r.nextInt(100);
		return list.get(randomint).deepClone();
	}
	
	public void mutation(Chromosome c){
		int geneno=new Random().nextInt(inputdata.nostudentgroup);
		int temp=c.gene[geneno].slotno[0];
		for(int i=0;i<inputdata.daysperweek*inputdata.hoursperday-1;i++){
			c.gene[geneno].slotno[i]=c.gene[geneno].slotno[i+1];
		}
		c.gene[geneno].slotno[inputdata.daysperweek*inputdata.hoursperday-1]=temp;
	}
	
	public void swapMutation(Chromosome c){
		int geneno=new Random().nextInt(inputdata.nostudentgroup);
		int slotno1=new Random().nextInt(inputdata.hoursperday*inputdata.daysperweek);
		int slotno2=new Random().nextInt(inputdata.hoursperday*inputdata.daysperweek);
		int temp=c.gene[geneno].slotno[slotno1];
		c.gene[geneno].slotno[slotno1]=c.gene[geneno].slotno[slotno2];
		c.gene[geneno].slotno[slotno2]=temp;
	}
	
	public static void main(String[] args) {
		new SchedulerMain(stugroup);
	}
}