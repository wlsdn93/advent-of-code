package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Almanac {

    // seed -> soil -> fertilizer -> water -> light -> temperature -> humidity -> location
    private static final String BASE_FILE_PATH = "src/main/resources/day5/input/";
    private static final String SEED = BASE_FILE_PATH + "seed.txt";
    private static final String SEED_TO_SOIL = BASE_FILE_PATH + "seed-to-soil-map.txt";
    private static final String SOIL_TO_FERTILIZER = BASE_FILE_PATH + "soil-to-fertilizer-map.txt";
    private static final String FERTILIZER_TO_WATER = BASE_FILE_PATH + "fertilizer-to-water-map.txt";
    private static final String WATER_TO_LIGHT = BASE_FILE_PATH + "water-to-light-map.txt";
    private static final String LIGHT_TO_TEMPERATURE = BASE_FILE_PATH + "light-to-temperature-map.txt";
    private static final String TEMPERATURE_TO_HUMIDITY = BASE_FILE_PATH + "temperature-to-humidity-map.txt";
    private static final String HUMIDITY_TO_LOCATION = BASE_FILE_PATH + "humidity-to-location-map.txt";

    private static Map<ALMANAC_KEY, List<AlmanacMap>> map = new HashMap<>();
    private static List<Long> seeds;

    public static void main(String[] args) {
        // seed, map 을 등록
        init();

        long min = Long.MAX_VALUE;
        ALMANAC_KEY[] values = ALMANAC_KEY.values();
        for (Long seed : seeds) {
            long source = seed;
            for (ALMANAC_KEY key : values) {
                List<AlmanacMap> almanacMapList = Almanac.map.get(key);
                long destination  = getDestination(almanacMapList, source);
                source = destination;
            }
            min = Math.min(min, source);
        }
        System.out.println(min);
    }

    enum ALMANAC_KEY {
        SEED_TO_SOIL(Almanac.SEED_TO_SOIL),
        SOIL_TO_FERTILIZER(Almanac.SOIL_TO_FERTILIZER),
        FERTILIZER_TO_WATER(Almanac.FERTILIZER_TO_WATER),
        WATER_TO_LIGHT(Almanac.WATER_TO_LIGHT),
        LIGHT_TO_TEMPERATURE(Almanac.LIGHT_TO_TEMPERATURE),
        TEMPERATURE_TO_HUMIDITY(Almanac.TEMPERATURE_TO_HUMIDITY),
        HUMIDITY_TO_LOCATION(Almanac.HUMIDITY_TO_LOCATION);

        final String path;
        ALMANAC_KEY(String path) {
            this.path = path;
        }
        public String getPath() {
            return path;
        }
    }

    static class AlmanacMap {
        Long sourceRange;
        Long destinationRange;
        Long rangeLength;

        public AlmanacMap(Long sourceRange, Long destinationRange, Long range) {
            this.sourceRange = sourceRange;
            this.destinationRange = destinationRange;
            this.rangeLength = range;
        }

        public Long getSourceRange() {
            return sourceRange;
        }

        public Long getDestinationRange() {
            return destinationRange;
        }

        public Long getRangeLength() {
            return rangeLength;
        }
    }

    private static void init() {
        try (var lines = Files.lines(Path.of(SEED))) {
            seeds = Arrays.stream(lines.findFirst().get().split(" "))
                    .mapToLong(Long::parseLong)
                    .boxed()
                    .toList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ALMANAC_KEY[] values = ALMANAC_KEY.values();
        for (ALMANAC_KEY key : values) {
            try (var lines = Files.lines(Path.of(key.getPath()))) {
                List<String> list = lines.toList();
                List<AlmanacMap> almanacMaps = new ArrayList<>();
                for (String line : list) {
                    String[] split = line.split(" ");
                    long destinationRangeStart = Long.parseLong(split[0]);
                    long sourceRangeStart = Long.parseLong(split[1]);
                    long rangeLength = Long.parseLong(split[2]);
                    almanacMaps.add(new AlmanacMap(sourceRangeStart, destinationRangeStart, rangeLength));
                }
                map.put(key, almanacMaps);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static long getDestination(List<AlmanacMap> almanacMaps, Long source) {
        for (AlmanacMap almanacMap : almanacMaps) {
            Long destinationRange = almanacMap.getDestinationRange();
            Long sourceRange = almanacMap.getSourceRange();
            Long range = almanacMap.getRangeLength();
            if (sourceRange <= source && source < sourceRange + range) {
                return destinationRange + (source - sourceRange);
            }
        }
        return source;
    }

}
