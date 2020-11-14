/*
Title: OOP3200Java-ASasi-JYuan-Lab1
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: November 13 2020
Changes: N/A
 */
package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //define scanner
        Scanner keyboard = new Scanner(System.in);

        //Variables
        final int numGames =2;
        int scoreInput = 0;
        double average = 0.0;
        String[] playerNames = {"Jacky", "Ashok", "Tom"};
        int[][] score = new int[numGames][3];
        double tmpSum = 0.0;
        boolean isValid = false;

//INPUT SECTION
        //loop through the 2d array
        for (int i = 0; i < numGames; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                while (!isValid)
                {
                    try
                    {
                        System.out.print("Please enter " + playerNames[j] + "'s score for GAME #" + (i + 1) + ": ");

                        //receive user input for score
                        scoreInput = keyboard.nextInt();

                        //run if score is within bounds
                        if (scoreInput >= 0 && scoreInput <= 300)
                        {
                            //add input to array
                            score[i][j] = scoreInput;
                            isValid = true;
                        }
                        else
                        {
                            //output error message if input out of bounds
                            System.out.println("Invalid input - Score must be between 0 and 300 please try again.\n");
                            isValid = false;
                        }
                    }
                    //catch if input is not an int
                    catch (InputMismatchException e)
                    {
                        //output error message
                        System.out.println("Error: You must enter a valid integer number.\n");
                        keyboard.nextLine();
                        isValid = false;
                    }

                }
                isValid = false;
            }
        }


//OUTPUT SECTION
        System.out.println();
        //loop thorough the 2D array
        for (int k = 0; k < 3; k++)
        {
            System.out.println("Score Details for " + playerNames[k] + ":");
            for (int l = 0; l < numGames; l++)
            {
                //output the player score
                System.out.println("Game # " + (l + 1) + ":" + "\t" + score[l][k]);
                //add the score to a temporary sum variable
                tmpSum += score[l][k];
            }
            //calculate the average for each player
            average = tmpSum / numGames;
            //reset tmpSum variable
            tmpSum = 0.0;
            //output the average for each player
            System.out.println("Average for " + playerNames[k] + ": " + average);
            System.out.println();
        }

    }
}
