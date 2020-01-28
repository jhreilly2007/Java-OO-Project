package Reproduction;

import Individual.Individual;
import Population.FitnessEvaluator;
import Individual.Chromosome;

// TODO: Auto-generated Javadoc
/**
 * The Class UniformCrossoverB.
 *
 * @author Janice
 * UniformCrossoverB is a concrete class implementing Reproduction as part of
 * my Strategy Pattern
 * 
 * To note Uniform A and B do the same thing. They are only to demonstrate the 
 * abstract and factory pattern
 * 
 * Uniform Crossover Reproduces a child by assigning alternate genes from parent1 
 * and parent 2. 
 * The child's sex is determined randomly
 */
public class UniformCrossoverB implements Reproduction{
 
 /** The f. */
 FitnessEvaluator f = new FitnessEvaluator();
    

        /**
         * Crossover.
         *
         * @param parent1 the parent 1
         * @param parent2 the parent 2
         * @return the individual
         */
        @Override
        public Individual crossover(Individual parent1, Individual parent2){
            Individual child = reproduce(parent1, parent2);
            return child;
	}
  
  /**
   *  
   * Method reproduce 
   * Reproduces a child by assigning alternate genes from parent1 and parent 2. 
   * Assigns Sex separately
   *
   * @param parent1 the parent 1
   * @param parent2 the parent 2
   * @return a new Individual
   */
        public Individual reproduce(Individual parent1, Individual parent2){
            Individual child = new Individual();

            child.individual.clear();//Clear initialised values to make custom child
            child.setFitness(0);

            int sex = Math.random()>0.5 ? 3:4;//3 is female 4 male
            int length = parent1.individual.size()-2;//minus sex chromosome & Out of Bound
            
            //Fill child chromosomes from parents
                for (int i = 0; i<length; i+=2){
                    child.individual.add(parent1.individual.get(i));
                    child.individual.add(parent2.individual.get(i+1));
                }
            child.individual.add(new Chromosome(sex));
            child.setFitness(f.countChild(child));
            
            return child;
            
        } 
}