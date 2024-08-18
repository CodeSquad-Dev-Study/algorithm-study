package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2847_게임을만든동준이_jonghyeok97 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            points.add(Integer.parseInt(br.readLine()));
        }

        int base = points.get(points.size() - 1);
        int result = 0;

        for (int i = points.size() - 2; i >= 0; i--) {
            int point = points.get(i);
            while (point >= base) {
                result++;
                point--;
            }
            base = point;
        }
        System.out.println(result);
    }
}
