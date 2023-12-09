package day1;

import java.util.*;

public class Advanced implements Calibrator {

    private static final Map<String, String> NUMBER_WORD_MAP = new HashMap<>() {{
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};
    private static final Set<String> keySet = NUMBER_WORD_MAP.keySet();

    @Override
    public int calibrate(String input) {
        int firstNumber = findFirstNumber(input) * 10;
        int lastNumber = findLastNumber(input);
        System.out.printf("output: %d, input: %s%n", firstNumber + lastNumber, input);
        return firstNumber + lastNumber;
    }

    private static int findFirstNumber(String input) {
        int[] candidate = new int[5];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) return Character.getNumericValue(c);
            String substring = input.substring(i, Math.min(input.length(), i + 5));
            for (String key : keySet) {
                if (substring.contains(key)) {
                    int index = substring.indexOf(key);
                    candidate[index] = Integer.parseInt(NUMBER_WORD_MAP.get(key));
                }
            }
            for (int j = 0; j < candidate.length; j++) {
                if (candidate[j] != 0) return candidate[j];
            }
        }
        return -1; // No number found
    }

    private static int findLastNumber(String input) {
        int[] candidate = new int[5];
        for (int i = input.length(); i >= 0; i--) {
            char c = input.charAt(i - 1);
            if (Character.isDigit(c)) return Character.getNumericValue(c);
            String substring = input.substring(Math.max(0, i - 5), i);
            for (String key : keySet) {
                if (substring.contains(key)) {
                    int index = substring.indexOf(key);
                    candidate[index] = Integer.parseInt(NUMBER_WORD_MAP.get(key));
                }
            }
            for (int j = candidate.length - 1; j >= 0; j--) {
                if (candidate[j] != 0) return candidate[j];
            }
        }
        return -1; // No number found
    }
}
