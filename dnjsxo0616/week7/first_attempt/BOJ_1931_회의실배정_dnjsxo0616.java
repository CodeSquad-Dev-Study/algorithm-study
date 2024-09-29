package dnjsxo0616.week7.first_attempt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정_dnjsxo0616 {
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

        List<Time> times = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times.add(new Time(start, end));
        }

        times.sort((t1, t2) -> {
            if (t1.end == t2.end) {
                return Integer.compare(t1.start, t2.start);
            }
            return Integer.compare(t1.end, t2.end);
        });

        for (Time ts : times) {
            System.out.println(ts.start + "와" + ts.end);
        }

        int count = 0;
        int endTime = 0;

        for (Time time : times) {

            if (time.start >= endTime) {
                endTime = time.end;
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }
}
