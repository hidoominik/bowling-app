package org.example;

public class Bowling {
    public static void main(String[] args) {
        System.out.println("Let's go bowling!");
    }

    private int roll = 0;
    private int[] rollsList = new int[21];
    public void rollTheBall(int knockedPins) {
        rollsList[roll++] = knockedPins;
    }

    public void roll(int... rolls){
        for (int knockedPins : rolls){
            if(knockedPins < 0 || knockedPins > 10){
                throw new IllegalArgumentException("Bad number of knocked pins!");
            }
            rollTheBall(knockedPins);
        }
    }
    private boolean isSpare(int cursor){
        return  rollsList[cursor] + rollsList[cursor + 1] == 10;
    }
    private boolean isStrike(int cursor){
        return rollsList[cursor] == 10;
    }
    public int score() {
        int score = 0;
        int cursor = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isSpare(cursor)){ //Spare = 10pins knocked in 2 throws
                score += 10 + rollsList[cursor+2];
                cursor += 2;
            } else if(isStrike(cursor)){ // Strike = 10pins knocked in 1 throw
                score  += 10 + rollsList[cursor + 1] + rollsList[cursor + 2];
                cursor++;
            }else{
                score += rollsList[cursor] + rollsList[cursor + 1];
                cursor += 2;
            }

        }

        return score;
    }
}