package dnjsxo0616.week5.first_attempt;

import java.io.*;
import java.util.Stack;

public class BOJ_5397_키로거_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String input = br.readLine();
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            for(int j=0; j<input.length(); j++) {
                char c = input.charAt(j);
                switch (c){
                    case '<':
                        if(!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                        break;
                    case '>':
                        if(!stack2.isEmpty()) {
                            stack1.push(stack2.pop());
                        }
                        break;
                    case '-':
                        if(!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default:
                        stack1.push(c);
                        break;
                }
            }
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            while(!stack2.isEmpty()) {
                bw.write(stack2.pop());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
