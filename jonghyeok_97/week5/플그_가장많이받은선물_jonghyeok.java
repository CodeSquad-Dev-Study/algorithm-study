package jonghyeok_97.week5;

import java.util.Arrays;

public class 플그_가장많이받은선물_jonghyeok {

    public int solution(String[] friends, String[] gifts) {
        int[] answers = new int[friends.length];
        System.out.println("abc abc".endsWith("bc"));
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String first = friends[i];
                String second = friends[j];

                int firstCount = 0;
                int secondCount = 0;

                int giftFirstScore = 0;
                int giftSecondScore = 0;

                // 두 사람이 선물을 주고 받는지 확인
                for (String gift : gifts) {
                    String[] names = gift.split(" ");
                    String firstName = names[0];
                    String secondName = names[1];

                    if (firstName.equals(first)) {
                        giftFirstScore++;
                    }
                    if (secondName.equals(first)) {
                        giftFirstScore--;
                    }
                    if (firstName.equals(second)) {
                        giftSecondScore++;
                    }
                    if (secondName.equals(second)) {
                        giftSecondScore--;
                    }
                    if (firstName.equals(first) && secondName.equals(second)) {

                        firstCount++;

                    }
                    if (secondName.equals(first) && firstName.equals(second)) {

                        secondCount++;

                    }
                    // if(gift.startsWith(first)) {
                    //     giftFirstScore++;
                    // }
                    // if(gift.endsWith(first)) {
                    //     giftFirstScore--;
                    // }
                    // if(gift.startsWith(second)) {
                    //     giftSecondScore++;
                    // }
                    // if(gift.endsWith(second)) {
                    //     giftSecondScore--;
                    // }
                    // if(gift.contains(first) && gift.contains(second)) {
                    //     if(gift.startsWith(first)) {
                    //         firstCount++;
                    //     } else {
                    //         secondCount++;
                    //     }
                    // }
                }

                // 선물 주고 받은 적 없거나 둘이 선물 주고 받은 횟수 같으면 선물지수 계산
                if ((firstCount == secondCount) || firstCount == 0 && secondCount == 0) {
                    if (giftFirstScore > giftSecondScore) {
                        answers[i]++;
                    } else if (giftFirstScore < giftSecondScore) {
                        answers[j]++;
                    }
                    continue;
                }

                if (firstCount > secondCount) {
                    answers[i]++;
                } else {
                    answers[j]++;
                }
            }
        }
        Arrays.sort(answers);
        System.out.println(Arrays.toString(answers));

        return answers[friends.length - 1];
    }

}
