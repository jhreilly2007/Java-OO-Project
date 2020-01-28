package Individual;

// TODO: Auto-generated Javadoc
/**
 * The Class Chromosome.
 *
 * @author Janice Reilly
 * 
 * This class models a Chromosome
 * It "contains" Genes. It uses an array to
 * model the fact that a chromosome contains "many" genes
 */

public class Chromosome{
	
	/** The genes. */
	public Gene[]genes = new Gene[4];//hold an array of Genes
        
   /**
    * Method to generate a Chromosome.
    */
		public Chromosome(){
            for (int i= 0; i<genes.length; i++){
            	genes [i] = new Gene();//this should work now
            }
		}
     
    /**
     * Method to generate a sex chromosom.
     *
     * @param c Chromosome
     */
        public Chromosome(int c){
            for (int i= 0; i<genes.length; i++){
            	genes [i] = new Gene(c);//this should work now
            } 
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
		public String toString(){
            StringBuilder chromosomeAsString = new StringBuilder();
            for (Gene g: genes){
            	chromosomeAsString.append(g.toString());
                }
            return chromosomeAsString.toString();
        }
}