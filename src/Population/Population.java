package Population;

import java.util.ArrayList;
import Individual.Individual;
// TODO: Auto-generated Javadoc

/**
 * The Class Population.
 *
 * @author Janice Reilly
 * 
 * Class to Represent a Population 
 * I have implemented the Singleton Pattern using Eager Initialization
 * to keep thread safe.
 * I only want one instance of population so all classes are working from the
 * same instance.
 */

public class Population{
    
    /** This is where I implemented by Singleton Using Eager Initialization to make thread-safe. */
    private static final Population onePopulation =new Population();
    
    /** The size. */
    private final int size=100; //to protect size being altered
    
    /** The population. */
    private final ArrayList <Individual> population = new ArrayList<>();//need a list of Chromosomes!    
	/**
	* No-args constructor. 
        * If called -  generates a randomly population of Individuals
        * Private Constructor can only be called in this class
        * Only one instance of Population
	*/
	private Population(){
            for (int i = 0; i < size; i++){
                add( new Individual());   
            }	
	}
        
        /**
         *  
         * Method add Individual to Population.
         *
         * @param anIndividual the an individual
         * @params Individual
         */
	private void add(Individual anIndividual){
            population.add(anIndividual);//which will be a chromosome
	}
        
        /**
         * Method to getReference to our singleton from another class.
         *
         * @return reference to Population
         */
        public static Population getReference(){
            return onePopulation;
	}
        
        /**
         * Gets the population size.
         *
         * @return size of Population
         */
        public static int getPopulationSize(){
            return onePopulation.size;
	}
        
        /**
         * Gets the population.
         *
         * @return ArrayList of Individuals in the population
         */
        
        public ArrayList<Individual> getPopulation(){//need to implement my add chrome method
            return onePopulation.population;
	}
	
	/**
	 * Method setPopulation to replace an individual in the population.
	 *
	 * @param i Individual
	 * @param index value
	 */
        public void setPopulation(Individual i, int index){
            onePopulation.population.set(index, i);
	}
        
    /**
     * To string.
     *
     * @return the string
     */
    @Override
	public String toString(){
            StringBuilder populationAsString = new StringBuilder();
            for(Individual i : population){
                populationAsString.append(i.toString()+"\n");
            }
            return populationAsString.toString();
	}
}