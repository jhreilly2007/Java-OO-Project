package GAFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class FactoryProducer.
 *
 * @author Janice
 * The FactoryProducer is used by the Demo/Client/Runner class 
 * It is a factory creator class. It returns an AbstractFactory Object
 * based on the params passed in. Provides factories based on the enum
 * passed in
 */
public class FactoryProducer{
   
   /**
    * Gets the factory.
    *
    * @param factoryType the factory type
    * @return the factory
    */
   public static GAFactory getFactory(FactoryType factoryType){ 
     if (null == factoryType) return null; else switch (factoryType) {
           case A:
               return new FactoryA();
           case B:
               return new FactoryB();
           case AB:
               return new FactoryAB();
           default:
               return null;
       }
    }
}
