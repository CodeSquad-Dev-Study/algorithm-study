package horanga.week1.first_attempt;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1744_수묶기_horanga {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if(num>0){
                plus.add(num);
            } else {
                minus.add(num);

            }
        }

        int answer =0;

        while(!minus.isEmpty()){
            int cur = minus.poll();
            if(minus.isEmpty()){
                answer +=cur;
                break;
            }

            if(minus.peek()==0){
                minus.poll();
            } else {
                answer +=cur * minus.poll();
            }
        }

        while(!plus.isEmpty()){
            int cur = plus.poll();
            if(plus.isEmpty()){
                answer +=cur;
                break;
            }

            if(cur==1){
                answer +=1;
            } else if(plus.peek()==1){
                answer +=cur+plus.poll();
            } else
                answer +=cur * plus.poll();

        }

        System.out.println(answer);
    }
}
