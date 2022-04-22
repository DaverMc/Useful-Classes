package de.daver.utils.collections;

import java.util.HashMap;
import java.util.Map;

public class PathedMap<T> {

    private final Map<String, PathedMap<T>> map;
    private T value;

    public PathedMap(){
        map = new HashMap<>();
        value = null;
    }

    public void put(String path, T value){
        String[] splitted = path.split("\\.");
        PathedMap<T> tempMap;
        for(String part : splitted){
            tempMap = map.get(part);
            if(tempMap == null) return;
        }
    }
}
