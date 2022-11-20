package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BowlingTest {

    private Bowling game;
    @Before
    public void setUp(){
        game = new Bowling();
    }

    @Test
    public void score_returnsZero_ifAllTheThrowsAreZero(){
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(0,game.score());
    }

    @Test
    public void score_returnsTwenty_ifScoredSpareThenFive(){
        game.roll(5,5, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(20,game.score());
    }

    @Test
    public void score_returnsTwentyFour_ifScoredStrikeThenThreeThenFour(){
        game.roll(10, 3,4, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(24,game.score());
    }

    @Test
    public void score_returnsThreeHundred_ifScoredPerfectGame(){
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertEquals(300, game.score());
    }

    @Test
    public void score_returnsFourteen_ifScoredThreeThenSixThenFive(){
        game.roll(3,6, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(14, game.score());
    }

    @Test (expected = IllegalArgumentException.class)
    public void roll_throwsException_ifMoreThanTenPinsKnocked(){
        game.roll(11,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void roll_throwsException_ifLessThanZeroPinsKnocked(){
        game.roll(-3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
    }


}
