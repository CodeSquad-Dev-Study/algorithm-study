package yonghyeonpark.week11.first_attempt;

import java.util.Arrays;

public class PG_구명보트_yonghyeonpark {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int min = 0;
        for (int max = people.length - 1; max >= min; max--) {
            if (people[max] + people[min] > limit) {
                answer++;
                continue;
            }
            answer++;
            min++;
        }
        return answer;
    }
}
