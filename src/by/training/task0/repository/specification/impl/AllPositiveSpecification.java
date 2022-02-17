package by.training.task0.repository.specification.impl;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.Specification;

public class AllPositiveSpecification implements Specification {
    @Override
    public boolean specified(CustomArray customArray) {
        for (int i : customArray.getArray()) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
