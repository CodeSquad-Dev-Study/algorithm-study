package dnjsxo0616.week5.first_attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_개인정보수집유효기간_dnjsxo0616 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> res = new ArrayList<>();

        String[] t = today.split("\\.");
        int year = Integer.parseInt(t[0]);
        int month = Integer.parseInt(t[1]);
        int day = Integer.parseInt(t[2]);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<terms.length; i++) {
            String[] ts  = terms[i].split(" ");
            String type = ts[0];
            int term = Integer.parseInt(ts[1]);
            map.put(type, term);
        }

        //위에 현재보다 날짜가 더 과거면 파기

        for(int j=0; j<privacies.length; j++) {
            String[] p = privacies[j].split(" ");
            String[] term = p[0].split("\\.");
            int y = Integer.parseInt(term[0]);
            int m = Integer.parseInt(term[1]);
            int d = Integer.parseInt(term[2]);

            int exterm = map.get(p[1]);
            // System.out.println(exterm);
            m += exterm;



            while(m > 12) {
                y++;
                m = m - 12;
            }
            // 계한하나 년도가 today보다 적어야살아 많으면 파기야
            if(year > y) {
                res.add(j+1);
                continue;
            }
            if(year == y && month > m) {
                res.add(j+1);
                continue;
            }
            if(year == y && month == m && day > d ) {
                res.add(j+1);
                continue;
            }
            if(year== y && month == m && day == d) {
                res.add(j+1);
                continue;
            }
        }
        int[] answer = res.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
