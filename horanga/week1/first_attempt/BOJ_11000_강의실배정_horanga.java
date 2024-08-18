package horanga.week1.first_attempt;

import java.util.*;

public class BOJ_11000_강의실배정_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        List<int[] > list = new ArrayList<>();

        for(int i =0; i<number; i++){
            int[] time = new int[2];
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            time[0] = start;
            time[1] = end;
            list.add(time);
        }

        list.sort((o1, o2) -> {

            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        Queue<Integer> q = new PriorityQueue<>();
        int endTime=0;

        for(int[] arr : list){
            endTime = arr[1];


            /*
            우선 순위 큐의 특성을 이용한다.
            1)앞에서 다른 강의실을 써야 하는 수업들의 종료시간을 우선순위 큐에 넣었다.

            만약에

            1 - 3
            2 - 4
            3 - 4
            4 - 5

            수업이 있다고 해보자.

            그러면,

            순회 중 세번째 수업의 차례가 왔을 때 우선순위 큐에는 3, 4 순으로 값이 들어가 있다.
            이때, peek()을 하면 가장 작은 숫자(맨 앞에 있는)값이 나온다. 이 3과 세번째 수업의 시작시간은 동일하니, 같은 강의실을 쓸 수 있다.
            이처럼 가장 먼저 종료되는 수업을 찾아야 그리디한 방식, 즉 더 많은 수업을 그 강의실에 할당할 수 있게 된다.
             */


            if(!q.isEmpty() && q.peek() <= arr[0]){
                q.poll();
            }
            q.add(endTime);
        }
        System.out.println(q.size());
    }
}
