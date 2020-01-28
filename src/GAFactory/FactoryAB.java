package GAFactory;
import Selection.*;
import Reproduction.*;
import Population.*;
import Mutation.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FactoryAB.
 *
 * @author Janice
 * 
 * Factory class that extending AbstractFactory
 * This is used to generate object of concrete class based on given information.
 */

public class FactoryAB extends GAFactory {
	
    /** The p. */
    Population p;
    
    /**
     * Parent 1.
     *
     * @param aPopulation the a population
     * @param s the s
     * @return the selection
     */
    @Override
    protected Selection parent1(Population aPopulation, String s){
        switch (s) {
            case "Elitism":
                return new EliteSelectionA();
            case "Random":
                return new RandomSelectionB();
            default:
                return null;
        }
    }
    
    /**
     * Parent 2.
     *
     * @param aPopulation the a population
     * @param s the s
     * @return the selection
     */
    @Override
    protected Selection parent2(Population aPopulation, String s){
        switch (s) {
            case "Elitism":
                return new EliteSelectionB();
            case "Random":
                return new RandomSelectionA();
            default:
                return null;
        }
    }
    
    /**
     * Form of reproduction.
     *
     * @param aPopulation the a population
     * @param s the s
     * @return the reproduction
     */
    @Override
    protected Reproduction formOfReproduction(Population aPopulation, String s){
        switch (s) {
            case "SinglePoint":
                return new SinglePointCrossoverA();
            case "Uniform":
                return new UniformCrossoverB();
            default:
                return null;
        }
    }
    
    /**
     * Form of mutation.
     *
     * @param aPopulation the a population
     * @param num the num
     * @return the mutation
     */
    @Override
    protected Mutation formOfMutation(Population aPopulation, int num){
        switch (num) {
            case 1:
                return new BitFlipMutation();
            case 2:
                return new SwapMutation();
            default:
                return null;
        }
    }
}
