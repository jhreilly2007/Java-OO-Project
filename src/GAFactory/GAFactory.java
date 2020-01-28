package GAFactory;
import Selection.*;
import Reproduction.*;
import Mutation.*;
import Population.*;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating GA objects.
 *
 * @author Janice
 * 
 * This is my Abstract Factory. Super -factory which creates other factories.
 * GAFactory interface is responsible for creating a factory of related objects
 * without explicitly specifying their classes. Each generated factory can then
 * give the objects as per the Factory pattern.
 */
public abstract class GAFactory{
    
    /** The parent one. */
    //Here I am declaring the selector and the reproducer etc to be of type interface
    Selection parentOne; 
    
    /** The parent two. */
    Selection parentTwo; 
    
    /** The reproducer. */
    Reproduction reproducer; 
    
    /** The mutator. */
    Mutation mutator;   
    
    /**
     * Make selections.
     *
     * @param parent1 String Selection Strategy type
     * @param parent2 String Selection Strategy type
     * @param aPopulation the a population
     * @param reproType String Reproduction Strategy type
     * @param mutationType int 1 or 2 to determine Mutation STrategy
     * @return the object
     */
    public Object makeSelections(String parent1, String parent2, Population aPopulation, String reproType, int mutationType){
        parentOne = parent1(aPopulation, parent1);
        parentTwo = parent2(aPopulation, parent2);
        reproducer = formOfReproduction(aPopulation, reproType);
        mutator = formOfMutation(aPopulation, mutationType);
        return null;
    }
    
    /**
     * getter to return Selection Object.
     *
     * @return Selection Object for Parent 1
     */
    public Selection getParentOne() {
        return parentOne;
    }
     
     /**
      * getter to return Selection Object.
      *
      * @return Selection Object for Parent 2
      */
    public Selection getParentTwo() {
        return parentTwo;
    }
    
    /**
     * getter to return Reproduction Object.
     *
     * @return Reproduction Object
     */
    public Reproduction getReproducer() {
        return reproducer;
    }
    
    /**
     * getter to return Mutation Object.
     *
     * @return Mutation Object
     */
    public Mutation getMutation() {
        return mutator;
    }
    

    /**
     * get Methods to get Factories
     * Provides Abstract Methods to be implemented in the subclasses.
     *
     * @param aPopulation Population
     * @param s String
     * @return Selection Object
     */
    protected abstract Selection parent1(Population aPopulation, String s);
     
     /**
      * Parent 2.
      *
      * @param aPopulation Population
      * @param s String
      * @return Selection Object
      */
    protected abstract Selection parent2(Population aPopulation, String s);
     
     /**
      * Form of reproduction.
      *
      * @param aPopulation Population
      * @param reproType String
      * @return Reproduction Object
      */  
    protected abstract Reproduction formOfReproduction(Population aPopulation, String reproType);
     
     /**
      * Form of mutation.
      *
      * @param aPopulation Population
      * @param num int
      * @return Mutation Object
      */
    protected abstract Mutation formOfMutation(Population aPopulation, int num);
}
