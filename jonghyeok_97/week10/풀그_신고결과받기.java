package jonghyeok_97.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class 풀그_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = Arrays.stream(report)
                .collect(Collectors.toSet());
        String[] nondu = set.stream()
                .toArray(String[]::new);
        // muzi 에 유저가 신고한ID들,
        // 가장 많이 신고 당한 사람
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new ArrayList<>());
            countMap.put(id_list[i], 0);
        }

        for (int i = 0; i < nondu.length; i++) {
            String[] str = nondu[i].split(" ");
            map.get(str[0]).add(str[1]);
            countMap.put(str[1], countMap.get(str[1]) + 1);
        }

        List<String> names = countMap.keySet().stream()
                .filter(key -> countMap.get(key) >= k)
                .collect(Collectors.toList());

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            List<String> reportedNames = map.get(name);
            int counting = (int) reportedNames.stream()
                    .filter(re -> names.contains(re))
                    .count();
            answer[i] = counting;
        }

        return answer;
    }
}
