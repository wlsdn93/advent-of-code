package day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdvancedCalibratorTest {

    Calibrator calibrator = new Advanced();

    @ParameterizedTest
    @CsvSource({
            "two1nine, 29",
            "eightwothree, 83",
            "abcone2threexyz, 13",
            "xtwone3four, 24",
            "4nineeightseven2, 42",
            "zoneight234, 14",
            "7pqrstsixteen, 76",
            "7eightone, 71",
            "treb7uchet, 77",
            "eightwo, 82",
            "oneight, 18",
            "twone, 21",
            "rtqoneighthxpg5tb4, 14",
            "bvtwone8vninezhkkbvpscqfive6jczrlrgcn, 26",
            "brbeightwo6cxnblxgskmxxxtwo, 82",
            "five67five, 55",
            "sevenineightwo, 72"
    })
    void calibration_test(String input, int expected) {
        int calibratedValue = calibrator.calibrate(input);
        Assertions.assertEquals(expected, calibratedValue);
    }
}
