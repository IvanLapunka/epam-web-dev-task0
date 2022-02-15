package by.training.task0.repository;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface CustomArrayRepository {
    void addCustomArray(CustomArray customArray);
    void addAllCustomArray(List<CustomArray> customArrayList);
    void removeCustomArray(CustomArray customArray);
    List<CustomArray> query(Predicate<CustomArray> predicate);
    List<CustomArray> query(Specification specification);
    List<CustomArray> queryAll();
    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
