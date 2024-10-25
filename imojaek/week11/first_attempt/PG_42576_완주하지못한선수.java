package imojaek.week11.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_42576_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String complete : completion) {
            map.put(complete, map.getOrDefault(complete, 0) + 1);
        }

        for (String man : participant) {
            if (!map.containsKey(man))
                return man;
            else if (map.get(man) == 0)
                return man;
            else
                map.put(man, map.get(man) - 1);
        }
        return answer;
    }
}
