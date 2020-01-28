/**
 * @author Janice Reilly
 * 
 * Strategy Interface to define my Strategy Pattern for Reproduction
 * 
*/
package Reproduction;
import Individual.Individual;

// TODO: Auto-generated Javadoc
/**
 * The Interface Reproduction.
 */
public interface Reproduction{
    
    /**
     * Abstract method to crossover/reproduce to create a new Individual.
     *
     * @param parent1 the parent 1
     * @param parent2 the parent 2
     * @return Individual
     */
    abstract Individual crossover (Individual parent1, Individual parent2);
}