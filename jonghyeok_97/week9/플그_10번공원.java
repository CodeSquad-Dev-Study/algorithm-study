package jonghyeok_97.week9;

import java.util.Arrays;

public class 플그_10번공원 {

    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);

        for (int i = mats.length - 1; i >= 0; i--) {
            int place = mats[i];
            for (int j = 0; j < park.length; j++) {
                for (int k = 0; k < park[0].length; k++) {
                    if (!"-1".equals(park[j][k])) {
                        continue;
                    }
                    if (canUse(park, j, k, place)) {
                        return place;
                    }
                }
            }
        }
        return -1;
    }

    //                                  .      0     2       5
    private boolean canUse(String[][] park, int y, int x, int place) {
        int yLength = park.length; // 6
        int xLength = park[0].length; // 8

        int yMaxIndex = y + place - 1; // 4
        int xMaxIndex = x + place - 1; // 6
        if (yMaxIndex > yLength - 1) {
            return false;
        }
        if (xMaxIndex > xLength - 1) {
            return false;
        }

        for (int i = y; i < y + place; i++) {
            for (int j = x; j < x + place; j++) {
                if (!"-1".equals(park[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
