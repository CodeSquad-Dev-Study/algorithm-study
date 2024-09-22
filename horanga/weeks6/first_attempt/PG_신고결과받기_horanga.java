package horanga.weeks6.first_attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

class PG_신고결과받기_horanga {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> memberMap = new LinkedHashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            List<String> list = new ArrayList<>();
            memberMap.put(name, list);
        }

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            List<String> list = memberMap.get(split[0]);

            if (list.contains(split[1])) {
                continue;
            }

            list.add(split[1]);
            memberMap.put(split[0], list);
            countMap.put(split[1], countMap.getOrDefault(split[1], 0) + 1);
        }

        List<String> memberToBan = new ArrayList<>();

        for (String name : countMap.keySet()) {

            if (countMap.get(name) >= k) {
                memberToBan.add(name);
            }
        }

        int index = 0;
        int[] answer = new int[id_list.length];


        for (String name : memberMap.keySet()) {
            List<String> list = memberMap.get(name);

            for (int i = 0; i < memberToBan.size(); i++) {

                String n = memberToBan.get(i);
                if (countMap.get(n) >= k) {

                    if (!name.equals(n) && list.contains(n)) {
                        answer[index]++;
                    }
                }
            }
            index++;
        }
        return answer;

    }


    public void another_solution(){

    }
}