package day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CubeGameTest {

    @ParameterizedTest
    @CsvSource(
        delimiter = '|',
        value = {
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green|1",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue|2",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red|0",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red|0",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green|5"
        }
    )
    void feasible_gameId_test(String input, int expect) {
        CubeGame cubeGame = new CubeGame();
        int actual = cubeGame.getPossibleGameId(input);
        Assertions.assertEquals(expect, actual);
    }

    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green|48",
                    "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue|12",
                    "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red|1560",
                    "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red|630",
                    "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green|36"
            }
    )
    void power_of_fewest_cube_for_make_game_test(String input, int expect) {
        CubeGame cubeGame = new CubeGame();
        int actual = cubeGame.getPowerOfCubes(input);
        Assertions.assertEquals(expect, actual);
    }
}
