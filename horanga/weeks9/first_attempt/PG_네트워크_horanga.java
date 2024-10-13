package horanga.weeks9.first_attempt;

public class PG_네트워크_horanga {

    public int solution(int n, int[][] computers) {
        int count=0;

        boolean[] visited  = new boolean[n];

        for(int i =0; i<n; i++){
            if(!visited[i]){
                count++;
                func(computers, i, visited);
            }
        }


        return count;
    }

    private void func(int[][] computers, int start, boolean[] visited){
        for(int i = 0; i<computers[0].length; i++){
            if(computers[start][i]==1 && !visited[i]){
                visited[i] = true;
                func(computers, i, visited);
            }
        }
    }
}
