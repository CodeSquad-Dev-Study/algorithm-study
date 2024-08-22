package horanga.week2.first_attempt;

import java.util.*;

public class BOJ_1325_효율적인해킹_horanga {

    static int n;
    static int m;
    static List<Integer>[] arr;
    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new List[n+1];
        result = new int[n+1];

        for(int i =1; i<=n; i++){
            arr[i]= new ArrayList<>();
        }

        for(int i =0; i<m; i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            arr[s].add(e);
        }

        for(int i =1; i<=n; i++){
            visit= new boolean[n+1];
            BFS(i);
        }

        int big=0;
        for(int i =1; i<=n; i++){
            big = Math.max(big,result[i]);
        }

        for(int i =1; i<=n; i++){
            if (result[i] == big) {		// 최대값과 같다면 인덱스 출력
                System.out.print(i + " ");
            }
        }


    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i : arr[num]){
                if(visit[i]== false){
                    result[i]++;
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
