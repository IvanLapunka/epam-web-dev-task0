package by.training.task0.service;

import by.training.task0.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;

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
}
