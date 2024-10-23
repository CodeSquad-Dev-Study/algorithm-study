package dnjsxo0616.week11.first_attempt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_모의고사_dnjsxo0616 {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1, 2, 3, 4, 5}; // 5
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int aF = first[i % first.length];
            int aS = second[i % second.length];
            int aT = third[i % third.length];

            if (aF == answer) {
                score.put(1, score.get(1) + 1);
            }
            if (aS == answer) {
                score.put(2, score.get(2) + 1);
            }
            if (aT == answer) {
                score.put(3, score.get(3) + 1);
            }
        }

        int maxScore = Math.max(score.get(1), Math.max(score.get(2), score.get(3)));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (score.get(i) == maxScore) {
                numbers.add(i);
            }
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
