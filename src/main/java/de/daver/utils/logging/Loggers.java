package de.daver.utils.logging;

import java.io.PrintStream;

public class Loggers {

    private Loggers(){}

    private static boolean ACTIVE = false;

    private static PrintStream getErrorStream(){
        if(!ACTIVE) return System.err;
        return null; //Mein Error-Stream
    }

    public static void error(Exception e){
        e.printStackTrace(getErrorStream());
    }

    public static void setActive(boolean active){
        ACTIVE = active;
    }

}
