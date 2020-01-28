package Runner;

import Mutation.*;
import Reproduction.*;
import Selection.*;
import Individual.Individual;
import Population.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GAControl.
 *
 * @author Janice Reilly
 * 
 * Applying the Strategy pattern to the Genetic Algorithm
 * This the 'Context' Class
 * from which my strategy pattern will be implemented
 */

public class GAControl{
	
	/** Here I am declaring the selector and the reproducer to be of type interface. */
		Selection parent1Selector; 
		
		/** The parent 2 selector. */
		Selection parent2Selector; 
		
		/** The reproducer. */
		Reproduction reproducer; 
        
        /** The mutator. */
        Mutation mutator;
        
        /** The replacer. */
        Replacer replacer = new Replacer();
        
        /** The f. */
        FitnessEvaluator f = new FitnessEvaluator();
        
        /**
         * This Method will be used to start the genetic algorithm
         * and apply the Strategy Pattern.
         */
	public void start(){
		Population population = Population.getReference();
		int generations = 0;//generation counter
		double mutationRate=0.1;//low probability 
                int totalFitness = f.evaluate(population);
               
                /**
                 * Genetic Algorithm 
                 * 1. Takes in a Male Parent & a Female Parent based on specific selection criteria
                 * 2. Uses these parents to reproduce a new individual
                 * 3. Mutation is added based on mutation rate
                 * 4. if the new child is fitter that the least fittest in the population replace them in population
                 * 5.Termination Criteria: top after 10 generations
                 */
                while(generations < 10){
                    
			Individual parent1 = parent1Selector.selectFemaleParent(population);
			Individual parent2 = parent2Selector.selectMaleParent(population);
			Individual child1 = reproducer.crossover(parent1, parent2);
                        mutator.mutate(child1, mutationRate);//this is a low probability operation
			
			replacer.tryReplace(child1, population);
                        totalFitness = f.evaluate(population);
                        System.out.println("Generation "+(generations+1)+" : Fitness Lever : "+totalFitness);
                        
                        generations++;//counts number of Generations
               
		}
	}
	
	/**
	 * Methods that allow any implementor of the Selection interface 
	 * to be passed in, or, any implementor of the Reproduction interface 
	 * and then set the selector, or reproducer to to an object of that
	 * type passed in ...
	 * The type defined is an interface - but through polymorphosm, any, 
	 * concrete implementing class will be accepted
	 *
	 * @param aSelectionStrategy the new parent 1 selection
	 */
        public void setParent1Selection(Selection aSelectionStrategy){
		parent1Selector = aSelectionStrategy;
	}
        
        /**
         * Sets the parent 2 selection.
         *
         * @param aSelectionStrategy the new parent 2 selection
         */
        public void setParent2Selection(Selection aSelectionStrategy){
		parent2Selector = aSelectionStrategy;
	}
        
        /**
         * Sets the reproduction.
         *
         * @param aReproductionStrategy the new reproduction
         */
	public void setReproduction(Reproduction aReproductionStrategy){
		reproducer = aReproductionStrategy;
	}
        
        /**
         * Sets the mutation.
         *
         * @param aMutationStrategy the new mutation
         */
        public void setMutation(Mutation aMutationStrategy){
		mutator = aMutationStrategy;
	}

}
