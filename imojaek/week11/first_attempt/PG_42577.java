package imojaek.week11.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_42577 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (String number : phone_book) {
            map.put(number, 1);
        }

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i)))
                    return false;
            }
        }

        return true;
    }
}
