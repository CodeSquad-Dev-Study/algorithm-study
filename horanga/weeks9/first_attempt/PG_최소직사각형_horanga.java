package horanga.weeks9.first_attempt;

public class PG_최소직사각형_horanga {

    public int solution(int[][] sizes) {

        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            maxRow = Math.max(maxRow, sizes[i][0]);
            maxCol = Math.max(maxCol, sizes[i][1]);
        }

        return maxRow * maxCol;
    }
}
