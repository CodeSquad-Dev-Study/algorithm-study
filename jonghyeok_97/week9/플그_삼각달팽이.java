package jonghyeok_97.week9;

import java.util.ArrayList;
import java.util.List;

public class 플그_삼각달팽이 {

    private static int[] dy = {1, 0, -1};
    private static int[] dx = {0, 1, -1};

    public int[] solution(int n) {
        int[][] map = new int[n][n];

        if (n == 1) {
            return new int[]{1};
        }
        int y = 0;
        int x = 0;
        int value = 1;
        int d = 0;

        map[y][x] = value;

        while (true) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny == n || nx == n || map[ny][nx] != 0) {
                d = (d+1)%3;
                int nny = y + dy[d];
                int nnx = x + dx[d];
                if (map[nny][nnx] != 0) {
                    break;
                }
                continue;
            }
            map[ny][nx] = ++value;
            y = ny;
            x = nx;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {

                    list.add(map[i][j]);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
