package dnjsxo0616.week9;

import java.util.HashMap;
import java.util.Map;

public class PG_키패드누르기_dnjsxo0616 {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -2}
        };

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(keypad[i][j], new int[]{i, j});
            }
        }

        int[] leftPosition = {3, 0};
        int[] rightPosition = {3, 2};

        StringBuilder answer = new StringBuilder();
        for (int n : numbers) {
            int[] c = map.get(n);
            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                leftPosition = c;
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                rightPosition = c;
            } else {
                int l = Math.abs((leftPosition[0] - c[0])) + Math.abs((leftPosition[1] - c[1]));
                int r = Math.abs((rightPosition[0] - c[0])) + Math.abs((rightPosition[1] - c[1]));
                if (l > r) {
                    answer.append("R");
                    rightPosition = c;
                } else if (l < r) {
                    answer.append("L");
                    leftPosition = c;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        rightPosition = c;
                    } else {
                        answer.append("L");
                        leftPosition = c;
                    }
                }
            }
        }
        return answer.toString();
    }
}
