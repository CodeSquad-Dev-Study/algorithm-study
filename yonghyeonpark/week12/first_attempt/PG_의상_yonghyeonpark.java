package yonghyeonpark.week12.first_attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_의상_yonghyeonpark {

    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];

            map.computeIfAbsent(type, t -> new ArrayList<>()).add(name);
        }

        int answer = 1;
        for (List<String> value : map.values()) {
            answer *= value.size() + 1;
        }
        return answer - 1;
    }
}
