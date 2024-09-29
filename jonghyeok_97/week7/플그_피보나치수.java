package jonghyeok_97.week7;

public class 플그_피보나치수 {

    public int solution(int n) {
        int answer = 0;
        if (n == 2) {
            return 1;
        }
        int first = 1, second = 1;
        for (int i = 2; i < n; i++) {
            answer = (first + second) % 1234567;
            first = second % 1234567;
            second = answer % 1234567;
        }
        return answer;
    }

}
