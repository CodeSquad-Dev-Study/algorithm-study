package horanga.week1.first_attempt;

import java.util.*;

public class BOJ_1931_회의실배정_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }
        Arrays.sort(time, (o1, o2) -> {

            // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬한다.
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int preEndTime = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (preEndTime <= time[i][0]) {
                preEndTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
