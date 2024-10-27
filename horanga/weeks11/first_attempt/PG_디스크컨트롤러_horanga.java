package horanga.weeks11.first_attempt;

import java.util.*;

public class PG_디스크컨트롤러_horanga {
        public int solution(int[][] jobs) {
            // 요청시간 기준으로 오름차순 정렬
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            // 작업 소요시간 기준으로 최소힙
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            int index = 0;  // jobs 배열의 현재 인덱스
            int count = 0;  // 처리된 작업의 개수
            int total = 0;  // 총 소요시간
            int now = 0;    // 현재 시간

            while(count < jobs.length) {
                // 현재 시점에서 처리할 수 있는 작업들을 큐에 넣음
                while(index < jobs.length && jobs[index][0] <= now) {
                    pq.offer(jobs[index++]);
                }

                if(pq.isEmpty()) {
                    // 처리할 수 있는 작업이 없다면 다음 작업의 요청시간으로 이동
                    now = jobs[index][0];
                } else {
                    // 가장 소요시간이 짧은 작업 처리
                    int[] current = pq.poll();
                    total += now - current[0] + current[1];  // 대기시간 + 작업시간
                    now += current[1];  // 현재 시간 갱신
                    count++;  // 처리된 작업 수 증가
                }
            }

            return total / jobs.length;
        }
    }

