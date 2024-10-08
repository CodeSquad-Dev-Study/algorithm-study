package week7.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링_seondays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
