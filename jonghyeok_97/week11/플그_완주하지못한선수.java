package jonghyeok_97.week11;

import java.util.HashMap;
import java.util.Map;

public class 플그_완주하지못한선수 {


    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        // System.out.println(map);
        for (String c : completion) {
            int count = map.get(c);
            map.put(c, --count);
        }
        return map.keySet().stream()
                .filter(key -> map.get(key) > 0)
                .findAny().get();
    }

}
