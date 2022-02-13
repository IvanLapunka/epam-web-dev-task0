package by.training.task0.MAIN;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.reader.impl.CustomArrayReaderImpl;
import by.training.task0.reader.PropertyReader;
import by.training.task0.reader.impl.PropertyReaderPlainImpl;
import by.training.task0.service.ArrayService;
import by.training.task0.service.ArrayServiceImpl;
import by.training.task0.validator.ValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            PropertyReader propertyReader = new PropertyReaderPlainImpl("property.properties");
            String dataPath =  propertyReader.getPropertyValue("data_file_first_valid_line");
            CustomArrayReaderImpl arrayReader = new CustomArrayReaderImpl();

            checkFirstValidLine(dataPath, arrayReader);

            String dataPath2 = propertyReader.getPropertyValue("data_file_all_valid_lines");
            final List<CustomArray> customArrays = arrayReader.readAllValidRows(dataPath2, ValidatorImpl.INSTANCE)
                    .orElse(List.of());

            customArrays.forEach(System.out::println);
        } catch (CustomException e) {
            log.error("There were problems during reading and opening file.", e);
        }
    }

    private static void checkFirstValidLine(String dataPath, CustomArrayReaderImpl arrayReader) throws CustomException {
        CustomArray arrayFromFile = arrayReader
                .readFirstValid(dataPath, ValidatorImpl.INSTANCE)
                .orElse(new CustomArray(new int[0]));

        ArrayService arrayService = new ArrayServiceImpl();
        final CustomArray array = arrayService.sortMerge(arrayFromFile);

        System.out.println("Origin array: " + arrayFromFile);
        System.out.println("Replace with negative: " + arrayService.replaceNegativeToZero(arrayFromFile));
        System.out.println("Sorted array: " + array);
        System.out.println("Max integer: " + arrayService.getMax(arrayFromFile).getAsInt());
        System.out.println("Min integer: " + arrayService.getMin(arrayFromFile).getAsInt());
        System.out.println("Sum of integers: " + arrayService.getSum(arrayFromFile).getAsInt());
        System.out.println("Amount of negative integers: " + arrayService.getAmountNegative(arrayFromFile).getAsInt());
        System.out.println("Average number:" + arrayService.getAverage(arrayFromFile).getAsDouble());
    }
}