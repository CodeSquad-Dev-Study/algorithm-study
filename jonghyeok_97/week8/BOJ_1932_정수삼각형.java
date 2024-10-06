package jonghyeok_97.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_1932_정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 5

        int[][] map = new int[n][n]; // 0~4 가능
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 0;
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] s = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < s.length; j++) {
                map[i][j] = s[j];
            }
        }

        if (n == 1) {
            System.out.println(map[0][0]);
            return;
        }

        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) { // n = 5 일때, j 는 0, 1, 2, 3
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + map[i][j];
                } else {
                    dp[i][j] = map[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int[] array = Arrays.stream(dp[n - 1])
                .sorted()
                .toArray();
        System.out.println(array[array.length - 1]);
    }
}
