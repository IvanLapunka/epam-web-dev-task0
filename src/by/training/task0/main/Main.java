package by.training.task0.main;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.reader.CustomArrayReaderImpl;
import by.training.task0.reader.PropertyReader;
import by.training.task0.service.ArrayService;
import by.training.task0.service.ArrayServiceImpl;
import by.training.task0.validator.ValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            String dataPath =  PropertyReader.getPropertyValue("property.properties", "data_file_locations");
            CustomArrayReaderImpl arrayReader = new CustomArrayReaderImpl(ValidatorImpl.INSTANCE, " +");
            CustomArray arrayFromFile = arrayReader.readFirstValid(dataPath).orElse(new CustomArray(new int[0]));
            ArrayService arrayService = new ArrayServiceImpl();
            final CustomArray array = arrayService.sortMerge(arrayFromFile);

            System.out.println("Origin array: " + arrayFromFile);
            System.out.println("Replace with negative: " + arrayService.replaceNegativeToZero(arrayFromFile));
            System.out.println("Sorted array: " + array);
            System.out.println("Max integer: " + arrayService.getMax(arrayFromFile).get());
            System.out.println("Min integer: " + arrayService.getMin(arrayFromFile).get());
            System.out.println("Sum of integers: " + arrayService.getSum(arrayFromFile).get());
            System.out.println("Amount of negative integers: " + arrayService.getAmountNegative(arrayFromFile).get());
            System.out.println("Average number:" + arrayService.getAverage(arrayFromFile).get());
        } catch (IOException | CustomException e) {
            log.error("There were problems during reading and opening file.", e);
        }
    }
}