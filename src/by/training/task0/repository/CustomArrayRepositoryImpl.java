package by.training.task0.repository;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.impl.AllElementsSpecification;
import by.training.task0.repository.specification.Specification;

import java.util.Comparator;
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
        return items.values().stream()
                .filter(predicate::test)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomArray> query(Specification specification) {
        return items.values().stream()
                    .filter(specification::specified)
                    .collect(Collectors.toList());
    }

    @Override
    public List<CustomArray> queryAll() {
        return items.values().stream()
                .filter(value -> new AllElementsSpecification().specified(value))
                .collect(Collectors.toList());
    }

    ///Где хранить компараторы?
    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        return items.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
