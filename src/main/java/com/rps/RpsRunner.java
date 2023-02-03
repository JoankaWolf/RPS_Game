package com.rps;

public class RpsRunner {

    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.welcomeInfo();
        logic.chooseNumberOfRounds();
        logic.playGame();
    }
}
