package horanga.weeks13.first_attempt;
import java.util.*;
public class PG_단속카메라_horanga {

    public int solution(int[][] routes) {

        Arrays.sort(routes, (o1, o2)-> o1[1]-o2[1]);


        int cam = -300010;
        int answer = 0;
        for(int[] r : routes){
            if(cam < r[0]){
                cam = r[1];
                answer++;
            }
        }

        return answer;
    }
}
