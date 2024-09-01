package horanga.weeks3.first_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질_horanga {

    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        System.out.print(bfs(N));
    }
    private static int  bfs(int node)
    {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (queue.isEmpty() == false)
        {
            n = queue.remove();

            if (n == K)
            {
                return visited[n]-1;
            }

            if (n-1>=0 && visited[n-1] == 0)
            {
                visited[n-1] = visited[n]+1;
                queue.add(n-1);
            }
            if (n+1 <= 100000 && visited[n+1] == 0)
            {
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }
            if (2*n <= 100000 && visited[2*n] == 0)
            {
                visited[2*n] = visited[n] + 1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}
