package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1541_잃어버린괄호_완탐 {

    private static List<Integer> numbers;
    private static List<String> ops;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            numbers = Arrays.stream(input.split("\\-|\\+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            ops = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '-' || c == '+') {
                    ops.add(String.valueOf(c));
                }
            }
            go(0, numbers.get(0));

            System.out.println(result);
        }
    }

    private static void go(int idx, int _num) {
        if (idx == numbers.size() - 1) {
            result = Math.min(result, _num);
            return;
        }
        go(idx + 1, calculate(_num, numbers.get(idx + 1), ops.get(idx)));

        if (idx + 2 <= numbers.size() - 1) {
            int temp = calculate(numbers.get(idx + 1), numbers.get(idx + 2), ops.get(idx + 1));
            go(idx + 2, calculate(_num, temp, ops.get(idx)));
        }
    }

    private static int calculate(int first, int second, String op) {
        if ("+".equals(op)) {
            return first + second;
        }
        return first - second;
    }
}
