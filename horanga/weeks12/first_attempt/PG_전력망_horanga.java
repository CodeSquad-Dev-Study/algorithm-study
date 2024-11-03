package horanga.weeks12.first_attempt;

class PG_전력망_horanga {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    int[][] arr;
    boolean[][] visited;
    int min = 10000;
    public int solution(int n, int[][] wires) {

        arr = new int[n+1][n+1];

        for(int i =0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];

            arr[start][end]=1;
            arr[end][start]=1;
        }


        for(int i =0; i<wires.length; i++){
            visited = new boolean[n+1][n+1];
            int start = wires[i][0];
            int end = wires[i][1];

            arr[start][end] = 0;
            arr[end][start] = 0;
            int[] a = new int[2];
            int index =0;


            for(int j =0; j<n; j++){

                if(arr[start][i] ==1 && visited[start][i]){
                    a[index] =function(arr, visited, n);
                    index++;
                }
            }

            int m = a[0] > a[1] ? a[0]-a[1]: a[1]-a[0];
            min = Math.min(min, m);

        }

        return min;
    }

    public int function(int[][] arr, boolean[][] visited, int n){
        int count=0;


        for(int i =0; i<n; i++){
            for(int j=0; j<4; j++){
                int x = arr[i][0]+dx[j];
                int y = arr[i][1]+dy[j];

                if(x < 0 || y < 0 || x > n || y > n){
                    System.out.println("여기");
                    continue;
                }

                if(arr[x][y] == 1 && !visited[x][y]){
                    count++;
                    visited[x][y]= true;

                    System.out.println("통과");
                    function(arr, visited, n);
                }

            }
        }
        System.out.println(count);
        return count;
    }
}