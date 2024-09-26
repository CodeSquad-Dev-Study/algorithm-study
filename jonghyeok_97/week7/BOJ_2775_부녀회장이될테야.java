package jonghyeok_97.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775_부녀회장이될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int k = Integer.parseInt(br.readLine()); // 1층
            int n = Integer.parseInt(br.readLine()); // 3호

            n -= 1; // 인덱스
            // 0층의 i호는 i명이 산다.
            // 1층 3호에 살려면 0층 3호까지의 수를 합함 -> 1+2+3
            // 0층 : 1, 2,       3(0, 2), 4
            // 1층 : 1, 3(1, 1), 6(1, 2), 10
            // 2층 : 1, 4, 10, 20
            // 답은 k, n 에 대해 dp[k-1][n] + dp[k][n-1]
            // 만약, n == 0 이면 답은 1, k == 0 이면 답은 n+1

            int[][] dp = new int[16][16];
            for (int i = 0; i < 15; i++) {
                dp[0][i] = i+1;
            }
            for (int i = 0; i < 15; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < 15; i++) {
                for (int j = 1; j < 15; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            if (n == 0) {
                System.out.println(1);
                continue;
            }
            System.out.println(dp[k][n]);
        }

    }
}
