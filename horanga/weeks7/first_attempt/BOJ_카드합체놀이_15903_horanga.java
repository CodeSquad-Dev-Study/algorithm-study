package horanga.weeks7.first_attempt;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_카드합체놀이_15903_horanga {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드 수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long tempHap = pq.poll();
            tempHap += pq.poll();

            pq.add(tempHap);
            pq.add(tempHap);
        }

        long hap = 0;
        while (!pq.isEmpty()) {
            hap += pq.poll();
        }

        bw.write(Long.toString(hap));
        bw.flush();
        bw.close();
        br.close();
    }
}
