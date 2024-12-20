package imojaek.week12.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_42578_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer;
    }
}
