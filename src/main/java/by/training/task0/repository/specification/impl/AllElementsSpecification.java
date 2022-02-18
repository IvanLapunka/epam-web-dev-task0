package by.training.task0.repository.specification.impl;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.Specification;

public class AllElementsSpecification implements Specification {
    @Override
    public boolean specified(CustomArray customArray) {
        return true;
    }
}
