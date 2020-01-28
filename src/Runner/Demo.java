package Runner;
import GAFactory.*;
import static GAFactory.FactoryType.*;
import Population.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Demo.
 *
 * @author Janice
 * Demo is my Client Runner class. This is where the Algorithm is called to run
 * Demo takes an instance of the Population.
 * 
 * Demo uses the FactoryProducer class to get an Abstract Factory (GAFactory) Object,
 * and uses it to get factories of concrete classes by passing information such as type etc. 
 * 
 *  The run method runs the whole Genetic Algorithm with the select strategy pattern in place.
 */
public class Demo{
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]){
        Demo demo = new Demo();
        
        Population p1 = Population.getReference();       
        GAFactory GA1 = FactoryProducer.getFactory(A);
        GA1.makeSelections( "Elitism", "Random", p1, "SinglePoint", 1);
        System.out.println("GA using" +GA1.getParentOne()+" "+GA1.getParentTwo()+" "+GA1.getReproducer()+" "+GA1.getMutation());
        demo.run(GA1);
        
        Population p2 = Population.getReference();
        GAFactory GA2 = FactoryProducer.getFactory(B);
        GA2.makeSelections( "Elitism", "Elitism", p2, "SinglePoint", 2);      
        System.out.println("GA using" +GA2.getParentOne()+" "+GA2.getParentTwo()+" "+GA2.getReproducer()+" "+GA2.getMutation());
        demo.run(GA2); 
        
        Population p3 = Population.getReference();
        GAFactory GA3 = FactoryProducer.getFactory(AB);
        GA3.makeSelections( "Random", "Random", p3, "SinglePoint", 1);      
        System.out.println("GA using" +GA3.getParentOne()+" "+GA3.getParentTwo()+" "+GA3.getReproducer()+" "+GA3.getMutation());
        demo.run(GA3); 
	}
    
  /**
   * This method runs the Genetic ALgorithm.
   *
   * @param factory the factory
   */  	
    public void run(GAFactory factory){
                GAControl controller = new GAControl();
                controller.setParent1Selection(factory.getParentOne());
                controller.setParent2Selection(factory.getParentTwo());
                controller.setReproduction(factory.getReproducer());
                controller.setMutation(factory.getMutation());
                controller.start();
	}
	
}
