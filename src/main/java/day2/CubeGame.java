package day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeGame {

    private static final int RED_LIMIT = 12;
    private static final int GREEN_LIMIT = 13;
    private static final int BLUE_LIMIT = 14;
    private static final List<String> colors = List.of("red", "blue", "green");
    private static final Map<String, Integer> map = new HashMap<>() {{
        put("red", RED_LIMIT);
        put("green", GREEN_LIMIT);
        put("blue", BLUE_LIMIT);
    }};

    public int getFeasibleGameId(String input) {
        String[] split = input.split(":");
        String gameId = split[0].replace("Game ", "");
        String[] games = split[1].trim().split(";");
        int output = Integer.parseInt(gameId);
        for (String game : games) {
            String[] cubes = game.trim().split(",");
            for (String cube : cubes) {
                for (String color : colors) {
                    if (cube.contains(color)) {
                        int numberOfCube = Integer.parseInt(cube.replace(color, "").trim());
                        Integer limit = map.get(color);
                        if (limit < numberOfCube) {
                            return 0;
                        }
                    }
                }
            }
        }
        return output;
    }

    public int getPowerOfCubes(String input) {
        Map<String, Integer> cubeMap = new HashMap<>() {{
            put("red", 1);
            put("green", 1);
            put("blue", 1);
        }};

        String[] split = input.split(":");
        String gameId = split[0].replace("Game ", "");
        String[] games = split[1].trim().split(";");
        for (String game : games) {
            String[] cubes = game.trim().split(",");
            for (String cube : cubes) {
                for (String color : colors) {
                    if (cube.contains(color)) {
                        int numberOfCube = Integer.parseInt(cube.replace(color, "").trim());
                        Integer max = Math.max(cubeMap.get(color), numberOfCube);
                        cubeMap.put(color, max);
                    }
                }
            }
        }
        return cubeMap.get("red") * cubeMap.get("green") * cubeMap.get("blue");
    }
}
