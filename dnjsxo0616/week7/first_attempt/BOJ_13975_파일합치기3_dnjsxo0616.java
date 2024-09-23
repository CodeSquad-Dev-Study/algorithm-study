package dnjsxo0616.week7.first_attempt;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_파일합치기3_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long ab = a+b;
                sum += ab;
                pq.add(ab);
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
