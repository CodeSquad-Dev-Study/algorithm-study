package dnjsxo0616.week10.first_attempt;

import java.util.HashMap;

public class PG_완주하지못한선수_dnjsxo0616 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        for (String name : participant) {
            hash.put(name, hash.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            hash.put(name, hash.get(name) - 1);
        }

        for (String key : hash.keySet()) {
            if (hash.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
