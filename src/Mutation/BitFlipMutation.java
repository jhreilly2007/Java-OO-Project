/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutation;

import java.util.Random;
import Individual.Individual;
import Individual.Chromosome;

// TODO: Auto-generated Javadoc
/**
 * The Class BitFlipMutation.
 *
 * @author Janice
 * 
 * BitFlipMutation is a concrete class implementing Mutation as part of
 * my Strategy Pattern
 * 
 * As Fitness is calculated by totaling the no. of 1's it can adversely or
 * positively affect the fitness levels of an Individual
 * 
 * As Mutation is a low probability operation. BitFLipMutation only occurs 
 * based on a random number generation being lower than the mutation rate
 * 
 * Selects 2 binary genes at flips them
 */
public class BitFlipMutation implements Mutation{
    
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
           int numberOfMutations = 2;

           mutant.individual.clear();//clear chromosomes assigned on initialisation
           mutant.setFitness(0);
           Random rand = new Random();
           
           //Determines if mutation should occur
           if (Math.random() <= mutationRate) {
                for (int i = 0; i<numberOfMutations;i++){
                    int random = rand.nextInt(child1.individual.size());
                    Chromosome c = child1.individual.get(random);
                    int randomGene = rand.nextInt(c.genes.length);
                    
                    flipBinaryGene(c.genes[randomGene].code);
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
     public String flipBinaryGene(String str){ 
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

  