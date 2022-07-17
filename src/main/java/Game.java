import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName) {
        Player p1 = null;
        Player p2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                p1 = player;
            }
            if (player.getName().equals(playerName2)) {
                p2 = player;
            }
        }
        if (p1 == null) {
            throw new NotFoundException("Игрок " + playerName1 + " не найден");
        }
        if (p2 == null) {
            throw new NotFoundException("Игрок " + playerName2 + " не найден");
        }
        if (p1.getStrength() == p2.getStrength()) {
            return 0;
        }
        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
