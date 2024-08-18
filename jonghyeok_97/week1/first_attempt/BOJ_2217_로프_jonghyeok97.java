package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2217_로프_jonghyeok97 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            List<Integer> ropesWeight = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                int ropeMaxWeight = Integer.parseInt(br.readLine());
                ropesWeight.add(ropeMaxWeight);
            }

            Collections.sort(ropesWeight);

            // 1 3 4 7 10
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < ropesWeight.size(); i++) {
                result = Math.max(result, ropesWeight.get(i) * (ropesWeight.size() - i));
            }

            System.out.println(result);
        }
    }
}
