package dnjsxo0616.week12.first_attempt;

import java.util.Arrays;

public class PG_최솟값만들기_dnjsxo0616 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}
