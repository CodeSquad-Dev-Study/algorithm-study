package week10.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5073_삼각형과_세_변_seondays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int one;
        int two;
        int three;

        while (true) {
            int[] triangle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
                    .sorted()
                    .toArray();

            one = triangle[0];
            two = triangle[1];
            three = triangle[2];

            if (one == 0 && two == 0 && three == 0) {
                return;
            }

            // 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형이 아니다
            if (three >= one + two) {
                System.out.println("Invalid");
                continue;
            }
            if (one == two && two == three) {
                System.out.println("Equilateral");
                continue;
            }
            if (one == two || two == three || one == three) {
                System.out.println("Isosceles");
                continue;
            }
            if (one != two && one != three) {
                System.out.println("Scalene");
                continue;
            }
        }
    }
}
