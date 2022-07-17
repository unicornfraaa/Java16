import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    List<Player> players = new ArrayList<>();
    Game game = new Game();

    Player p1 = new Player(1, "p1", 50);
    Player p2 = new Player(2, "p2", 100);
    Player p3 = new Player(3, "p3", 150);
    Player p4 = new Player(4,"p4", 50);

    @Test
    public void playerRegistration() {
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        int actual = players.size();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void roundNoWin() throws NotFoundException {

        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);

        int expected = 0;
        int actual = game.round("p1", "p4");
        assertEquals(expected, actual);
    }

    @Test
    public void roundWinPlayer2() throws NotFoundException {
        game.register(p1);
        game.register(p2);

        int expected = 2;
        int actual = game.round("p1", "p2");
        assertEquals(expected, actual);
    }

    @Test
    public void roundWinPlayer3() throws NotFoundException {
        game.register(p3);
        game.register(p4);

        int expected = 1;
        int actual = game.round("p3","p4");
        assertEquals(expected, actual);
    }

    @Test
    void roundReturnsException() throws NotFoundException {
        game.register(p3);
        game.register(p4);

        assertThrows(NotFoundException.class, () -> game.round("p1","p2"));
    }

    @Test
    public void registered() throws NotFoundException {
        game.register(p1);
        game.register(p2);

        boolean actual = game.matches("p1");
        boolean expected = true;

        assertTrue (game.matches("p1"));
    }
    @Test
    public void notRegistered() throws NotFoundException {

        boolean expected = false;

        assertFalse (game.matches("p3"));
    }

    @Test
    public void exceptionP1() throws NotFoundException {
        game.register(p2);
        game.register(p3);

        boolean expected = false;

        assertFalse (game.matches("p1"));
    }

//    @Test
//    public void exceptionP2() throws NotFoundException {
//        game.register(p3);
//        game.register(p4);
//
//        boolean expected = false;
//
//        assertTrue (game.matches("p1"));
//    }

//    @Test
//    void exceptionP2() throws NotFoundException {
//        game.register(p3);
//        game.register(p4);
//
//        assertThrows(NotFoundException.class, () -> game.round("p2","p3"));
//    }

    @Test
    public void exceptionP2() throws NotFoundException {
        game.register(p1);
        game.register(p3);

        assertThrows(NotFoundException.class, () -> game.round("p1","p2"));
    }

//    @Test
//    public void registered() throws NotFoundException {
//        game.register(p1);
//        game.register(p2);
//
//        boolean actual = game.matches("p1");
//        boolean expected = true;
//
//        assertTrue (game.matches("p1"));
//    }
}
