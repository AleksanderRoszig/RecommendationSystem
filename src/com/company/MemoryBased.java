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
    public double calcbbbbb = 0;
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
    private double fraction = 0;
    //1 User, 2 User rating
    private int n = 5; //number of Users
    private int m = 5; //number of rated Articles
    private int f = 0; //user P chosen to make calculations
    private int z = 1; //other users, its user K
    int[][] copiedarray = new int[n][m];
    Random r = new Random();
    double[][] userParray = new double[1][6];
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
        }
        System.out.println("\n");
        //second array its rate of user P
        userParray[0][0] = 2;
        userParray[0][1] = 3;
        userParray[0][2] = 3;
        userParray[0][3] = 4;
        userParray[0][4] = 10;
        //userParray[0][5] its free for not rated article
    }

    public void calcPearson() {
        for (int i = 0; i < m; i++) {
            userRatingSumP = userRatingSumP + userParray[0][i];
            userRatingSumK = userRatingSumK + copiedarray[z][i];
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
    }

    private int getnormRates() {
        int summa = 0;
        for(int i = 0; i < n; i++) {
            summa = summa + copiedarray[z][i];
        }
        return summa;
    }
    //calculate weighted sum of ratings of users of article I for user P
    public void calcBest() {
        double counter = 0;
        double denominator = 0;
        double averagerateusrz = 0;
        double rateuserki = 0;
        int k = 0;
        int o = 0; //article I
        //todo
        do {
                rateuserki = copiedarray[z][o];
            for (int i = 0; i < m; i++) {
                averagerateusrz = averagerateusrz + copiedarray[z][i];
            }
            averagerateusrz = averagerateusrz + copiedarray[z][o];
            averagerateusrz = (averagerateusrz / m);
            counter = (rateuserki - averagerateusrz) * norWPK;

            //denominator ok
            denominator = Math.abs(norWPK);
            fraction = fraction + (counter/denominator);
            //------------------

            double averagerateusrp = 0;
            //average rate of all articles without article I for user P
            for (int i = 0; i < m; i++) {
                averagerateusrp = averagerateusrp + userParray[0][i];
            }
            calcbbbbb = (averagerateusrp / m) + fraction;
            //System.out.println(calcbbbbb + " callasd");

            o++;
        }while(o < m);
    }


    public double getNorWPK() {
        return  norWPK;
    }



}
