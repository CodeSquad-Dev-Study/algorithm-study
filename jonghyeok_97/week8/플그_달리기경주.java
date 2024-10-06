package jonghyeok_97.week8;

import java.util.HashMap;
import java.util.Map;

public class 플그_달리기경주 {

    public static void main(String[] args) {

    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        int index = 0;
        for (String player : players) {
            playerMap.put(player, index++);
        }

        for (String calling : callings) {
            int playerIndex = playerMap.get(calling);
            String beforePlayer = players[playerIndex - 1];

            playerMap.replace(calling, playerIndex - 1);
            playerMap.replace(beforePlayer, playerIndex);

            players[playerIndex] = beforePlayer;
            players[playerIndex - 1] = calling;
        }

        return players;
    }

}
