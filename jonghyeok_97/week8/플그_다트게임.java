package jonghyeok_97.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 플그_다트게임 {

    public static int solution(String dartResult) {
        String copy = dartResult;
        String withoutOption = dartResult.replaceAll("\\*|#", "");
        List<String> areas = findAreas(withoutOption);
        List<Integer> scores = findScores(withoutOption);
        List<String> options = findOptions(copy);

        int[] calculate = calculate(scores, areas);
        System.out.println(Arrays.toString(calculate));

        for (int i = 0; i < 3; i++) {
            String option = options.get(i);
            if (option.equals("*")) {
                calculate[i] *= 2;
                if (i != 0) {
                    calculate[i-1] *= 2;
                }
            } else if (option.equals("#")) {
                calculate[i] *= -1;
            }
        }
        System.out.println(Arrays.toString(calculate));
        return Arrays.stream(calculate)
                .sum();
    }

    private static List<String> findOptions(String copy) {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < copy.length() - 1; i++) {
            char c = copy.charAt(i);
            if ('D' <= c && c <= 'T') {
                char nextC = copy.charAt(i + 1);
                if ('0' <= nextC && nextC <= '9') {
                    options.add(" ");
                } else {
                    options.add(String.valueOf(nextC));
                }
            }
        }
        if (copy.endsWith("#") || copy.endsWith("*")) {
            return options;
        }
        options.add(" ");
        return options;
    }

    private static List<Integer> findScores(String withoutOption) {
        return Arrays.stream(withoutOption.split("D|S|T"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> findAreas(String withoutOption) {
        List<String> areas = new ArrayList<>();
        for (int i = 0; i < withoutOption.length(); i++) {
            char c = withoutOption.charAt(i);
            if (c == 'D' || c == 'T' || c == 'S') {
                areas.add(String.valueOf(c));
            }
        }
        return areas;
    }


    private static int[] calculate(List<Integer> scores, List<String> areas) {
        int[] withoutOption = new int[3];
        for (int i = 0; i < 3; i++) {
            String area = areas.get(i);
            int score = scores.get(i);
            if ("S".equals(area)) {
                withoutOption[i] = score;
            } else if ("D".equals(area)) {
                withoutOption[i] = score * score;
            } else {
                withoutOption[i] = score * score * score;
            }
        }
        return withoutOption;
    }
}
