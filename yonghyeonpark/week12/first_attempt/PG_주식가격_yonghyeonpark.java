package yonghyeonpark.week12.first_attempt;

import java.util.ArrayDeque;
import java.util.Deque;

public class PG_주식가격_yonghyeonpark {

    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            int price = prices[i];

            while (!d.isEmpty() && price < prices[d.peek()]) {
                int index = d.pop();
                answer[index] = i - index;
            }
            d.push(i);
        }

        while (!d.isEmpty()) {
            int index = d.poll();
            answer[index] = length - index - 1;
        }

        return answer;
    }
}
