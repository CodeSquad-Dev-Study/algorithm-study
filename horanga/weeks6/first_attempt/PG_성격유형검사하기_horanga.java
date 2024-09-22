package horanga.weeks6.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_성격유형검사하기_horanga {

    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> maps = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            String[] splits = survey[i].split("");

            int num = choices[i];

            if (num > 4) {
                int point = num - 4;
                maps.put(splits[1], maps.getOrDefault(splits[1], 0) + point);
            } else if (num < 4) {
                int point = 4 - num;
                maps.put(splits[0], maps.getOrDefault(splits[0], 0) + point);
            }
        }

        return getResult(maps);
    }

    private String getResult(Map<String, Integer> maps) {

        String answer = "";
        Integer rSum = maps.get("R");
        Integer tSum = maps.get("T");

        Integer cSum = maps.get("C");
        Integer fSum = maps.get("F");

        Integer jSum = maps.get("J");
        Integer mSum = maps.get("M");

        Integer aSum = maps.get("A");
        Integer nSum = maps.get("N");

        if (rSum == null && tSum == null) {
            answer += "R";
        } else if (rSum == null || tSum != null && rSum < tSum) {
            answer += "T";
        } else {
            answer += "R";
        }

        if (cSum == null && fSum == null) {
            answer += "C";
        } else if (cSum == null || fSum != null && cSum < fSum) {
            answer += "F";
        } else {
            answer += "C";
        }

        if (jSum == null && mSum == null) {
            answer += "J";
        } else if (jSum == null || mSum != null && jSum < mSum) {
            answer += "M";
        } else {
            answer += "J";
        }

        if (aSum == null && nSum == null) {
            answer += "A";
        } else if (aSum == null && aSum < nSum) {
            answer += "N";
        } else {
            answer += "A";
        }

        return answer;

    }
}
