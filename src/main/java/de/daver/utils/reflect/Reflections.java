package de.daver.utils.reflect;

import de.daver.utils.logging.Loggers;

public class Reflections {

    public static boolean loadClass(String name){
        try{
            Class.forName(name);
        }catch (ClassNotFoundException e) {
            Loggers.error(e);
            return false;
        }
        return true;
    }
}
