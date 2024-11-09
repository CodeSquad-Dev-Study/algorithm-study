package dnjsxo0616.week13.first_attempt;

import java.util.Arrays;

public class PG_HIndex_dnjsxo0616 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
