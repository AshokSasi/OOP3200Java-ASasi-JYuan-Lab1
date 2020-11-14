package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //define scanner
        Scanner keyboard = new Scanner(System.in);

        //Variables
        int scoreInput=0;
        double average =0.0;
        String [] playerNames  = {"Jacky", "Ashok", "Tom"};
        int [][] score = new int [2][3];
        double tmpSum=0.0;
        boolean isValid = false;

//INPUT SECTION
                for (int i=0; i<2; i++)
                {

                    for (int j=0; j<3; j++)
                    {

                        while(!isValid)
                        {
                            try
                            {
                                System.out.print("Please enter " +  playerNames[j] + "'s score for GAME #" + (i+1) + ": ");

                                scoreInput = keyboard.nextInt();
                                if (scoreInput>=0 && scoreInput <= 300)
                                {

                                    score[i][j]= scoreInput;
                                    isValid=true;
                                }
                                else
                                {
                                    System.out.println("Invalid input - Score must be between 0 and 300 please try again.\n");
                                    isValid=false;
                                }
                            }
                            catch(InputMismatchException e)
                            {
                                System.out.println("Error: You must enter a valid integer number.\n");
                                keyboard.nextLine();
                                isValid=false;
                            }

                        }
                      isValid=false;
                    }
                }


//OUTPUT SECTION
        System.out.println();
        for (int k=0; k<3; k++)
        {
            System.out.println("Score Details for " + playerNames[k] + ":");
            for (int l=0; l<2; l++)
            {

                System.out.println("Game # " + (l+1) + ":" + "\t" + score[l][k]);

                tmpSum += score[l][k];
            }
            average = tmpSum/2;
            tmpSum=0.0;
            System.out.println("Average for " + playerNames[k] + ": " + average);
            System.out.println();
        }

    }
}
