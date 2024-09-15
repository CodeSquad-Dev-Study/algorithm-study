package jonghyeok_97.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 플그_개인정보수집유효기간_jonghyeok {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<>();

        Map<String, String> termMap = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            termMap.put(temp[0], temp[1]);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            // 2021.05.02 String타입
            String date = temp[0];

            // A
            String termKey = temp[1];

            // 6
            int term = Integer.parseInt(termMap.get(termKey));
            int year = term / 12;
            int month = term % 12;

            String[] ymd = date.split("\\.");
            int priY = Integer.parseInt(ymd[0]);
            int priM = Integer.parseInt(ymd[1]);
            int priD = Integer.parseInt(ymd[2]);

            priY += year;
            priM += month;

            // System.out.println(priY + " : " + priM + " : " + priD);
            if (priM > 12) {
                priY += priM / 12;
                priM %= 12;
            }

            int[] todayYmd = Arrays.stream(today.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] priYmd = {priY, priM, priD};

            // System.out.println(Arrays.toString(todayYmd));
            System.out.println(Arrays.toString(priYmd));
            if (todayYmd[0] > priYmd[0]) {
                answers.add(i + 1);
                continue;
            }
            if (todayYmd[0] == priYmd[0] && todayYmd[1] > priYmd[1]) {
                answers.add(i + 1);
                continue;
            }
            if (todayYmd[0] == priYmd[0] && todayYmd[1] == priYmd[1] && todayYmd[2] >= priYmd[2]) {
                answers.add(i + 1);
            }

        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

