package Population;
import Individual.Individual;

// TODO: Auto-generated Javadoc
/**
 * The Class Replacer.
 *
 * @author Janice
 * 
 * Replacer class to replace leat fittest in population with a fitter alternative
 */
public class Replacer {
    
   /** The f. */
   FitnessEvaluator f = new FitnessEvaluator();
   
   /**
    * Method to replace least fittest from population with fitter alternative.
    *
    * @param child1 from Reproduction process
    * @param aPopulation the a population
    * @return Population with replaced individual if they are fitter
    */
   public Population tryReplace(Individual child1, Population aPopulation){
   
   Individual leastFittest = f.findLeastFittest(aPopulation);
   int index = aPopulation.getPopulation().indexOf(leastFittest);
   
        if(child1.getFitness()>leastFittest.getFitness()){
          aPopulation.setPopulation(child1, index);
        }
      return aPopulation;
   }
   
  

}
