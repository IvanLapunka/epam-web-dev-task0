package by.training.task0.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public ArrayStatistics get(Integer key) {
        return items.get(key);
    }

    public List<ArrayStatistics> getAll() {
        return new ArrayList<>(items.values());
    }
}
