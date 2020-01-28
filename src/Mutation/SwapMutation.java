package Mutation;

import java.util.Random;
import Individual.Individual;
import Individual.Chromosome;

// TODO: Auto-generated Javadoc
/**
 * The Class SwapMutation.
 *
 * @author Janice
 * 
 * BitFlipMutation is a concrete class implementing Mutation as part of
 * my Strategy Pattern
 * 
 * As Fitness is calculated by totaling the no. of 1's it can adversely or
 * positively affect the fitness levels of an Individual
 * 
 * As Mutation is a low probability operation. SwapMutation only occurs 
 * based on a random number generation being lower than the mutation rate
 * 
 * As swapping bits is not effective in a binary genes for demonstration 
 * purposes I have flipped three bits as opposed to 2 in bitflipMutation
 */
public class SwapMutation implements Mutation{
    
        /**
         * Mutate.
         *
         * @param child1 the child 1
         * @param mutationRate the mutation rate
         * @return the individual
         */
        @Override
        public Individual mutate(Individual child1, double mutationRate){
           Individual mutant = new Individual();
           int numberOfMutations = 3;

           mutant.individual.clear();//clear chromosomes assigned on initialisation
           mutant.setFitness(0);
           Random rand = new Random();
           
           //Determines if mutation should occur
           if (Math.random() <= mutationRate) {

                for (int i = 0; i<numberOfMutations;i++){
                    int random = rand.nextInt(child1.individual.size());
                    Chromosome c = child1.individual.get(random);
                    int randomGene = rand.nextInt(c.genes.length);

                    //Binary String now has 3 bits flipped
                    swapBinaryGene(c.genes[randomGene].code);
                }
            return mutant;
           }else{
               return child1;
           }
        }
 
 /**
  * Method to flip Bits in a Binary String.
  *
  * @param str the str
  * @return mutated String
  */  
       public String swapBinaryGene(String str){ 
            char c = '0';
            String newString = "";

            for (int i = 0; i < str.length(); i++) { 
            	if (str.charAt(i) != c){
            		newString = newString+"0";
                    }else
                    	newString = newString+"1"; 
                }
            return newString;
            }
}
