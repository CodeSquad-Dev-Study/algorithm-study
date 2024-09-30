package jonghyeok_97.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 플그_실패율 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2})));
    }

    public static int[] solution(int N, int[] stages) {

        int[] count = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            count[stage]++;
        }

        int peopleCount = stages.length;
        List<Failure> failures = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (peopleCount == 0) {
                failures.add(new Failure(i, 0));
                continue;
            }
            double failure = (double) count[i] / peopleCount;
            failures.add(new Failure(i, failure));
            peopleCount -= count[i];
        }

        Collections.sort(failures);

        return failures.stream()
                .mapToInt(Failure::getStageLevel)
                .toArray();
    }

    static class Failure implements Comparable<Failure> {

        private final int stageLevel;
        private final double failureRatio;

        public Failure(int stageLevel, double failureRatio) {
            this.stageLevel = stageLevel;
            this.failureRatio = failureRatio;
        }

        @Override
        public int compareTo(Failure o) {
            if (failureRatio != o.failureRatio) {
                return Double.compare(o.failureRatio, failureRatio);
            }
            return stageLevel - o.stageLevel;
        }

        public int getStageLevel() {
            return stageLevel;
        }

        @Override
        public String toString() {
            return "Failure{" +
                    "failureRatio=" + failureRatio +
                    '}';
        }
    }
}

