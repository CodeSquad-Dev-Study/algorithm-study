package horanga.weeks11.first_attempt;

public class PG_카펫_horanga {

        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            for(int i =3; i<=brown; i++){
                for(int j=3; j<=i; j++){
                    if(i*j-yellow==brown && (i-2)*(j-2)==yellow){
                        answer[0]= i;
                        answer[1]= j;
                    }
                }
            }
            return answer;

        }
    }

