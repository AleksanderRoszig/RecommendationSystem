package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<User> ListOfUsers = new ArrayList<User>(0);
        List<Data> ListOfBooks = new ArrayList<Data>(0);
        List<MemoryBased> ListOfData= new ArrayList<MemoryBased>(0);

        int choice;
        int n = 5; //number of features
        String inputS;
        double[] tab1 = new double[5];
        Scanner keyboard = new Scanner(System.in);
        int p = 5; //number of objects
        //  choice = keyboard.nextInt();
        System.out.println("----------MENU----------");
        System.out.println("1. Add user manually");
        System.out.println("2. Delete user");
        System.out.println("3. List of users");
        System.out.println("4. Compare users");
        System.out.println("5. Your profile");
        switch (5) {
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
                boolean endingchoice;
                do {
                    endingchoice = false;
                    System.out.println("Your name: ");
                    inputS = keyboard.next();
                    for (int i = 0; i < n - 1; i++) {
                        System.out.println("Your preferences 1-10");
                        for (i = 0; i < n; i++) {
                            switch (i) {
                                case 1:
                                    System.out.println("Do you like horrors?");
                                    tab1[i] = keyboard.nextInt();
                                    break;
                                case 2:
                                    System.out.println("Do you like sci-fi?");
                                    tab1[i] = keyboard.nextInt();
                                    break;
                                case 3:
                                    System.out.println("Do you like philosophy?");
                                    tab1[i] = keyboard.nextInt();
                                    break;
                                case 4:
                                    System.out.println("Do you like fantasy?");
                                    tab1[i] = keyboard.nextInt();
                                    break;
                                case 5:
                                    System.out.println("Do you like thriller?");
                                    tab1[i] = keyboard.nextInt();
                                    break;
                            }
                        }
                    }
                    User user = new User(inputS, tab1);
                    System.out.println(user.toString()); // user name output from User class, for tests
                    //random objects for test
                    double[] tablica1 = new double[n];
                    for (p = 0; p < 5; p++) {
                        Data objname2 = new Data("Harry Potter", tablica1);
                        ListOfBooks.add(p,objname2);
                        objname2.ForArray(user.copiedUser);


                    }
                    /* double [] tablica1  = {0,10,10,10,10,10};
                    Data objname2 = new Data("book1", tablica1);
                    objname2.ForArray(user.copiedUser);
                    objname2.Start(objname2);
                    */
                    for(p = 0; p < 5; p++){
                        ListOfBooks.get(p).calcCosin();
                    }

                    List<Data> ListOfSortedBooks = ListOfBooks.stream().sorted(Comparator.comparing(e->e.dUD)).collect(Collectors.toList());

                    for(p = 0; p < 5; p++){
                        System.out.println(ListOfSortedBooks.get(p).copiedData[0] + "     Sorted");
                    }

                    System.out.println("Do you want make calculations again?");
                    System.out.println("Y or N");
                    boolean goodletters;
                    do {
                        goodletters = true;
                        inputS = keyboard.next();
                        if (inputS.charAt(0) == 'Y' || inputS.charAt(0) == 'y') {
                            endingchoice = true;
                        } else if (inputS.charAt(0) == 'N' || inputS.charAt(0) == 'n') {
                            endingchoice = false;
                        } else {
                            System.out.println("Please type Y or N");
                            goodletters = false;
                        }
                    } while (goodletters == false);

                } while (endingchoice == true);
                break;
        }
    }
}

