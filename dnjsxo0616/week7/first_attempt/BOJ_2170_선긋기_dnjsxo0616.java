package dnjsxo0616.week7.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170_선긋기_dnjsxo0616 {
    static class Line {
        long start;
        long end;

        public Line(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Line[] lines = new Line[t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            lines[i] = new Line(start, end);
        }

        Arrays.sort(lines, (l1, l2) -> {
            if (l1.start == l2.start) {
                return Long.compare(l1.end, l2.end);
            }
            return Long.compare(l1.start, l2.start);
        });

        long count = 0;
        long startLine = lines[0].start;
        long endLine = lines[0].end;

        for (int i = 1; i < lines.length; i++) {
            Line l = lines[i];
            if (endLine >= l.start) {
                endLine = Math.max(endLine, l.end);
            } else {
                count += endLine - startLine;
                startLine = l.start;
                endLine = l.end;
            }
        }
        count += endLine - startLine;

        System.out.println(count);
    }
}
