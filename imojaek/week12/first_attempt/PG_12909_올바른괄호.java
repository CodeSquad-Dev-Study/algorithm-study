package imojaek.week12.first_attempt;

import java.util.Stack;

public class PG_12909_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            answer = false;

        return answer;
    }
}
