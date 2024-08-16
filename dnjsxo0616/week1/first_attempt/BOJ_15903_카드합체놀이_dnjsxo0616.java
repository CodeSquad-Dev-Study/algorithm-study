package dnjsxo0616.week1.first_attempt;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_15903_카드합체놀이_dnjsxo0616 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int line = sc.nextInt();
            int turn = sc.nextInt();

            PriorityQueue<Long> pQ = new PriorityQueue<>();

            for(int i=0; i<line; i++) {
                pQ.add(sc.nextLong());
            }

            for(int j=0;  j<turn; j++) {
                long q1 = pQ.poll();
                long q2 = pQ.poll();
                long sumNum = q1 + q2;

                pQ.add(sumNum);
                pQ.add(sumNum);
            }

            long sum = 0;
            while(!pQ.isEmpty()) {
                sum += pQ.poll();
            }

            System.out.print(sum);
        }
    }
}
