package by.training.task0.repository.specification.impl;

import by.training.task0.entity.CustomArray;
import by.training.task0.repository.specification.Specification;

public class SumIsPositiveSpecification implements Specification {
    @Override
    public boolean specified(CustomArray customArray) {
        int sum = 0;
        for (int i : customArray.getArray()) {
            sum += i;
        }
        return sum > 0;
    }
}
