package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_11047_동전_jonghyeok {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = br.readLine();
            String[] NK = input.split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            List<Integer> coins = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                coins.add(Integer.parseInt(br.readLine()));
            }

            coins.sort(Collections.reverseOrder());

            int result = 0;
            for (int i = 0; i < coins.size(); i++) {
                if (K >= coins.get(i)) {
                    result += K / coins.get(i);
                    K = K % coins.get(i);
                }
            }
            System.out.println(result);
        }
    }
}
