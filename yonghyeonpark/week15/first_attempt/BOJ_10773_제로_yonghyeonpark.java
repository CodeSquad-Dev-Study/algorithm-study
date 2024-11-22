package yonghyeonpark.week15.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                s.push(num);
                continue;
            }
            s.pop();
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        System.out.println(sum);
    }
}
