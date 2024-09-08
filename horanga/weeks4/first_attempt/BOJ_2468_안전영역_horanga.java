package horanga.weeks4.first_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ_2468_안전영역_horanga {

    static int n;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        arr = new int[n][n];
        int maxHeight=0;

        for(int i =0; i<n ; i++){
            for(int j =0; j<n; j++){
                arr[i][j] = scanner.nextInt();
                if(arr[i][j] > maxHeight) {
                    maxHeight =arr[i][j];
                }
            }
        }
        int max =0;
        for(int height=0; height<maxHeight+1; height++) {
            visited = new boolean[n][n];
            int cnt=0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j] && arr[i][j] > height){
                        cnt+=dfs(i,j,height); // 해당 안전영역 탐색 시작
                    }

                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);

    }

    private static int dfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int px = poll[0];
            int py = poll[1];

            for(int j=0; j<4; j++) {
                int nx = px + dx[j];
                int ny = py + dy[j];

                if(nx<0 || ny<0 || nx>n-1 || ny >n-1) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny]> height) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }

            }


        }
        return 1;

    }
}
