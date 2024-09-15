package jonghyeok_97.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수_jonghyeok {

    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            dp = new Integer[n+2][2];

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            Integer[] result = fibonacci(n);

            System.out.println(result[0] + " " + result[1]);
        }
    }

    private static Integer[] fibonacci(int n) {
            if (dp[n][0] == null || dp[n][1] == null) {
                dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
                dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
            }
            return dp[n];
    }
}
