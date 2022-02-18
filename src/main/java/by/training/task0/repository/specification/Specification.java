package by.training.task0.repository.specification;

import by.training.task0.entity.CustomArray;

@FunctionalInterface
public interface Specification {
    boolean specified(CustomArray customArray);
}
