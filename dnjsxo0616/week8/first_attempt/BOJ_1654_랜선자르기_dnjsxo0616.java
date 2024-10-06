package dnjsxo0616.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lines = new int[k];

        long max = 0;
        for(int i=0; i<k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if(max < lines[i]) {
                max = lines[i];
            }
        }
        max++;

        long min = 0;
        long mid;
        while(min < max) {
            mid = (max + min) / 2;

            long count = 0;
            for(int i=0; i<k; i++) {
                count += (lines[i] / mid);
            }

            if(count < n) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}
