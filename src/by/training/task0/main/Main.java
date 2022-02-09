package by.training.task0.main;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.reader.CustomArrayReaderImpl;
import by.training.task0.reader.PropertyReader;
import by.training.task0.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            String dataPath =  PropertyReader.getPropertyValue("property.properties", "data_file_locations");
            CustomArrayReaderImpl arrayReader = new CustomArrayReaderImpl();
            CustomArray arrayFromFile = arrayReader.readFirstValid(dataPath);
            final CustomArray array = ArrayService.sortMerge(arrayFromFile);
            System.out.println("Origin array: " + arrayFromFile);
            System.out.println("Replace with negative: " + ArrayService.replaceNegativeToZero(arrayFromFile));
            System.out.println("Sorted array: " + array);
            System.out.println("Max integer: " + ArrayService.getMax(arrayFromFile).get());
            System.out.println("Min integer: " + ArrayService.getMin(arrayFromFile).get());
            System.out.println("Sum of integers: " + ArrayService.getSum(arrayFromFile).get());
            System.out.println("Amount of negative integers: " + ArrayService.getAmountNegative(arrayFromFile).get());
            System.out.println("Average number:" + ArrayService.getAverage(arrayFromFile).get());
        } catch (IOException | CustomException e) {
            log.error("There were problems during reading and opening file.", e);
        }
    }
}