import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실_배정_seondays {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    StringTokenizer stringTokenizer;
    PriorityQueue<int[]> lectures = new PriorityQueue<>((o1, o2) -> {
      if (o1[0] == o2[1]) {
        return o1[1] - o2[1];
      } else {
        return o1[0] - o2[0];
      }
    });
    PriorityQueue<Integer> close = new PriorityQueue<>();
    close.offer(0);

    for (int i = 0; i < count; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());
      lectures.offer(new int[]{start, end});
    }

    System.out.println(solution(lectures, close));
  }

  public static int solution(PriorityQueue<int[]> lectures, PriorityQueue<Integer> close) {
    while (!lectures.isEmpty()) {
      int[] nowLecture = lectures.poll();
      // 현재 강의의 시작 시간이, 현재 가장 빠른 종료 시간 이후라면 이어서 사용한다. 즉 close에 있는 값을 갱신한다.
      if (close.peek() <= nowLecture[0]) {
        close.poll();
      }
      close.offer(nowLecture[1]);
    }
    return close.size();
  }
}
