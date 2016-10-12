
package library;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagers {
    private static EntityManagerFactory factory;
    
    /*
    veya böylede yapabiliriz
    
    static{
    factory = Persistence.createEntityManagerFactory("Framework05PU");
    }
    
    */
    
    public static EntityManagerFactory getFactory() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("DaFGrouppeV3PU");
        }
        return factory;
    }
    
}
