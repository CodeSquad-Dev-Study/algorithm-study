package yonghyeonpark.week6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pQ.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pQ.poll());
                continue;
            }
            pQ.offer(num);
        }
    }
}
