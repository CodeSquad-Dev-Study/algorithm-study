package dnjsxo0616.week9.first_attempt;

import java.util.*;

public class PG_신고결과받기_dnjsxo0616 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            Map<String, List<String>> reportId = new LinkedHashMap<>();
            Map<String, Integer> res = new LinkedHashMap<>();
            for(String id : id_list) {
                reportId.put(id, new ArrayList<>());
                res.put(id, 0);
            }

            Map<String, Integer> reportCount = new HashMap<>();

            // 두 번 이상 신고한거면 1회처리
            Set<String> set = new HashSet<>(Arrays.asList(report));

            for(String r : set) {
                String[] re = r.split(" ");
                reportId.get(re[0]).add(re[1]);
                reportCount.put(re[1], reportCount.getOrDefault(re[1], 0) + 1);
            }

            reportCount.forEach((key, value) -> {
                if(value >= k) {
                    reportId.forEach((r, names) -> {
                        if (names.contains(key)) {
                            res.put(r, res.getOrDefault(r, 0) + 1);
                        }
                    });
                }
            });


            int[] answer = new int[res.size()];
            int i = 0;
            for(int value : res.values()) {
                answer[i] = value;
                i++;
            }

            return answer;
        }
    }
}
