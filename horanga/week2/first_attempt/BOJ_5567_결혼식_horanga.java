package horanga.week2.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식_horanga {
    static int num;
    static int length;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num= Integer.parseInt(br.readLine());
        length = Integer.parseInt(br.readLine());
        visited = new boolean[num+1];

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i =0; i<=num+1; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i =0; i<length; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        visited[1]=true;
        dfs(graph, 1,0);
        int answer =0;

        for(int i =2; i<visited.length; i++){
            if(visited[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(List<ArrayList<Integer>> graph, int start, int depth){
        if(depth==2){
            return;
        }

        for(int i : graph.get(start)){
            visited[i]=true;
            dfs(graph, i, depth+1);
        }
    }
}
