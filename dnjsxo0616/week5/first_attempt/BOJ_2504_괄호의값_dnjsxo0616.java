package dnjsxo0616.week5.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_괄호의값_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        int res = 0;
        int sum = 1;

        for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                stack.push(c);
                sum *= 2;
            } else if (c == '[') {
                stack.push(c);
                sum *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                }else if(line.charAt(i-1) == '(') {
                    res += sum;
                }
                stack.pop();
                sum /= 2;
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                } else if(line.charAt(i-1) == '[') {
                    res += sum;
                }
                stack.pop();
                sum /= 3;
            }
        }
        if(!stack.isEmpty()) {
            res = 0;
        }
        System.out.println(res);
    }
}
