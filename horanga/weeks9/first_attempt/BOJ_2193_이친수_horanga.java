package horanga.weeks9.first_attempt;

import java.util.Scanner;

public class BOJ_2193_이친수_horanga {

    public static void main(String[] args) {

        int N = new Scanner(System.in).nextInt();

        long[] dp = new long[N + 1]; //n자리 이친 수의 총 개수

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);
    }

    }
