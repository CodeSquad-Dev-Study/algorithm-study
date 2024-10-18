package yonghyeonpark.week10.first_attempt;

import java.util.Arrays;

public class PG_HIndex_yonghyeonpark {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        int length = citations.length;
        for (int i = length - 1; i >= 0; i--) {
            int num = citations[i];
            if (num >= length - i) {
                answer = length - i;
            }
        }
        return answer;
    }
}
