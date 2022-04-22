package de.daver.utils.lang;

import de.daver.utils.iteration.Iterations;

public class StringHandler {

    private String string;

    public StringHandler(String string){
        this.string = string;
    }

    public String toString(){
        return this.string;
    }

    //Schneidet von hinten Zeichen ab
    public StringHandler trimBackwards(int steps){
        string = string.substring(0, string.length() - steps);
        return this;
    }

    //Packt den value hinter die Stelle an der der regex gefunden wurde
    public StringHandler putAfter(String regex, String value){
        return this;
    }

    public StringHandler append(String value){
        this.string = this.string + value;
        return this;
    }

    public StringHandler append(String separator, String...values){
        Iterations.forEach(values, s -> append(s).append(separator));
        return trimBackwards(separator.length());
    }

}
