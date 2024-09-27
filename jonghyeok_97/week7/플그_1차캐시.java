package jonghyeok_97.week7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 플그_1차캐시 {

    private static final Queue<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        String[] lowerCaseCities = Arrays.stream(cities)
                .map(String::toLowerCase)
                .toArray(String[]::new);

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String city = lowerCaseCities[i];
            if (!isCacheHit(city)) {
                time += 5;
                if (cache.size() < cacheSize) {
                    cache.offer(city);
                } else {
                    cache.poll();
                    cache.offer(city);
                }
                continue;
            }
            cache.remove(city);
            cache.offer(city);
            time++;
        }
        return time;
    }

    public boolean isCacheHit(String value) {
        return cache.contains(value);
    }

}
