package jonghyeok_97.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839_설탕배달 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         * 3 -> 1
         * 5 -> 1
         * 6 -> 2
         * 9 -> 3
         * 10 -> 2
         * 12 -> 4
         * 15 -> 3
         */

        int[] dp = new int[n + 5];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            int min = Math.min(dp[i - 3], dp[i - 5]);
            if (min == Integer.MAX_VALUE) {
                continue;
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
