package dnjsxo0616.week6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<t; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                int poll = pq.poll();
                System.out.println(poll);
                continue;
            }
            pq.offer(input);
        }
    }
}
