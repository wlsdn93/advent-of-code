package day1;

import java.util.*;

public class Advanced implements Calibrator {

    private static final String[] NUMBER_WORDS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    @Override
    public int calibrate(String input) {
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int num = Character.getNumericValue(input.charAt(i));
                A.add(num);
            } else {
                for (int j = 1; j < 10; j++) {
                    if (input.substring(i).startsWith(NUMBER_WORDS[j])) {
                        A.add(j);
                        break;
                    }
                }
            }
        }
        int size = A.size();
        return A.get(0) * 10 + A.get(size - 1);
    }

}
