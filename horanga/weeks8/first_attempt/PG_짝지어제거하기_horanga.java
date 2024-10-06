package horanga.weeks8.first_attempt;

import java.util.Stack;

public class PG_짝지어제거하기_horanga {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<s.length(); i++){

            if(!stack.isEmpty() && stack.peek().equals(s.charAt(i))){
                stack.pop();
            } else{
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;


    }
}
