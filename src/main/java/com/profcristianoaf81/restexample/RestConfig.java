package com.profcristianoaf81.restexample;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author cristianoaf81
 */
@ApplicationPath("/")
public class RestConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.addAll(super.getClasses());
        return set;
    }
    
    

}
