package day1;

public class Prototype implements Calibrator {
    @Override
    public int calibrate(String input) {
        int length = input.length();
        int leftPointer = 0;
        int rightPointer = length - 1;
        Character firstDigit = null, lastDigit = null;
        char[] charArray = input.toCharArray();

        while (firstDigit == null || lastDigit == null) {
            if (firstDigit == null) {
                if (Character.isDigit(charArray[leftPointer])) {
                    firstDigit = charArray[leftPointer];
                }
                leftPointer++;
            }

            if (lastDigit == null) {
                if (Character.isDigit(charArray[rightPointer])) {
                    lastDigit = charArray[rightPointer];
                }
                rightPointer--;
            }
        }

        String calibratedValue = "%c%c".formatted(firstDigit, lastDigit);
        return Integer.parseInt(calibratedValue);
    }
}
