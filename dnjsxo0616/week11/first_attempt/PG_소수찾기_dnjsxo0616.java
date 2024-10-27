package dnjsxo0616.week11.first_attempt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PG_소수찾기_dnjsxo0616 {
    public Set<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        createNums("", numbers);
        int count = 0;
        Iterator<Integer> it = numbersSet.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num))
                count++;
        }

        return count;
    }

    public void createNums(String comb, String others) {
        if (!comb.equals("")) {
            numbersSet.add(Integer.valueOf(comb));
        }

        for (int i = 0; i < others.length(); i++) {
            createNums(comb + others.charAt(i),
                    others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        int limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
