package horanga.week5.first_attempt;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012_괄호_horanga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        String[] arr = new String[num];
        String[] answer = new String[num];

        for (int i = 0; i < num; i++) {
            arr[i] = scanner.next();
        }

        for (int i = 0; i < num; i++) {
            if(check(arr[i])){
                answer[i] = "YES";
            } else{
                answer[i] = "NO";
            }
        }

        for(int i =0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    private static boolean check(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if(stack.isEmpty()){
                    return false;
                }

                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
            }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
