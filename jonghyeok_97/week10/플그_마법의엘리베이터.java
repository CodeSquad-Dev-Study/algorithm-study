package jonghyeok_97.week10;

public class 플그_마법의엘리베이터 {

    public int solution(int storey) {
        int answer = 0;
        while (true) {
            int left = storey % 10;

            if (left < 5) {
                storey -= left;
                answer += left;
            } else if (left > 5) {
                storey += 10 - left;
                answer += 10 - left;
            } else {
                int tmp = (storey / 10) % 10;
                if (tmp + 1 > 5) {
                    storey += left;
                    answer += 10 - left;
                } else {
                    storey -= left;
                    answer += left;
                }
            }
            storey /= 10;
            if (storey == 0) {
                break;
            }
        }
        return answer;
    }
}
