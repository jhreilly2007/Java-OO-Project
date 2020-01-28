/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selection;

import java.util.ArrayList;
import Individual.Individual;
import Population.Population;
// TODO: Auto-generated Javadoc

/**
 * The Class RandomSelectionA.
 *
 * @author Janice
 * RandomSelection is a concrete class implementing Selection as part of
 * my Strategy Pattern
 * 
 * To note RandomSelection A and B do the same thing. They are only to demonstrate the 
 * abstract and factory pattern
 * 
 * Random Selection picks parents based on Randomness and Sex
 */
public class RandomSelectionA implements Selection{

    /** The population. */
    ArrayList <Individual> population = new ArrayList<>(); 
    
    /** The size. */
    int size = 0;
    
    /** The random. */
    int random = 0;
        
        /**
         * Select female parent.
         *
         * @param aPopulation the a population
         * @return the individual
         */
        @Override
        public Individual selectFemaleParent(Population aPopulation){
            population = aPopulation.getPopulation();
            size = Population.getPopulationSize();
            random = (int)(Math.random()*size);
   
            //need to Select a Female randomly from population
            while(population.get(random).getSex()!='F'){
                 random = (int)(Math.random()*size);
                }
            Individual rouletteFemale = population.get(random);
            return rouletteFemale;
	}
        
        /**
         * Select male parent.
         *
         * @param aPopulation the a population
         * @return the individual
         */
        @Override
        public Individual selectMaleParent(Population aPopulation){
            population = aPopulation.getPopulation();
            size = Population.getPopulationSize();
            random = (int)(Math.random()*size);
            
            //need to Select a Male randomly from population
                while(population.get(random).getSex()!='M'){
                 random = (int)(Math.random()*size);
                }
            Individual rouletteMale = population.get(random);
            return rouletteMale;
	}
}
