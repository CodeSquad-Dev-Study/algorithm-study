package dnjsxo0616.week7.first_attempt;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정_dnjsxo0616 {
    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        Time[] times = new Time[t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        Arrays.sort(times, (t1, t2) ->
                t1.start == t2.start ? Integer.compare(t1.end, t2.end) : Integer.compare(t1.start, t2.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);
        for (int j = 1; j < t; j++) {
            if (pq.peek() <= times[j].start) {
                pq.poll();
            }
            pq.offer(times[j].end);
        }
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
