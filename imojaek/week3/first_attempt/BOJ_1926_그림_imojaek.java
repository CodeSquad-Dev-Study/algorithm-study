package imojaek.week3.first_attempt;

import java.util.Scanner;

public class BOJ_1926_그림_imojaek {
    static int n;
    static int m;

    static int[][] palette;
    static int numOfPicture = 0;
    static int tmpArea = 0;
    static int maxArea = 0;
    static int[][] isVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        palette = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                palette[i][j] = sc.nextInt();
            }
        }
        isVisited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (palette[i][j] == 1 && isVisited[i][j] == 0) {
                    numOfPicture++;
                    dfs(i, j);
                    if (tmpArea > maxArea) {
                        maxArea = tmpArea;
                    }
                    tmpArea = 0;
                }
            }
        }
        System.out.println(numOfPicture);
        System.out.println(maxArea);
    }


    public static void dfs(int y, int x) {
        isVisited[y][x] = 1;
        tmpArea++;

        if (y - 1 >= 0 && palette[y - 1][x] == 1 && isVisited[y - 1][x] == 0) {
            dfs(y - 1, x);
        }
        if (y + 1 < n && palette[y + 1][x] == 1 && isVisited[y + 1][x] == 0) {
            dfs(y + 1, x);
        }
        if (x - 1 >= 0 && palette[y][x - 1] == 1 && isVisited[y][x - 1] == 0) {
            dfs(y, x - 1);
        }
        if (x + 1 < m && palette[y][x + 1] == 1 && isVisited[y][x + 1] == 0) {
            dfs(y, x + 1);
        }
    }
}
