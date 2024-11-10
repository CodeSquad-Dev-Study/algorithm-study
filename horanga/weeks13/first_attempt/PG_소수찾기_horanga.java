package horanga.weeks13.first_attempt;

import java.util.*;

public class PG_소수찾기_horanga {
    private Set<Integer> nums = new HashSet<>();
    private boolean[] visited = new boolean[7];

    public int solution(String numbers) {

        function(numbers, "", 0);
        int answer = 0;
        for (Integer num : nums) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;

    }

    public void function(String numbers, String a, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums.add(Integer.parseInt(a + numbers.charAt(i)));
                function(numbers, a + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }

        }

    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
