package jonghyeok_97.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053_가장긴증가하는부분수열_jonghyeok {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] collect = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] dp = new int[1001];
        Arrays.fill(dp, 1);
        int count = 1;
        for (int i = 0; i < collect.length; i++) {
            for (int j = 0; j < i; j++) {
                if (collect[i] > collect[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            count = Math.max(count, dp[i]);
        }
        System.out.println(count);
    }
}
