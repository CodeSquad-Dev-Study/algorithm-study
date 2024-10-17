package jonghyeok_97.week10;

public class 연속된부분수열의합 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int preIndex = 0;
        int indexDiff = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];

            if (sum >= k) {
                if (sum == k && i - preIndex < indexDiff) {
                    indexDiff = i - preIndex;
                    answer[0] = preIndex;
                    answer[1] = i;

                } else {
                    while (true) {
                        sum -= sequence[preIndex++];
                        if (sum <= k) {
                            break;
                        }
                    }
                    if (sum == k && i - preIndex < indexDiff) {
                        indexDiff = i - preIndex;
                        answer[0] = preIndex;
                        answer[1] = i;
                    }
                }
            }
        }
        return answer;
    }
}

