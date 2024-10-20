package jonghyeok_97.week10;

public class 플그_붕대감기 {

        public int solution(int[] bandage, int health, int[][] attacks) {
            int maxHealth = health;

            for(int i = 0; i < attacks.length - 1; i++) {
                int attackTimeDiff = attacks[i + 1][0] - attacks[i][0] - 1;
                int damagedHealth = health - attacks[i][1];
                if(damagedHealth <= 0) {
                    return -1;
                }
                damagedHealth += attackTimeDiff * bandage[1];
                damagedHealth += attackTimeDiff / bandage[0] * bandage[2];
                health = Math.min(maxHealth, damagedHealth);
            }
            int resultHealth = health - attacks[attacks.length - 1][1];

            return resultHealth <= 0 ? -1 : resultHealth;
        }
}
