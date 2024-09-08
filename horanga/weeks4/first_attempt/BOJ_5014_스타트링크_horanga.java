package horanga.weeks4.first_attempt;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class BOJ_5014_스타트링크_horanga {

    static int f,s,g;
    static int[] move;
    static int[] dir = new int[2];
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        f = scanner.nextInt();
        s = scanner.nextInt();
        g = scanner.nextInt();
        dir[0] = scanner.nextInt();
        dir[1] = -scanner.nextInt();

        move = new int[f+1];
        bfs(s);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[f+1];

        q.add(start);
        check[start] = true;
        move[start] = 0;

        while(!q.isEmpty()) {
            int pos = q.poll();
            if(pos == g) {
                System.out.println(move[pos]);
                return;
            }

            for(int i=0; i<2; i++) {
                int next = pos+ dir[i];

                if(next > f || next <1 ) continue;

                if(!check[next]) {
                    check[next] = true;
                    q.add(next);
                    move[next]= move[pos]+1;
                }
            }
        }

        System.out.println("use the stairs");

    }
}
