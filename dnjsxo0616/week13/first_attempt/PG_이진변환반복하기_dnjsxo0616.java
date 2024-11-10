package dnjsxo0616.week13.first_attempt;

public class PG_이진변환반복하기_dnjsxo0616 {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            int sLen = s.length();
            s = s.replaceAll("0", "");
            int countZ = sLen - s.length();
            answer[0]++;
            answer[1] += countZ;

            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}
