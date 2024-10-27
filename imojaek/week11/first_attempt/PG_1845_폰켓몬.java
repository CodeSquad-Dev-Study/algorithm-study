package imojaek.week11.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_1845_폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }

        answer = Math.min(nums.length / 2, map.size());

        return answer;
    }
}
