package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1449_수리공항승_jonghyeok {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int L = input[1];

            int[] input2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            double number = 0;
            int count = 0;
            for (int i = 0; i < input2.length; i++) {
                if (number < input2[i]) {
                    number = input2[i];
                    number -= 0.5;
                    number += L;
                    count++;
                }
            }
            System.out.println(count);
        }
}
