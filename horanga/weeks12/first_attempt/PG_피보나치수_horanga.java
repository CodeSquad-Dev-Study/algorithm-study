package horanga.weeks12.first_attempt;

class PG_피보나치수_horanga {
    public int solution(int n) {
        int answer = fibo(n);
        System.out.println(answer);
        return answer;
    }

    public int fibo(int n) {
        int[] cache = new int[n+1];

        cache[0] = 0;
        cache[1] = 1;

        for (int i=2; i<= n; i++){

            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }

        return cache[n] % 1234567;
    }
}