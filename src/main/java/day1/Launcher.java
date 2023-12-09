package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Launcher {

    public static void main(String[] args) {
        Calibrator calibrator = new Advanced();
        try (var lines = Files.lines(Path.of("src/main/resources/day1/input.txt"))) {
            System.out.println(lines.mapToLong(calibrator::calibrate).sum());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
