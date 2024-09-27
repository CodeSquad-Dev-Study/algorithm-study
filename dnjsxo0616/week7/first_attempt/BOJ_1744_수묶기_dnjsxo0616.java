package dnjsxo0616.week7.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기_dnjsxo0616 {
    static PriorityQueue<Integer> pos = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> neg = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                pos.offer(input);
            } else neg.offer(input);
        }

        int ans = 0;
        while(!neg.isEmpty()) {
            int p = neg.poll();
            if(neg.isEmpty()) {
                ans += p;
                break;
            }
            if(neg.peek() == 0) {
                neg.poll();
            } else {
                ans += p * neg.poll();
            }
        }

        while(!pos.isEmpty()) {
            int p = pos.poll();
            if(pos.isEmpty()) {
                ans += p;
                break;
            }
            if(p == 1) {
                ans += 1;
            } else if (pos.peek() == 1) {
                ans += p + pos.poll();
            } else ans += p * pos.poll();
        }

        System.out.println(ans);
    }
}
