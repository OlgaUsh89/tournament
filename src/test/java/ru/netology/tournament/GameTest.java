package ru.netology.tournament;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class GameTest {
    @Test
    public void whenFirstPlayerWin() {
        Player Nina = new Player(1, "Нина", 100);
        Player Olya = new Player(2, "Оля", 80);

        Game game = new Game();

        game.register(Nina);
        game.register(Olya);

        int actual = game.round("Нина", "Оля");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenSecondPlayerWin() {
        Player Nina = new Player(1, "Нина", 100);
        Player Olya = new Player(2, "Оля", 120);

        Game game = new Game();

        game.register(Nina);
        game.register(Olya);

        int actual = game.round("Оля","Нина");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenDraw() {
        Player Nina = new Player(1, "Нина", 120);
        Player Olya = new Player(2, "Оля", 120);

        Game game = new Game();

        game.register(Nina);
        game.register(Olya);

        int actual = game.round("Оля","Нина");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player Nina = new Player(1, "Нина", 100);
        Player Olya = new Player(2, "Оля", 80);

        Game game = new Game();

        game.register(Nina);
        game.register(Olya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Света", "Оля")
        );
    }
    @Test
    public void whenSecondPlayerNotExist() {
        Player Nina = new Player(1, "Нина", 100);
        Player Olya = new Player(2, "Оля", 80);

        Game game = new Game();

        game.register(Nina);
        game.register(Olya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Нина", "Алина")
        );
    }

}
