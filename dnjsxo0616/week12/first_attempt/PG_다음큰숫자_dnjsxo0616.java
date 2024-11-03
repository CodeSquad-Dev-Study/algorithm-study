package dnjsxo0616.week12.first_attempt;

public class PG_다음큰숫자_dnjsxo0616 {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        while(true) {
            n++;
            if(Integer.bitCount(n) == count) {
                return n;
            }
        }
    }
}
