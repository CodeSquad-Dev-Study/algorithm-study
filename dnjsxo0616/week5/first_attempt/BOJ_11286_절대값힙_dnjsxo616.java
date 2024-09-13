package dnjsxo0616.week5.first_attempt;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_11286_절대값힙_dnjsxo616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(absA, absB);
        }) ;

        for(int i=0; i<t; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                queue.add(x);
            } else {
                if(queue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
