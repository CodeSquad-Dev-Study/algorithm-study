package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1931_회의실배정_jonghyeok {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            int result = 0;
            List<Temp> temps = new ArrayList<>();


            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");
                int first = Integer.parseInt(split[0]);
                int second = Integer.parseInt(split[1]);

                temps.add(new Temp(first, second));
            }

            Collections.sort(temps);
//            temps.sort(Temp::compareTo);

            int last = 0;
            for (Temp temp : temps) {
                if (last <= temp.first) {
                    last = temp.second;
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    static class Temp implements Comparable<Temp> {

        public final int first;
        public final int second;

        public Temp(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Temp other) {
            if (other.second == second) {
                return first - other.first;
            }
            return second - other.second;
        }
    }
}


