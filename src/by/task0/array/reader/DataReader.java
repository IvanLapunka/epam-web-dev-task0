package by.task0.array.reader;

import by.task0.array.entity.Array;
import by.task0.array.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    private static Logger log = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        String dataPath = PropertyReader.getPropertyValue("property.properties", "data_file_locations");
        final Array arrayFromFile = getArrayFromFile(dataPath);
        System.out.println(arrayFromFile);
    }

    public static Array getArrayFromFile(String path) throws IOException {
        int[] numbers = null;
        try(final BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String delimiter = "[ ]+";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] sNumbers = line.split(delimiter);
                numbers = new int[sNumbers.length];
                int i = 0;
                for (i = 0; i < sNumbers.length; i++) {
                    if (!Validation.isInteger(sNumbers[i])){
                        log.info(" line " + i + " string: " + sNumbers[i]);
                        numbers = null;
                        break;
                    }
                    numbers[i] = Integer.parseInt(sNumbers[i]);
                }
            }
        }
        if (numbers == null) {
            log.error("The data in file is not valide");
            return new Array(0);
        }
        return new Array(numbers);
    }
}
