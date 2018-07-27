package com.company;

import java.util.List;
import java.util.Random;

//Memory-based Collaborative Filtering
public class MemoryBased {
    //Pearson correlation coefficient
    private int ID; //article id
    double Wpk; //Pearson correlation coefficient between user P and user K
    double norWPK; //Normalized Pearson correlaction
    double bestarticles; //coefficient that tells an iteam can be liked by user P
    int sumrates = 0;
    private double counter;
    private double denominator;
    private double sumA = 0;
    private double sumDA = 0;
    private double sumB = 0;
    private double sumDB = 0;
    private double averageRatingInputP;
    private double averageRatingInputK;
    private double userRatingSumP = 0;
    private double userRatingSumK = 0;
    //1 User, 2 User rating
    private int n = 5; //number of Users
    private int m = 5; //number of rated Articles
    private int f = 0; //user P chosen to make calculations
    private int z = 1; //other users, its user K
    int[][] copiedarray = new int[n][m];
    Random r = new Random();
    double[][] userParray = new double[1][5];
    //private List<Integer> ListOfRates = new List<Integer>(0);
    int[] arrayofrates = new int[100];
    //todo user P array with and without rating
    //constructor for users array with random values
    public MemoryBased(String ArticleName, int[][] UsersInputs) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                UsersInputs[i][j] = r.nextInt(10) + 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                copiedarray[k][j] = UsersInputs[k][j];
            }
            System.out.println(copiedarray[z][k]);
        }
        System.out.println("\n");
        //second array its rate of user P
        userParray[0][0] = 2;
        userParray[0][1] = 3;
        userParray[0][2] = 3;
        userParray[0][3] = 4;
        userParray[0][4] = 10;
    }

    public void calcPearson() {
        for (int i = 0; i < m; i++) {
            userRatingSumP = userRatingSumP + userParray[0][i];
            userRatingSumK = userRatingSumK + copiedarray[z][i];
            System.out.println(copiedarray[z][i] + " calcpearson");
        }
        System.out.println("\n");
        averageRatingInputP = (userRatingSumP / m);
        averageRatingInputK = (userRatingSumK / m);
        //sumA = left side of counter, sumB = right side of counter
        for (int i = 0; i < m; i++) {
            sumA = sumA + (userParray[0][i] - averageRatingInputP);
            sumB = sumB + (copiedarray[z][i] - averageRatingInputK);
        }
        counter = sumA * sumB;
        for (int i = 0; i < m; i++) {
            sumDA = sumDA + Math.sqrt(Math.pow(userParray[0][i] - averageRatingInputP, 2));
            sumDB = sumDB + Math.sqrt(Math.pow(copiedarray[z][i] - averageRatingInputP, 2));
        }
        denominator = sumDA * sumDB;
        Wpk = counter / denominator;
        normalization();
    }

    //emphasizing the difference in Pearson coefficient between User P and oth er users
    private void normalization() {
        int q = 2; //this parameter specifies how much should be emphasized difference
        norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
       // System.out.println(norWPK + " test1");
    }

    // X = set of user who rate aritcle I, xeX, X=/P,
    // z = average rate of all articles rated by user x
    // E xeX,(Bx,i - z)
    public void calcB() {
        sumrates = (sumrates + getnormRates());
        arrayofrates[0] = arrayofrates[0] + sumrates;
        System.out.println(arrayofrates[0] + "ratesum");

    }

    private int getnormRates() {
        int summa = 0;
        for(int i = 0; i < n; i++) {
            System.out.println(copiedarray[1][i] + " test getnorm");
            summa = summa + copiedarray[z][i];
        }
        return summa;
    }

    public void calcBest() {
        double counter = 0;
        double denominator = 0;
        double averagerateusrz = 0;
        int k = 0;
        //System.out.println(norWPK + " test2");
        for (int i = 0; i < m; i++) {
            System.out.println(copiedarray[z][i] + " calcBest");
            averagerateusrz = averagerateusrz + copiedarray[z][i];

        }
        System.out.println("\n");
        averagerateusrz = averagerateusrz / m;
        //fault there should be calculations for all users K=/P copiedarray[z][k]
        counter = counter + ((copiedarray[z][k] - averagerateusrz) * norWPK);
        denominator = Math.abs(norWPK);

        bestarticles = counter / denominator;
    }

    public double getNorWPK() {
        return  norWPK;
    }


}
