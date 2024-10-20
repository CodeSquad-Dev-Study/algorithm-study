package dnjsxo0616.week10.first_attempt;

import java.util.Arrays;

public class PG_가장큰수_dnjsxo0616 {
    public String solution(int[] numbers) {
        int lenN = numbers.length;
        String[] strNums = new String[lenN];
        for (int i = 0; i < lenN; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));


        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
