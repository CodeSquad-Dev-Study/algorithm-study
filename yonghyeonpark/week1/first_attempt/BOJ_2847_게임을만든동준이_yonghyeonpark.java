package yonghyeonpark.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2847_게임을만든동준이_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalStages = Integer.parseInt(br.readLine());
        int[] scores = new int[totalStages];
        for (int i = 0; i < totalStages; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = totalStages - 1; i > 0; i--) {
            if (scores[i] <= scores[i - 1]) {
                count += scores[i - 1] - scores[i] + 1;
                scores[i - 1] = scores[i] - 1;
            }
        }

        System.out.println(count);
    }
}
