package dnjsxo0616.week7.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i/3], dp[i - 1]), dp[i/2]) + 1 ;
            } else if (i%3 ==0) {
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            } else if (i%2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}
