package dnjsxo0616.week10.first_attempt;

import java.util.HashSet;
import java.util.Set;

public class PG_폰켓몬_dnjsxo0616 {
    public int solution(int[] nums) {
        int take = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int setSize = set.size();

        int answer = take > setSize ? setSize : take;

        return answer;
    }
}
