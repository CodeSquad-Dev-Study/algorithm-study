package jonghyeok_97.week11;

public class 플그_n2배열자르기 {


        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int)(right - left) + 1];
            int cnt = 0;

            boolean ok = true;
            for(int i = (int)(left / n) + 1; i <= (int)(right/n) + 1; i++){
                for(int j = 1; j <= n; j++){
                    cnt++;
                    if(cnt <= (left % n)) continue;
                    if(cnt == (int)(right - left) + 1){
                        ok = false;
                        break;
                    }
                    answer[cnt-(int)(left%n)] = Math.max(i, j);

                }
                if(ok == false) break;
            }
            return answer;
        }
}
