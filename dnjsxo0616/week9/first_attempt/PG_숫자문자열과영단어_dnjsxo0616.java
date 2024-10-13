package dnjsxo0616.week9.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_숫자문자열과영단어_dnjsxo0616 {
        public int solution(String s) {
            Map<String, String> map = new HashMap<>();
            map.put("zero", "0");
            map.put("one", "1");
            map.put("two", "2");
            map.put("three", "3");
            map.put("four", "4");
            map.put("five", "5");
            map.put("six", "6");
            map.put("seven", "7");
            map.put("eight", "8");
            map.put("nine", "9");

            String str = s;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str = str.replaceAll(entry.getKey(), entry.getValue());
            }

            int answer = Integer.parseInt(str);
            return answer;
        }
}
