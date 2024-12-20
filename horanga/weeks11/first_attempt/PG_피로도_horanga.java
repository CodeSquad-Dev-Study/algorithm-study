package horanga.weeks11.first_attempt;


import java.util.*;

public class PG_피로도_horanga {
        public int answer; // 최대 던전 수
        public boolean[] visited; // 방문 여부

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            dfs(0, k, dungeons);

            return answer;

        }

        public void dfs(int depth, int k, int[][] dungeons) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true;
                    dfs(depth + 1, k - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }

            answer = Math.max(answer, depth);
        }
    }

