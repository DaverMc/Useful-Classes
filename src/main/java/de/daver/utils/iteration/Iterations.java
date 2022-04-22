package de.daver.utils.iteration;

import de.daver.utils.iteration.array.ArrayIndexIterator;
import de.daver.utils.iteration.array.ArrayValueIterator;

public class Iterations {

    public static <T> void forEach(T[] array, ArrayValueIterator<T> iterator){
        for(T value : array){
            iterator.onValue(value);
        }
    }

    public static void forIndex(int length, ArrayIndexIterator iterator){
        for(int i = 0; i < length; i++){
            iterator.onIndex(i);
        }
    }
}
