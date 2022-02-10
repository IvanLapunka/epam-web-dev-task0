package by.training.task0.parser;

/**
 * The data should be validated before parsing.
 * */
public enum CustomParserImpl implements CustomParser{
    INSTANCE;
    @Override
    public int[] parseToIntArray(String[] sNumbers) {
        int[] array = new int[sNumbers.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(sNumbers[i]);
        }
        return array;
    }
}
