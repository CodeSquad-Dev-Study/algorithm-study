package dnjsxo0616.week11.first_attempt;

public class PG_체육복_dnjsxo0616 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] check = new int[n + 2];

        for (int l : lost) {
            check[l]--;
        }

        for (int r : reserve) {
            check[r]++;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == -1) {
                if (check[i - 1] == 1) {
                    check[i]++;
                    check[i - 1]--;
                } else if (check[i + 1] == 1) {
                    check[i]++;
                    check[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}
