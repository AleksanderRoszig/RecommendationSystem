package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<User> ListOfUsers = new ArrayList<User>();
        ArrayList<Data> ListOfBooks =  new ArrayList<Data>(0);
        int choice;
        int n = 5; //number of features
        String inputS;
        int [] tab1 = new int[5];
        Scanner keyboard = new Scanner(System.in);
        int p = 5; //number of objects
        //  choice = keyboard.nextInt();

        System.out.println("----------MENU----------");
        System.out.println("1. Add user manually");
        System.out.println("2. Delete user");
        System.out.println("3. List of users");
        System.out.println("4. Settings");
        System.out.println("5. Compare users");
        System.out.println("6. Your profile");
        switch (6) {
            case 1:
                System.out.println("Name: ");
                for (int i = 0; i < ListOfUsers.size() - 1; i++) {
                    System.out.println(ListOfUsers.get(i).toString());
                }
                break;
            case 2:
                break;
            case 3:
                for (int i = 0; i < ListOfUsers.size() - 1; i++) {
                    System.out.println(ListOfUsers.get(i).toString());
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Your name: ");
                inputS = keyboard.nextLine();
                for (int i = 0; i < n - 1; i++) {
                    System.out.println("Your preferences 1-10");
                    for (i = 0; i < n; i++) {
                        switch (i) {
                            case 1:
                                System.out.println("Do you like books?");
                                tab1[i] = keyboard.nextInt();
                                break;
                            case 2:
                                System.out.println("Do you like cinema?");
                                tab1[i] = keyboard.nextInt();
                                break;
                            case 3:
                                System.out.println("Do you like movies?");
                                tab1[i] = keyboard.nextInt();
                                break;
                            case 4:
                                System.out.println("Do you like money?");
                                tab1[i] = keyboard.nextInt();
                                break;
                            case 5:
                                System.out.println("Do you like food?");
                                tab1[i] = keyboard.nextInt();
                                break;
                        }
                    }

                }

                User user = new User(inputS, tab1);


                Random r = new Random(); //for random generating features of sites/books etc.
                System.out.println(user.toString()); // user name output from User class, for tests

                //random objects for test
                int[] tablica1 = new int[n];

                for (p = 0; p < 5; p++) {
                    Data objname2 = new Data(tablica1);
                    ListOfBooks.add(p,objname2);
                objname2.ForArray(user.copiedUser);
                }

                break;

        }
        for(p = 0; p < 5; p++){
            ListOfBooks.get(p).recAlgo();
        }


    }
}
