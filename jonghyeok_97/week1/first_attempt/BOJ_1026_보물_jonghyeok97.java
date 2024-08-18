package jonghyeok_97.week1.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1026_보물_jonghyeok97 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputs.add(br.readLine());
        }

        int count = Integer.parseInt(inputs.get(0));
        List<Integer> A = toIntegerList(inputs.get(1).split(" "));
        List<Integer> B = toIntegerList(inputs.get(2).split(" "));

        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B);

        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result += A.get(i) * B.get(i);
        }
        System.out.println(result);
    }


    private static List<Integer> toIntegerList(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
