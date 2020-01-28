package Individual;

import java.util.Random;
// TODO: Auto-generated Javadoc

/**
 * The Class Gene.
 *
 * @author Janice Reilly
 * 
 * This class models a Gene
 * Each Genes contains 4 binary digits
 * Gene for Sex Chromosome contains arbitrary 3's 
 * for female and 4's for male
 * Each Gene is converted to a String
 */

public class Gene{
	
	/** The gene. */
	public int [] gene;
    
    /** The code. */
    public String code =""; 
	
	/** The rand. */
	Random rand = new Random(); //create an instance
        
    /**
     * Method to create a gene by Assigned binary values.
     */
		Gene(){
			gene = new int [4];
			for (int i = 0; i < gene.length; i++) {
				gene[i] = Math.abs( rand.nextInt() % 2);
                code+=gene[i];
            } 
		}
		
    /**
     * Method to create a random sex chromosome.
     *
     * @param sex the sex
     */
        Gene(int sex){
            gene = new int [4];//initialise
            for(int i = 0; i<gene.length; i++){
                gene[i] = sex;
                code+=gene[i];
            }
	}
       
    /**
     * To string.
     *
     * @return the string
     */
    @Override
	public String toString(){
            return code;
	}      
}