package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Part2Launcher {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        try (var lines = Files.lines(Path.of("src/main/resources/day4/input.txt"))) {
            int[] cards = new int[10001];
            Arrays.fill(cards, 1);
            List<String> list = lines.toList();
            int index = 1;
            for (String line : list) {
                int copy = cards[index];
//                System.out.printf("Card %d 팩 갯수 %d%n", index, copy);
                int scratch = game.countMatchedNumber(line);
//                System.out.printf("%d 부터 %d 까지 카드팩 개수를 %d 개씩 늘린다.%n", index + 1, index + scratch - 1, copy);
                for (int i = index + 1; i < index + scratch; i++) {
                    cards[i] += copy;
                }
                index++;
            }
            int[] scratches = Arrays.copyOfRange(cards, 1, index);
//            System.out.println(Arrays.toString(scratches));
            int sum = 0;
            for (int n : scratches) {
                sum += n;
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
