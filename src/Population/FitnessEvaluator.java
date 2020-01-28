package Population;

import java.util.ArrayList;
import Individual.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FitnessEvaluator.
 *
 * @author Janice Reilly
 * 
 * This class evaluates the Fitness of Individuals and
 * The population as a whole
 * Fittest is calculated based on the number of 1's in the chromosomes 
 * of an individual
 */

public class FitnessEvaluator{
    
    /** The individual fitness. */
    int individualFitness=0;
    
    /** The max individual fitness. */
    int maxIndividualFitness=352;
    
    /** The population fitness. */
    int populationFitness =0;
    
    /** The population. */
    ArrayList <Individual> population = new ArrayList<>();
        
    /**
     * Method to evaluate a Population of Individuals.
     *
     * @param p Population
     * @return an int value fitness
     */
        public int evaluate(Population p){
            population = p.getPopulation();
            populationFitness = 0;
            for(Individual i : population){
                populationFitness+=i.getFitness(); 
            }
            return populationFitness;
	}
    
    /**
     * Evaluates an Individual
     * Calls an overloaded version of evaluate.
     *
     * @param i individual
     */             
        public void evaluate(Individual i){
            for(Chromosome c : i.individual){
                int f =evaluate(c);
                i.setFitness(f);
            }
	}
    
    /**
     * Evaluates a Chromosome
     * Calls an overloaded version of evaluate.
     *
     * @param c Chromosome
     * @return int fitness
     */
	public int evaluate (Chromosome c){
           String s = c.toString();
           
           for (int i = 0; i<s.length(); i++){
                if (s.charAt(i)== '1') {
                    ++individualFitness;
                }
            }
           return individualFitness;
	}
     
     /**
      * Find Fittest Individual in the Population.
      *
      * @param p Population
      * @return fittest Individual
      */   
        public Individual findFittestIndividual(Population p) {
            Individual fittest = new Individual();
            int maxFitness = Integer.MIN_VALUE;
            population = p.getPopulation();
            
            for(Individual i : population){
                if(maxFitness <= i.getFitness()){
                    maxFitness = i.getFitness();
                    fittest=i;
                 }    
            }
            return fittest;
        }
    
    /**
     * Finds Fittest Female in Population.
     *
     * @param p Population
     * @return FIttest Female Individual
     */      
        public Individual findFittestFemale(Population p) {
            Individual fittestFemale = new Individual();
            int maxFitness = Integer.MIN_VALUE;
            population = p.getPopulation();
            
            for(Individual i : population){
                if(i.getSex()=='F'){
                    if(maxFitness <= i.getFitness()){
                        maxFitness = i.getFitness();
                        fittestFemale=i;
                    }
                }    
            }
            return fittestFemale;
        }
    
    /**
     * Find Fittest Male in Population.
     *
     * @param p Population
     * @return fittest Male
     */        
        public Individual findFittestMale(Population p) {
            Individual fittestMale = new Individual();
            int maxFitness = Integer.MIN_VALUE;
            population = p.getPopulation();
            
            for(Individual i : population){
                if(i.getSex()=='M'){
                    if(maxFitness <= i.getFitness()){
                        maxFitness = i.getFitness();
                        fittestMale=i;
                    }
                }    
            }
            return fittestMale;
        }
        
    /**
     * Method Least Fittest Individual iin Population.
     *
     * @param p Population
     * @return Least Fittest Indiviual
     */
        public Individual findLeastFittest(Population p) {
            Individual leastFittest = new Individual();
            int minFitness = Integer.MAX_VALUE;
            population = p.getPopulation();
            
            for(Individual i : population){
                    if(minFitness >= i.getFitness()){
                        minFitness = i.getFitness();
                        leastFittest=i;
                    }   
            }
            return leastFittest ;
        }
        
    /**
     * Method: Useful for setting fitness level in custom made child.
     *
     * @param child the child
     * @return int fitness
     */ 
        public int countChild(Individual child) {
            String s = child.getChromosomes();
            int count=0;
                for (int i = 0; i< s.length(); i++){
                   if(s.charAt(i)=='1'){
                   count++;}
            }
         return count; 
        }
}