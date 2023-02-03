package com.rps;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Logic {

    Scanner scanner = new Scanner(in);
    public int numbersOfRounds;
    Scissors scissors = new Scissors();
    Rock rock = new Rock();
    Paper paper = new Paper();
    private String endOrNewGame;
    private int playerIsWinner;
    private int computerIsWinner;



    public void welcomeInfo() {
        numbersOfRounds = 0;

        out.println("Welcome in New Game Please enter Your name: ");
        String playerName = scanner.nextLine();
        if (!(playerName.isEmpty())) {
            out.println("Hello " + playerName + " Choose the number of rounds from 1 to 10 to find the Winner:");
        }
        else {
            out.println("You need to enter Your name!");
            welcomeInfo();
        }
    }

    public int chooseNumberOfRounds() {

        String numbersRound = scanner.nextLine();
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        if (numbers.contains(numbersRound)) {
            out.println("You have to play " + numbersRound + " times to find a Winner");
        } else {
            numbersRound = "5";
            System.err.println("Wrong number!, I choose for YOU, now You have to pay 5 rounds!");
        }
        return numbersOfRounds = Integer.parseInt(numbersRound);
    }



    public void choseMove(){

        out.println("Chose Your move: ");
        final Shape shape = playerMoveName();
        out.println(shape);
        Wait.wait(1);
        final Shape computerShape = computerMoveName();
        out.println(computerShape);
        Wait.wait(1);

        if (shape.equals(computerShape)) {
            out.println("The Round is Tied");
        }
        else if (shape.equals(rock) && computerShape.equals(scissors) || shape.equals(paper) && computerShape.equals(rock)
                || shape.equals(scissors) && computerShape.equals(paper)) {
            out.println("You Won!");
            playerIsWinner++;
        }
        else if (computerShape.equals(rock) && shape.equals(scissors) || computerShape.equals(paper) && shape.equals(rock)
                || computerShape.equals(scissors) && shape.equals(paper)) {
            out.println("Computer Won!");
            computerIsWinner++;
        }
    }


    public void playGame(){
        out.println("To make a move: \nPress 1 to choose rock. " +
                "\nPress 2 to choose paper. \nPress 3 to choose scissors." +
                "\\nTo quit the game press X or press N to play again.");
        int roundNumber = 0;

        while (roundNumber<numbersOfRounds) {
            out.println("Round: " + (roundNumber + 1));
            roundNumber++;
            choseMove();

            out.println("The number of your wins: " + playerIsWinner + "\nThe number of computer wins: " + computerIsWinner);
        }
        if (playerIsWinner > computerIsWinner) {
            System.out.println("Congratulations!" + "\nYOU ARE THE WINNER OF THE GAME!" +
                    "\nTo quit the game press X, \nPress N to play again.");
        } if (playerIsWinner == computerIsWinner) {
            System.out.println("The Game is Tied" + "\nTo quit the game press X, \nPress N to play again.");
        } if (playerIsWinner < computerIsWinner) {
            System.out.println("Computer Won! \nTo quit the game press X, \nPress N to play again.");
        }
        endOrNot();
    }

    void endOrNot() {
        endOrNewGame=scanner.nextLine();
        if (endOrNewGame.equals("x") || endOrNewGame.equals("X")) {
            checkEndOrNewGame();
        }
        else if (endOrNewGame.equals("n") || endOrNewGame.equals("N")) {
            checkStartNewGame();
        }
        else {
            out.println("Wrong choice!, Goodbye!");
            System.exit(0);
        }
    }

       public Shape playerMoveName() {
           String playerMove = scanner.nextLine();
           switch (playerMove) {
               case "1":
                   return rock;

               case "2":
                   return paper;

               case "3":
                   return scissors;

               case "n":
               case "N":
                   checkStartNewGame();
                   break;
               case "x":
               case "X":
                   checkEndOrNewGame();
                   break;
               default:
                   out.println("Wrong choice, I choose for YOU!");
                   Wait.wait(1);
                   break;
           }
           return paper;
       }

    public Shape computerMoveName() {
        int computerChoice = (int) (Math.random()*3);
        if (computerChoice == 1) {
            return rock;
        } else if (computerChoice == 2) {
            return paper;
        } else {
            return scissors;
        }
    }

    public void checkStartNewGame(){
        out.println("Start New Game? Y/N");
        endOrNewGame = scanner.nextLine();
        if (endOrNewGame.equals("y")|| endOrNewGame.equals("Y")){
            welcomeInfo();
            chooseNumberOfRounds();
            playGame();
        } else if(endOrNewGame.equals("n") || endOrNewGame.equals("N")) {
            out.println("Goodbye!");
            System.exit(0);
        }
    }

    public void checkEndOrNewGame(){
        out.println("End The Game end exit? Y/N");
        endOrNewGame = scanner.nextLine();
        if (endOrNewGame.equals("n")|| endOrNewGame.equals("N")){
            welcomeInfo();
            chooseNumberOfRounds();
            playGame();
        } else if(endOrNewGame.equals("y") || endOrNewGame.equals("Y")) {
            out.println("Goodbye!");
            System.exit(0);
        }
    }
}