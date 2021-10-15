package co.com.devmont.javatestingcourse.game;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void playerLoseWhenDiceIsToLow() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }
    @Test
    public void playerWinWhenDiceIsBiggerThanMinToWin() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);
        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}