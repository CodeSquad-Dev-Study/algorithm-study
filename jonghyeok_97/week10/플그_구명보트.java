package jonghyeok_97.week10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 플그_구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> linkList = new LinkedList<>();
        for (int i : people) {
            linkList.add(i);
        }
        while (!linkList.isEmpty()) {
            answer++;
            int start = linkList.get(0);
            int end = linkList.get(linkList.size() - 1);
            if (start + end <= limit) {
                linkList.remove(0);
            }
            if (!linkList.isEmpty()) {
                linkList.remove(linkList.size() - 1);
            }
        }
        return answer;
    }

}
