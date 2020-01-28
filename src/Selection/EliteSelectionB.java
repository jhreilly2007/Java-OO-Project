package Selection;

import Individual.Individual;
import Population.Population;
import Population.FitnessEvaluator;

// TODO: Auto-generated Javadoc
/**
 * The Class EliteSelectionB.
 *
 * @author Janice
 * EliteSelection is a concrete class implementing Selection as part of
 * my Strategy Pattern
 * 
 * To note-- ELiteSelection A and B do the same thing. They are only to demonstrate the 
 * abstract and factory pattern
 * 
 * Elite Selection picks parents based on their fitness Level
 */
public class EliteSelectionB implements Selection{
    
    /** The f. */
    FitnessEvaluator f = new FitnessEvaluator();

        /**
         * Select female parent.
         *
         * @param aPopulation the a population
         * @return the individual
         */
        @Override
        public Individual selectFemaleParent(Population aPopulation){
            Individual eliteFemale = f.findFittestFemale(aPopulation);
            return eliteFemale;
	}
        
        /**
         * Select male parent.
         *
         * @param aPopulation the a population
         * @return the individual
         */
        @Override
        public Individual selectMaleParent(Population aPopulation){
            Individual eliteMale = f.findFittestMale(aPopulation);
            return eliteMale;
	}
}
