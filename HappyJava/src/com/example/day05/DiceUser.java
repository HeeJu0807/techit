package com.example.day05;

public class DiceUser {

    public static int diceGame(Dice dice, int totalCount, int eye){
        int count = 0;
        for(int i = 0 ; i< 100 ; i++){
            dice.roll();
            if(dice.eye == eye){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Dice dice = new Dice();
    //    dice.roll();
    //    System.out.println(dice.eye);
        int totalCount = 100;
        int eye = 3;
        int count = diceGame(dice, 100, 3);
        System.out.println("주사위를 " + totalCount + "번 던져서 " +eye +"는 " + count + "번 나왔습니다.");
    }
}
