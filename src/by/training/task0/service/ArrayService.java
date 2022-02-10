package by.training.task0.service;

import by.training.task0.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public interface ArrayService {

        Optional<Integer> getMin(CustomArray array) ;

        CustomArray replaceNegativeToZero(CustomArray array);

        Optional<Integer> getMax(CustomArray array);

        Optional<Double> getAverage(CustomArray array);

        Optional<Integer> getSum(CustomArray array) ;

        Optional<Integer> getAmountPositive(CustomArray array);

        Optional<Integer> getAmountNegative(CustomArray array);

        CustomArray sortInsertion(CustomArray array);

        CustomArray sortMerge(CustomArray array);

        CustomArray sortQuick(CustomArray array);
}
