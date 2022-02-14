package by.training.task0.repository;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.Specification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomArrayRepositoryImpl implements CustomArrayRepository{

    private final static CustomArrayRepositoryImpl INSTANCE = new CustomArrayRepositoryImpl();
    Map<Integer, CustomArray> items = new HashMap<>();

    private CustomArrayRepositoryImpl() {}

    public static CustomArrayRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addCustomArray(CustomArray customArray) {
        items.putIfAbsent(customArray.getId(), customArray);
    }

    @Override
    public void addAllCustomArray(List<CustomArray> customArrayList) {
        final Iterator<CustomArray> iterator = customArrayList.iterator();
        while (iterator.hasNext()) {
            CustomArray customArray = iterator.next();
            items.putIfAbsent(customArray.getId(), customArray);
        }
    }

    @Override
    public void removeCustomArray(CustomArray customArray) {
        items.remove(customArray.getId());
    }

    @Override
    public List<CustomArray> query(Predicate<CustomArray> predicate) {
        return items.entrySet().stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        return items.entrySet().stream()
                    .filter(entry -> specification.specified(entry.getValue()))
                    .map(entry -> entry.getValue())
                    .collect(Collectors.toList());
    }
}