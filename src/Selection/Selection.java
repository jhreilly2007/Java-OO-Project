package Selection;
import Individual.Individual;
import Population.Population;

// TODO: Auto-generated Javadoc
/**
 * The Interface Selection.
 *
 * @author Janice
 * Strategy Interface to define my Strategy Pattern action
 */
public interface Selection{
     
     /**
      * Abstract method to select a Female Parent.
      *
      * @param aPopulation the a population
      * @return a Female Individual
      */
    abstract Individual selectFemaleParent(Population aPopulation);
    
    /**
     * Abstract method to select a Male Parent.
     *
     * @param aPopulation the a population
     * @return a Male Individual
     */
    abstract Individual selectMaleParent(Population aPopulation);

}
