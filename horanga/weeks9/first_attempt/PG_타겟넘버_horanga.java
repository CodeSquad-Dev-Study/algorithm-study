package horanga.weeks9.first_attempt;

public class PG_타겟넘버_horanga {
        int count=0;

        public int solution(int[] numbers, int target) {
            bfs(numbers, 0, 0, target);

            return count;

        }

        public void bfs(int[] numbers, int depth, int sum, int target){

            if(depth== numbers.length){
                if(sum==target){
                    count++;
                    return;
                }
                return;
            }

            bfs(numbers, depth+1, sum+numbers[depth], target);
            bfs(numbers, depth+1, sum-numbers[depth], target);

        }

    }
