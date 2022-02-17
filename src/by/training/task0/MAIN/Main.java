package by.training.task0.MAIN;

import by.training.task0.configurator.CustomArrayConfigurator;
import by.training.task0.entity.CustomArray;
import by.training.task0.entity.Warehouse;
import by.training.task0.exception.CustomException;
import by.training.task0.reader.impl.CustomArrayReaderImpl;
import by.training.task0.reader.PropertyReader;
import by.training.task0.reader.impl.PropertyReaderPlainImpl;
import by.training.task0.repository.CustomArrayRepository;
import by.training.task0.repository.CustomArrayRepositoryImpl;
import by.training.task0.repository.specification.impl.AllPositiveSpecification;
import by.training.task0.repository.specification.impl.SumIsPositiveSpecification;
import by.training.task0.service.ArrayService;
import by.training.task0.service.ArrayServiceImpl;
import by.training.task0.validator.ValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;

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

            task0Part2(customArrays);

        } catch (CustomException e) {
            log.error("There were problems during reading and opening file.", e);
        }
    }

    private static void task0Part2(List<CustomArray> customArrays) {
        CustomArrayRepository customArrayRepository = CustomArrayRepositoryImpl.getInstance();
        customArrayRepository.addAllCustomArray(customArrays);

        System.out.println("Sum is positive arrays:");
        final List<CustomArray> sumPositive = customArrayRepository.query(new SumIsPositiveSpecification());
        sumPositive.forEach(System.out::println);

        System.out.println("All elements are positive:");
        final List<CustomArray> allPositive = customArrayRepository.query(new AllPositiveSpecification());
        allPositive.forEach(System.out::println);

        System.out.println("Average is more then 1.0:");
        Predicate<CustomArray> averageIsMoreThenOne = array -> {
            double sum = 0;
            for (int element: array.getArray()) {
                sum += element;
            }
            return sum / array.getArray().length > 1.0;
        };
        final List<CustomArray> query2 = customArrayRepository.query(averageIsMoreThenOne); // какой метод вызовется
        query2.forEach(System.out::println);

        CustomArrayConfigurator configurator = new CustomArrayConfigurator();
        configurator.fillWarehouse();

        System.out.println("Before changing elements");
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.getAll().forEach(System.out::println);

        final List<CustomArray> allArrays = customArrayRepository.queryAll();
        allArrays.forEach(array -> array.set(0, -1000));
        customArrayRepository.queryAll();
        System.out.println("After changing elements and processing Observer");
        warehouse.getAll().forEach(System.out::println);

        final ArrayServiceImpl arrayService = new ArrayServiceImpl();

        System.out.println("Sort array in reverse order");
        final CustomArray customArray = arrayService.sortComparator(customArrayRepository.queryAll().get(0), (a, b) -> b - a);
        System.out.println(customArray);

        System.out.println("BEFORE sort arrays by their length");
        customArrayRepository.queryAll().forEach(System.out::println);

        System.out.println("AFTER sort arrays by their length");
        customArrayRepository.sort((c1, c2) -> c1.size() - c2.size()).forEach(System.out::println);

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