package jonghyeok_97.week10;

import java.util.HashMap;
import java.util.Map;

public class 플그_공원산책 {

    public int[] solution(String[] park, String[] routes) {
        String[][] parks = new String[park.length][park[0].length()];

        int y = 0;
        int x = 0;
        for (int i = 0; i < park.length; i++) {
            parks[i] = park[i].split("");
            if (park[i].contains("S")) {
                y = i;
                x = park[i].indexOf("S");
            }
        }

        Map<String, int[]> directMap = new HashMap<>();
        directMap.put("E", new int[]{0, 1});
        directMap.put("S", new int[]{1, 0});
        directMap.put("W", new int[]{0, -1});
        directMap.put("N", new int[]{-1, 0});

        for (String s : routes) {
            String[] route = s.split(" ");
            int[] direct = directMap.get(route[0]);
            boolean flag = false;
            int ny = y;
            int nx = x;
            for (int j = 0; j < Integer.parseInt(route[1]); j++) {
                ny += direct[0];
                nx += direct[1];
                if (ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length()) {
                    flag = true;
                    break;
                }
                if (parks[ny][nx].equals("X")) {
                    flag = true;
                    break;
                }

            }
            if (flag) {
                continue;
            }
            y = ny;
            x = nx;
        }
        return new int[]{y, x};
    }
}
