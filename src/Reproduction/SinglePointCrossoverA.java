package Reproduction;

import java.util.Random;
import Individual.Individual;
import Population.FitnessEvaluator;
import Individual.Chromosome;

// TODO: Auto-generated Javadoc
/**
 * The Class SinglePointCrossoverA.
 *
 * @author Janice
 * SinglePointCrossoverB is a concrete class implementing Reproduction as part of
 * my Strategy Pattern
 * 
 * To note SinglePoint A and B do the same thing. They are only to demonstrate the 
 * abstract and factory pattern
 * 
 * SinglePointCrossOver Reproduces a child by assigning genes from parent1 up to a 
 * cross over Point. The remainder is filled with genes from parent2
 * The child's sex is determined randomly
 */

public class SinglePointCrossoverA implements Reproduction{
    
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
    * Method reproduce 
    * 1. Select a point to randomly crossover
    * 2. Takes all parent 1 genes to crossover point
    * 3. and takes the Remainder from parent 2
    * 4. Sex is assigned randomly
    *
    * @param parent1 the parent 1
    * @param parent2 the parent 2
    * @return a new Individual
    */  
        public Individual reproduce(Individual parent1, Individual parent2){
            Individual child = new Individual();
            //Clear initialised values to make custom child
            child.individual.clear();
            child.setFitness(0);

            int sex = Math.random()>0.5 ? 3:4;//3 is female 4 male
            int length = parent1.individual.size()-1;//minus sex chromosome
            
            Random rand = new Random();
            int crossoverIndex = rand.nextInt(length);
            //Fill child chromosomes from parents
                for (int i = 0; i<crossoverIndex; i++){
                    child.individual.add(parent1.individual.get(i));
                }
                for (int i = crossoverIndex; i<length; i++){
                    child.individual.add(parent2.individual.get(i));
                }
            child.individual.add(new Chromosome(sex));
            child.setFitness(f.countChild(child));

            return child;
            
        } 
}
