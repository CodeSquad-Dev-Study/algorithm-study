package yonghyeonpark.week5.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int c = 0;
        for (int e : seq) {
            if (c < e) {
                for (int i = c + 1; i <= e; i++) {
                    stack.push(i);
                    result.append("+").append("\n");
                }
                c = e;
            }
            if (stack.peek() != e) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            result.append("-").append("\n");
        }

        System.out.println(result);
    }
}
