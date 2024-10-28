package imojaek.week12.first_attempt;

import java.util.Stack;

public class PG_12906_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        answer = stack.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
