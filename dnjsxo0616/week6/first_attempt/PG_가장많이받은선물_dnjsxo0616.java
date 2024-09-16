package dnjsxo0616.week6.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_가장많이받은선물_dnjsxo0616 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> fIndex = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            fIndex.put(friends[i], i);
        }

        int[] giftPoint = new int[friends.length];
        int[][] check = new int[friends.length][friends.length];

        // 각 선물을 주고 받은 for문을 작성하고 앞 사람 +1 뒷 사람 -1 이렇게
        for(String gift : gifts) {
            String[] g = gift.split(" ");
            giftPoint[fIndex.get(g[0])]++;
            giftPoint[fIndex.get(g[1])]--;
            check[fIndex.get(g[0])][fIndex.get(g[1])]++;
        }

        for(int i=0; i<friends.length; i++) {
            int n = 0;
            for(int j=0; j<friends.length; j++) {
                if(i == j) {
                    continue;
                }

                if(check[i][j] > check[j][i] || check[i][j] == check[j][i] && giftPoint[i] > giftPoint[j]) {
                    n++;
                }
            }
            if(answer < n) {
                answer = n;
            }
        }
        return answer;
    }
}
