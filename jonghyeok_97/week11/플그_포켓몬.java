package jonghyeok_97.week11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 플그_포켓몬 {

    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            List<Integer> distincted = Arrays.stream(nums)
                    .boxed()
                    .distinct()
                    .collect(Collectors.toList());

            return Math.min(nums.length / 2, distincted.size());
        }
    }
}
