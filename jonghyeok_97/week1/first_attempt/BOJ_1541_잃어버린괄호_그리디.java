package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_1541_잃어버린괄호_그리디 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            List<String> collect = Arrays.stream(input.split("\\-"))
                    .collect(Collectors.toList());

            List<Integer> numbers = new ArrayList<>();
            for (String s : collect) {
                if (s.contains("+")) {
                    Optional<Integer> sum = Stream.of(s.split("\\+"))
                            .map(Integer::parseInt)
                            .reduce(Integer::sum);
                    numbers.add(sum.get());
                } else {
                    numbers.add(Integer.parseInt(s));
                }
            }
            Optional<Integer> reduce = numbers.stream()
                    .reduce((a, b) -> a - b);

            System.out.println(reduce.get());
        }
    }
}
