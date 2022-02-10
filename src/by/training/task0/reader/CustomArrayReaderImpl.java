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

public class CustomArrayReaderImpl implements CustomArrayReader {
    private static Logger log = LogManager.getLogger();

    private Validator validator;
    private String regexDelimiter;

    public CustomArrayReaderImpl(Validator validator, String regexDelimiter) {
        this.validator = validator;
        this.regexDelimiter = regexDelimiter;
    }

    @Override
    public Optional<CustomArray> readFirstValid(String path) throws CustomException {
        List<String> rows = readAllLinesFromFile(path);
        for (String row : rows) {
            if (validateRow(row, regexDelimiter)) {
                CustomParser parser = CustomParserImpl.INSTANCE;
                String[] sNumbers = row.split(regexDelimiter);
                return Optional.of(new CustomArray(parser.parseToIntArray(sNumbers)));
            }
        }
        return Optional.empty();
    }

    private boolean validateRow(String row, String wordRegDelimiter) {
        String[] sNumbers = row.split(wordRegDelimiter);
        for (String word: sNumbers) {
            if (!validator.isInteger(word)) {
                return false;
            }
        }
        return true;
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
