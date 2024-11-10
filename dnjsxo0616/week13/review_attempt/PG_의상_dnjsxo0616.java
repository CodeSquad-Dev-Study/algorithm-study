package dnjsxo0616.week13.review_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_의상_dnjsxo0616 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String c = cloth[1];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 1;

        for (int key : map.values()) {
            answer *= (key + 1);
        }

        return answer - 1;
    }
}
