package horanga.week2.first_attempt;

import java.util.Scanner;

public class BOJ_2660_회장뽑기_horanga {
    static int INF = 987654321;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    arr[i][j] = INF; //자기 자신으로 가는 경로 외에는 최대값으로 설정
                }
            }
        }

        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x == -1 && y == -1) {
                break;
            }

            arr[x][y] = arr[y][x] = 1; // 친구 관계는 양방향
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }

                    /*
                    1->2->3->4 이렇게 가는 방향이 있다고 해보자.
                    이때는 1에서 3으로 가는 방향 arr[1][3]이 = arr[1][2]+arr[2][3]으로 갱신되면서
                    이제 arr[1][4]가 중간지점 3을 거쳐서 arr[1][3]+arr[3][4]로 계산할 수 있게 된다.
                     */
                }
            }
        }

        int readerScore = INF;

        int[] scoreArr = new int[n + 1]; // 친구 점수 목록

        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != INF) {
                    score = Math.max(score, arr[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder title = new StringBuilder();
        title.append(readerScore + " ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i + " ");
            }
        }

        title.append(readerNum);

        System.out.println(title);
        System.out.println(body);

    }
}
