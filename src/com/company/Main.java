package com.company;

import java.util.*;

import java.util.Arrays;
import java.util.Comparator;


public class Main {


    public static void main(String[] args) {
        int n = 10; //number of features
        int i; //for loops
        boolean endingchoice;
        boolean goodchar;
        int choice;
        String inputS;
        Scanner keyboard = new Scanner(System.in);
        //  choice = keyboard.nextInt();


        double[][] userInputArray = new double[11][n + 1];

        //I started from 1 because 0,0 thats dUD calculated for our user
        double[][] dataBaseOfBooks = new double[][]{
                //0  1  2  3  4  5  6  7  8  9 10
                {0, 10, 5, 4, 0, 8, 0, 0, 0, 0, 0},  //horror
                {0, 0, 2, 3, 0, 4, 0, 7, 0, 0, 0},
                {0, 2, 8, 0, 4, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 0, 9, 7, 4, 10}, //youtubemovie
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 5, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0}, //gym movie
                {0, 0, 2, 0, 3, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        double[][] dataBaseOfUsers = new double[][]{
                //[] ID of User [] rate of products
                //0  1  2  3  4  5  6  7  8  9 10
                {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 3, 0, 4, 0, 7, 0, 0, 0},
                {0, 0, 8, 0, 4, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 0, 9, 7, 4, 10},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 5, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0},
                {0, 0, 2, 0, 3, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        System.out.println("----------MENU----------");
        System.out.println("1. Memory-based Collaborative Filtering");
        System.out.println("2. Content-based Filtering.");
        switch (1) {
            case 1: //Memory-based Collaborative Filtering
                do {
                    System.out.println("Your name: ");
                    inputS = keyboard.next();
                    System.out.println("Your preferences 1-10");
                    for (i = 1; i < n + 1; i++) {
                        switch (i) {
                            case 1:
                                System.out.println("Do you like chair?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 2:
                                System.out.println("Do you like table?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 3:
                                System.out.println("Do you like computer?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 4:
                                System.out.println("Do you like fantasy?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 5:
                                System.out.println("Do you like thriller?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 6:
                                System.out.println("Do you like history?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 7:
                                System.out.println("Do you like cats?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 8:
                                System.out.println("Do you like puppies?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 9:
                                System.out.println("Do you like gym?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                            case 10:
                                System.out.println("Do you like YouTube?");
                                userInputArray[i][0] = keyboard.nextInt();
                                break;
                        }
                    }

                    MemoryBased test1 = new MemoryBased(userInputArray, dataBaseOfUsers);

                    endingchoice = false;
                    do {
                        goodchar = true;
                        inputS = keyboard.next();
                        if (inputS.charAt(0) == 'Y' || inputS.charAt(0) == 'y') {
                            endingchoice = true;
                        } else if (inputS.charAt(0) == 'N' || inputS.charAt(0) == 'n') {
                            endingchoice = false;
                        } else {
                            System.out.println("Please type Y or N");
                            goodchar = false;
                        }
                    } while (goodchar == false);
                } while (endingchoice == true);
                break;
            //
            case 2: //Content-based Filtering.
                do {
                    System.out.println("Your name: ");
                    inputS = keyboard.next();
                    System.out.println("Your preferences 1-10");
                    for (i = 1; i < n + 1; i++) {
                        switch (i) {
                            case 1:
                                System.out.println("Do you like horrors?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 2:
                                System.out.println("Do you like sci-fi?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 3:
                                System.out.println("Do you like philosophy?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 4:
                                System.out.println("Do you like fantasy?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 5:
                                System.out.println("Do you like thriller?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 6:
                                System.out.println("Do you like history?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 7:
                                System.out.println("Do you like cats?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 8:
                                System.out.println("Do you like puppies?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 9:
                                System.out.println("Do you like gym?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                            case 10:
                                System.out.println("Do you like YouTube?");
                                userInputArray[0][i] = keyboard.nextInt();
                                break;
                        }
                    }
                    User user = new User(inputS, userInputArray);
                    ContentBased test = new ContentBased(userInputArray, dataBaseOfBooks);
                    //todo products
                    test.bubbleSort(dataBaseOfBooks);
                    for (i = 0; i < dataBaseOfBooks.length; i++) {
                        System.out.println(dataBaseOfBooks[i][0] + "  :dUD sorted");
                    }
                    System.out.println("Do you want make calculations again?");
                    System.out.println("Y or N");


                    endingchoice = false;
                    do {
                        goodchar = true;
                        inputS = keyboard.next();
                        if (inputS.charAt(0) == 'Y' || inputS.charAt(0) == 'y') {
                            endingchoice = true;
                        } else if (inputS.charAt(0) == 'N' || inputS.charAt(0) == 'n') {
                            endingchoice = false;
                        } else {
                            System.out.println("Please type Y or N");
                            goodchar = false;
                        }
                    } while (goodchar == false);

                } while (endingchoice == true);

                break;
        }
    }
}

