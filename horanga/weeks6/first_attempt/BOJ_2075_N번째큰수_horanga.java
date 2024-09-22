package horanga.weeks6.first_attempt;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2075_N번째큰수_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i =0; i<num; i++){
            for(int j =0; j<num; j++){
                queue.add(scanner.nextInt());
            }
        }
        for(int i =0; i<num-1; i++){
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}
