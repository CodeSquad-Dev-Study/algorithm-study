package horanga.weeks9.first_attempt;

public class PG_키패드누르기_horanga {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = new int[3][4];

        for(int i =0; i<3; i++){
            for(int j =0; j<4; j++){
                keypad[i][j] = (i+1)+3*j;
            }
        }
        keypad[0][3] =1000;
        keypad[1][3] =0;
        keypad[2][3] =1001;

        StringBuilder sb = new StringBuilder();

        int lCur = 1000;
        int rCur = 1001;

        for(int i =0; i<numbers.length ; i++){
            int num = numbers[i];
            if(num == keypad[0][0] || num == keypad[0][1] || num == keypad[0][2]){
                sb.append("L");
                lCur = num;
            } else if (num == keypad[2][0] || num == keypad[2][1] || num == keypad[2][2]){
                sb.append("R");
                rCur = num;
            } else{

                int leftDistance = getDistance(lCur, num, keypad);
                int rightDistance = getDistance(rCur, num, keypad);

                if(leftDistance<rightDistance){
                    System.out.println(i);
                    sb.append("L");
                    lCur = num;
                } else if(leftDistance>rightDistance){
                    sb.append("R");
                    rCur = num;

                } else if(hand.equals("right")){
                    sb.append("R");
                    rCur = num;
                } else{
                    sb.append("L");
                    lCur = num;
                }

            }
        }
        return sb.toString();
    }

    private int getDistance(int cur, int target, int[][] keypad){
        int targetJ = 0;
        int targetI=0;
        int curJ =0;
        int curI =0;

        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(keypad[i][j] == target){
                    targetJ = j;
                    targetI= i;
                }

                if(keypad[i][j] ==cur){
                    curJ = j;
                    curI = i;
                }
            }
        }

        int iDistance = targetI>curI? targetI-curI : curI- targetI;
        int jDistance = targetJ>curJ? targetJ-curJ : curJ- targetJ;

        return iDistance + jDistance;
    }
}
