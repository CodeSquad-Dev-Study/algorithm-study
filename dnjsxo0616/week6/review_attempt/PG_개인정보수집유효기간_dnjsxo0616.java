package dnjsxo0616.week6.review_attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_개인정보수집유효기간_dnjsxo0616 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int date = getDate(today);

        for(String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        for(int i=0; i<privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            if(getDate(p[0]) + (map.get(p[1]) * 28) <= date) {
                ans.add(i+1);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int getDate(String today) {
        String[] pr = today.split("\\.");
        int year = Integer.parseInt(pr[0]);
        int month = Integer.parseInt(pr[1]);
        int day = Integer.parseInt(pr[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
