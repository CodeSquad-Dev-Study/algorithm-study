package jonghyeok_97.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 플그_땅따먹기 {

    public int solution(int[][] land) {

        int[][] dp = new int[land.length][4];
        dp[0] = land[0];

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + findMaxDpValue(dp, i, j);
            }
        }
        return Arrays.stream(dp[land.length - 1])
                .max()
                .getAsInt();
    }

    private int findMaxDpValue(int[][] dp, int tupleIdx, int idx) {
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == idx) {
                continue;
            }
            max.add(dp[tupleIdx - 1][i]);
        }
        return Collections.max(max);
    }
}
