package dnjsxo0616.week6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_좋은단어_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<t; i++) {
            String line = br.readLine();
            stack.push(line.charAt(0));
            for(int j=1; j<line.length(); j++) {
                if (!stack.isEmpty() && stack.peek().equals(line.charAt(j))) {
                    stack.pop();
                    continue;
                }
                stack.push(line.charAt(j));
            }
            if(stack.isEmpty()) {
                count++;
            }
            stack.clear();
        }
        System.out.println(count);
    }
}
