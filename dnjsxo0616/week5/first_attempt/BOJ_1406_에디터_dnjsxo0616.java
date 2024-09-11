package dnjsxo0616.week5.first_attempt;

import java.io.*;
import java.util.Stack;

public class BOJ_1406_에디터_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int t = Integer.parseInt(br.readLine());

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        String[] input = str.split("");
        for(String part : input) {
            stack1.push(part);
        }

        for(int i=0; i<t; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if(!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    break;
                case 'D':
                    if(!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case 'B':
                    if(!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    break;
                case 'P':
                    char s = command.charAt(2);
                    stack1.push(String.valueOf(s));
                    break;
                default:
                    break;
            }
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while(!stack2.isEmpty()) {
            bw.write(stack2.pop());
        }
        bw.flush();
        bw.close();
    }
}
