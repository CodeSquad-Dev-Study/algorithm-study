package dnjsxo0616.week9.first_attempt;

import java.util.ArrayList;
import java.util.List;

public class PG_실패율 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            List<RoundFailure> list = new ArrayList<>();
            int stagePerson = stages.length;
            List<Integer> stageList = new ArrayList<>();
            for (int stage : stages) {
                stageList.add(stage);
            }

            for (int i = 1; i <= N; i++) {
                int failureNumber = 0;
                List<Integer> changeStage = new ArrayList<>();
                for (int stage : stages) {
                    if (stage == i) {
                        failureNumber++;
                    }
                }
                if (failureNumber == 0) {
                    list.add(new RoundFailure(i, 0));
                } else {
                    list.add(new RoundFailure(i, (double) failureNumber / stagePerson));
                }
                stagePerson -= failureNumber;
                stageList = changeStage;
            }

            list.sort((t1, t2) -> {
                if (t1.getFailureRate() == t2.getFailureRate()) {
                    return Integer.compare(t1.getRound(), t2.getRound());
                } else {
                    return Double.compare(t2.getFailureRate(), t1.getFailureRate());
                }
            });

            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = list.get(i).getRound();
            }
            return answer;

        }
    }

    class RoundFailure {
        private int round;
        private double failureRate;
        public RoundFailure(int round, double failureRate) {
            this.round = round;
            this.failureRate = failureRate;
        }
        public int getRound() {
            return round;
        }
        public double getFailureRate() {
            return failureRate;
        }
    }
}
