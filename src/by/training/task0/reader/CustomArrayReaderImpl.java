package by.training.task0.reader;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.parser.CustomParser;
import by.training.task0.parser.CustomParserImpl;
import by.training.task0.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomArrayReaderImpl implements CustomArrayReader {
    private static Logger log = LogManager.getLogger();

    @Override
    public Optional<CustomArray> readFirstValid(String filePath, Validator validator) throws CustomException {
        List<String> rows = readAllLinesFromFile(filePath);
        CustomParser parser = CustomParserImpl.INSTANCE;
        for (String row : rows) {
            if (validator.isIntegerNumbersArray(row)) {
                Optional<int[]> intArray = parser.parseToIntArray(row, validator);
                if (intArray.isPresent()) {
                    return Optional.of(new CustomArray(intArray.get()));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<CustomArray>> readAllValidRows(String filePath, Validator validator) throws CustomException {
        List<String> rows = readAllLinesFromFile(filePath);
        CustomParser parser = CustomParserImpl.INSTANCE;
        var result = rows.stream()
                .filter(validator::isIntegerNumbersArray)
                .map(row -> parser.parseToIntArray(row, validator))
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .map(CustomArray::new)
                .collect(Collectors.toList());
        return result.size() > 0 ? Optional.of(result) : Optional.empty();
    }

    private List<String> readAllLinesFromFile(String path) throws CustomException{
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            log.error("File " + path + " was not found", e);
            throw new CustomException(e);
        } catch (IOException e) {
            log.error("There were problems during reading the file  " + path + ".", e);
            throw new CustomException( e);
        }
        return lines;
    }
}
