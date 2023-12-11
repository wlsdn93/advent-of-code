package day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EngineTest {

    @Test
    void sum_adjacent_symbol() {
        String input =
            """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
            """;

        String[] split = input.split("\n");
        String[][] B = new String[split.length][split[0].length()];
        int i = 0;
        for (String s : split) {
            String[] letters = s.trim().split("");
            B[i] = letters;
            i++;
        }

        for (String[] b : B) {
            System.out.println(Arrays.toString(b));
        }
    }

}
