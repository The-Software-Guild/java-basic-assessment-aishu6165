/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */
 
 import java.util.*;
import java.util.Random;
public class RockPaperScissors {
    public static void main(String[] args) {
        wholegame();
        System.out.println("Do you want to play again? Please enter yes  or no");
        Scanner Userinput = new Scanner(System.in);
        String useragain= Userinput.nextLine();
         if (useragain.equals("no")){
            System.out.println("Thanks for playing!");
            return;
        }else{
            wholegame();
        }
    }


    public static void wholegame(){
        Scanner UserInput = new Scanner(System.in);
        System.out.println("How may rounds do you want to play? ");
        Integer rounds = UserInput.nextInt();
        if (rounds >= 1 && rounds <= 10) {
            int i = 0;
            int tie = 0;
            int compwin = 0;
            int userwin = 0;
            for (i = 0; i < rounds; i++) {
                String User = Userround();
                String computer = Computerround();
                String mr = mainresult(User, computer);
                if (mr == "tie"){
                    tie++;
                }else if (mr == "compwin"){
                    compwin++;
                }else if (mr == "userwin"){
                    userwin++;
                }
            }
            System.out.println("number of tied games: " + tie);
            System.out.println("number of games User won: " + userwin);
            System.out.println("number of games computer won: " + compwin);
            if (userwin > compwin) {
                System.out.println("User is the overall winner!!");
            } else {
                System.out.println("Computer is the over all winner");
            }
        } else {
            System.out.println("You have entered invalid number of plays!");
            System.exit(0);
        }
        
    }

    public static String Computerround() {
        Random randomizer = new Random();
        String compchoice = " ";
        int x = randomizer.nextInt(3) + 1;
        if (x == 1) {
            compchoice = "ROCK";
        } else if (x == 2) {
            compchoice = "PAPER";
        } else {
            compchoice = "SCISSORS";
        }
        System.out.println("computer's choice is: " + compchoice);
        return compchoice;
    }

    public static String Userround() {
        System.out.println("What is your choice? 1 = ROCK, 2 = PAPER, 3 = SCISSORS");
        Scanner UserInput = new Scanner(System.in);
        Integer input = UserInput.nextInt();
        String Userchoice = " ";
        if (input == 1) {
            Userchoice = "ROCK";
        } else if (input == 2) {
            Userchoice = "PAPER";
        } else if (input == 3) {
            Userchoice = "SCISSORS";
        }
        return Userchoice;
    }

    public static String mainresult(String Userchoice, String compchoice) {
        String result = " ";
        if (Userchoice.equals(compchoice)) {
            System.out.println("It's a tie!");
            result = "tie";
        }else {
            if (Userchoice == "ROCK" && compchoice == "SCISSORS") {
                System.out.println("You win!! Rock crushes scissors.");
                result = "userwin";
            } else if (Userchoice == "ROCK" && compchoice == "PAPER") {
                System.out.println("You lose!! Paper eats rock.");
                result = "compwin";
            } else if (Userchoice == "PAPER" && compchoice == "SCISSORS") {
                System.out.println("You lose!! Scissor cuts paper.");
                result = "compwin";
            } else if (Userchoice == "PAPER" && compchoice == "ROCK") {
                System.out.println("You win!! Paper eats rock.");
                result = "userwin";
            } else if (Userchoice == "SCISSORS" && compchoice == "ROCK") {
                System.out.println("You lose!! Rock breaks scissors.");
                result = "compwin";
            } else if (Userchoice == "SCISSORS" && compchoice == "PAPER") {
                System.out.println("You win!! Scissor cuts paper.");
                result = "userwin";
            }
        }return result;
    }
}

