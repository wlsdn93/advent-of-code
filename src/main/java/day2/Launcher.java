package day2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Launcher {
    public static void main(String[] args) {
        CubeGame game = new CubeGame();
        try (var lines = Files.lines(Path.of("src/main/resources/day2/input.txt"))) {
            System.out.println(lines.mapToInt(game::getPowerOfCubes).sum());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
