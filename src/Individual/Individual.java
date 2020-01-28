package Individual;

/**
 * @author Janice Reilly
 * 
 * This class models an Individual
 * An Individual is made up of pairs of 22*AutoSomes and 1*sex Chromosome
 * Note: I am not doubling chromosomes in this program
 *
*/

import java.util.ArrayList;
import Population.FitnessEvaluator;

// TODO: Auto-generated Javadoc
/**
 * The Class Individual.
 */
public final class Individual{
 
	/** Chromosome Attributes. */
	int autosomes = 22;
        
        /** The sex. */
        int sex = Math.random()>0.5 ? 3:4;//3 is female 4 male
        
        /** The fitness. */
        int fitness;
        
    /** ArrayList to hold an Individuals list of Chromosomes. */
	public ArrayList <Chromosome> individual = new ArrayList<>();
        
    /** Each Individual needs to have fitness accessed. */
    FitnessEvaluator f = new FitnessEvaluator();
	
	/**
	 * No-args constructor. generates an individual made of 
	 * 22 autosome Chromosomes and 1 sex chromosome
	 * Evaluates fitness of Individual and assigns to fitness variable
	*/
	public Individual(){
		for (int i = 0; i < autosomes; i++){
			add( new Chromosome());
			}
            add(new Chromosome(sex)); 
            f.evaluate(this);
	}
        
	/**
	 * Method to add a Chromosom.
	 *
	 * @param aChromosome the a chromosome
	 */
	public void add(Chromosome aChromosome){
            individual.add(aChromosome);//which will be a chromosome
	}
        
     /**
      * Method to set an Individuals Fitness.
      *
      * @param aFitness the new fitness
      */
    public void setFitness(int aFitness){
            fitness = aFitness; //need a 'fitness'
	}
        
   /**
    * Method to get an Individuals Fitness.
    *
    * @return s
    */
    public int getFitness(){
            return fitness;
	}
        
   /**
    * Method to determine an Individuals Sex.
    *
    * @return x
    */
    public char getSex(){
            if(sex==3){
		return 'F';
            }else
                return 'M';
            }
        
   /**
    * Method to get a Chromosome from an Individual.
    *
    * @return String
    */
     public String getChromosomes(){
    	 StringBuilder chromosomeAsString = new StringBuilder();
    	 String s;
    	 for(Chromosome c : individual){
    		 chromosomeAsString.append(c.toString());//how to get the chromosome out of Individual
    		 }
    	 s=chromosomeAsString.toString();
    	 return s;
	}
       
     /**
      * To string.
      *
      * @return the string
      */
     @Override
     public String toString(){
    	 StringBuilder individualAsString = new StringBuilder();
    	 for(Chromosome c : individual){
    		 individualAsString.append(c.toString()+"\n"); //how to get the chromosome out of population
    		 }
    	 String fitString = String.format("%d%n", fitness);
    	 individualAsString.append("\t"+fitString);
    	 return individualAsString.toString();
     }
}