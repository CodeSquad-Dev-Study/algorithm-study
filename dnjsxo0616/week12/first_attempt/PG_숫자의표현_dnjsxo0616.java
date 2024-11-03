package dnjsxo0616.week12.first_attempt;

public class PG_숫자의표현_dnjsxo0616 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) break;
            }
        }
        return answer;
    }
}
