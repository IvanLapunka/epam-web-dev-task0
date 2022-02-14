package by.training.task0.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    private final Map<Integer, ArrayStatistics> items;

    private Warehouse(){
        items = new HashMap<>();
    }

    public void add(Integer key, ArrayStatistics statistics) {
        items.put(key, statistics);
    }

    public void replace(Integer key, ArrayStatistics statistics) {
         items.replace(key, statistics);
    }
}
