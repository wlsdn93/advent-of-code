package day4;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1Launcher {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        try (var lines = Files.lines(Path.of("src/main/resources/day4/input.txt"))) {
            System.out.println(lines.mapToInt(game::getPowerOfCount).sum());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
