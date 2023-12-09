package day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrototypeCalibratorTest {

    Calibrator calibrator = new Prototype();

    @ParameterizedTest
    @CsvSource({
        "1abc2, 12",
        "pqr3stu8vwx, 38",
        "a1b2c3d4e5f, 15",
        "treb7uchet, 77",
    })
    void calibration_test(String input, int expected) {
        int calibratedValue = calibrator.calibrate(input);
        Assertions.assertEquals(expected, calibratedValue);
    }

}
