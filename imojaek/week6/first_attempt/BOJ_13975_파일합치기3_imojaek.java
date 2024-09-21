package imojaek.week6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_13975_파일합치기3_imojaek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(input[i]));
            }

            Long answer = 0L;

            while (pq.size() > 1) {
                Long n1 = pq.poll();
                Long n2 = pq.poll();
                if (n1 == null || n2 == null)
                    break;

                answer += n1 + n2;
                pq.offer(n1 + n2);
            }
            System.out.println(answer);
        }


    }
}
