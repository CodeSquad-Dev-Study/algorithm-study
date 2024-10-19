package yonghyeonpark.week10.first_attempt;

import java.util.HashSet;
import java.util.Set;

public class PG_폰켓몬_yonghyeonpark {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }
}
