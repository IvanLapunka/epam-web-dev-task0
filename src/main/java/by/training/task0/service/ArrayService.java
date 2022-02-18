package by.training.task0.service;

import by.training.task0.entity.CustomArray;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {

        OptionalInt getMin(CustomArray array) ;

        CustomArray replaceNegativeToZero(CustomArray array);

        OptionalInt getMax(CustomArray array);

        OptionalDouble getAverage(CustomArray array);

        OptionalInt getSum(CustomArray array) ;

        OptionalInt getAmountPositive(CustomArray array);

        OptionalInt getAmountNegative(CustomArray array);

        CustomArray sortInsertion(CustomArray array);

        CustomArray sortMerge(CustomArray array);

        CustomArray sortQuick(CustomArray array);

        CustomArray sortComparator(CustomArray array, Comparator<Integer> comparator);
}
