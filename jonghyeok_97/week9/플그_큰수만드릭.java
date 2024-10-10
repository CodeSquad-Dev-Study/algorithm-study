package jonghyeok_97.week9;

import java.util.*;

class 플그_큰수만드릭 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int length = number.length() - k;  // 최종적으로 만들어야 할 숫자의 길이
        int start = 0; // 탐색 시작 지점
        int end = k; // 탐색 종료 지점

        while (length > 0) {
            char maxChar = '0'; // 최대 숫자를 저장할 변수
            int maxIndex = start; // 최대 숫자의 인덱스 저장할 변수

            // start부터 end까지 탐색하면서 최대값을 찾음
            for (int i = start; i <= end; i++) {
                if (number.charAt(i) > maxChar) {
                    maxChar = number.charAt(i);
                    maxIndex = i;
                }
            }

            // 최대값을 answer에 추가
            answer.append(maxChar);

            // 다음 탐색 범위 설정
            start = maxIndex + 1;
            end = number.length() - --length;
        }
        return answer.toString();
    }
}