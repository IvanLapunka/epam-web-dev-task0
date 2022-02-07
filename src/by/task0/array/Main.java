package by.task0.array;

import by.task0.array.entity.Array;
import by.task0.array.reader.DataReader;
import by.task0.array.reader.PropertyReader;
import by.task0.array.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            String dataPath =  PropertyReader.getPropertyValue("property.properties", "data_file_locations");
            Array arrayFromFile = DataReader.getArrayFromFile(dataPath);
            final Array array = ArrayService.sortMerge(arrayFromFile);
            System.out.println("Origin array: " + arrayFromFile);
            System.out.println(ArrayService.replaceNegativeToZero(arrayFromFile));
            System.out.println("Sorted array: " + array);
            System.out.println("Max integer: " + ArrayService.getMax(arrayFromFile));
            System.out.println("Min integer: " + ArrayService.getMin(arrayFromFile));
            System.out.println("Sum of integers: " + ArrayService.getSum(arrayFromFile));
            System.out.println("Amount of negative integers: " + ArrayService.getAmountNegative(arrayFromFile));
            System.out.println("Average number:" + ArrayService.getAverage(arrayFromFile));
        } catch (IOException e) {
            log.error("There were problems during reading the file", e);
        }
    }
}