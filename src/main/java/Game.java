import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public boolean matches(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int round(String playerName1, String playerName2) throws NotFoundException {

        int p1 = 0;
        int p2 = 0;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                p1 = player.getStrength();
            }
            if (player.getName().equals(playerName2)) {
                p2 = player.getStrength();
            }
        }

//        if (!matches(playerName1) || !matches(playerName2)) {
//            throw new NotFoundException("Один из игроков не найден");
//        }

        if (p1 == 0) {
            throw new NotFoundException("Игрок " + playerName1 + " не найден");
        }
//        if(p1 == 0 || p2 == 0) {

        if (p2 == 0) {
            throw new NotFoundException("Игрок " + playerName2 + " не найден");
        }
        if (p1 == p2) {
            System.out.println(0 + " Ничья");
            return 0;
        }
        if (p1 > p2) {
            System.out.println(1 + " Победа первого игрока");
            return 1;
        } else {
            System.out.println(2 + " Победа второго игрока");
            return 2;
        }
    }
}
