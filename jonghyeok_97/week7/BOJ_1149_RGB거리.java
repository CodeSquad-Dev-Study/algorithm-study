package jonghyeok_97.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BOJ_1149_RGB거리 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][3];
            for (int i = 0; i < n; i++) {
                int[] s = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < 3; j++) {
                    map[i][j] = s[j];
                }
            }
            int[][] dp = new int[n][3];
//            System.out.println(Arrays.deepToString(map));

            IntStream.rangeClosed(0, 2)
                    .forEach(i -> dp[0][i] = map[0][i]);
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        dp[j][i] += Math.min(dp[j-1][1], dp[j-1][2]) + map[j][i];
                    } else if (i == 1) {
                        dp[j][i] += Math.min(dp[j-1][0], dp[j-1][2])+ map[j][i];
                    } else {
                        dp[j][i] += Math.min(dp[j-1][0], dp[j-1][1])+ map[j][i];
                    }
                }
            }
//            System.out.println(Arrays.deepToString(dp));
            List<Integer> integers = new java.util.ArrayList<>(List.of(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]));
            Collections.sort(integers);
//            System.out.println(integers);

            System.out.println(integers.get(0));
        }
}
