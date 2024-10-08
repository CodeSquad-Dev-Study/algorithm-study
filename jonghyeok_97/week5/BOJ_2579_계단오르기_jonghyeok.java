package jonghyeok_97.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기_jonghyeok {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        // dp[3] = Math.max(dp[1], dp[0]+arr[2]) + arr[3]
        //                 1층,       2층        + 3층
        // dp[4] = 1층, 2층, 4층 과 1층, 3층 4층
        // dp[4] = Math.max(dp[2], dp[1] + arr[3]) + arr[4]
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i-1] , dp[i-2]) + arr[i];
        }
        System.out.println(dp[n]);
    }
}
