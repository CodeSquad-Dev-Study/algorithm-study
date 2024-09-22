package horanga.weeks6.first_attempt;

import java.util.*;

public class BOJ_1158_요세푸스문제_horanga {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int N = in.nextInt();
        int K = in.nextInt();


        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(q.size() > 1) {

            for(int i = 0; i < K - 1; i++) {
                int val = q.poll();
                q.offer(val);
            }

            sb.append(q.poll()).append(", ");
        }

        // 마지막 원소 출력한 뒤 > 도 붙여준다.
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}
