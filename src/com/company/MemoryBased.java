package com.company;

import java.util.Random;

//Memory-based Collaborative Filtering
public class MemoryBased {
    //Pearson correlation coefficient
    private int ID; //article id
    double Wpk; //Pearson correlation coefficient between user P and user K
    double norWPK; //Normalized Pearson correlaction
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
    double[][] copiedarray = new double[n][m];
    Random r = new Random();

    //constructor for users array with random values
    public MemoryBased(String ArticleName, double[][] UsersInputs) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                UsersInputs[i][j] = r.nextInt(10) + 1;
                System.out.println(UsersInputs[i][j] + " test1");
            }
        }
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                copiedarray[k][j] = UsersInputs[k][j];
                System.out.println(copiedarray[k][j] + " test2");
            }
        }
    }


    public void calcPearson() {
        //check all
        do {
            //user P and K average rating of all articles
            for (int i = 0; i < m; i++) {
                userRatingSumP = userRatingSumP + copiedarray[f][i];
                userRatingSumK = userRatingSumK + copiedarray[z][i];
            }
            averageRatingInputP = (userRatingSumP / m);
            averageRatingInputK = (userRatingSumK / m);
            //sumA = left side of counter, sumB = right side of counter
            for (int i = 0; i < m; i++) {
                sumA = sumA + (copiedarray[f][i] - averageRatingInputP);
                sumB = sumB + (copiedarray[z][i] - averageRatingInputK);
            }
            counter = sumA * sumB;
            for (int i = 0; i < m; i++) {
                sumDA = sumDA + Math.sqrt(Math.pow(copiedarray[f][i] - averageRatingInputP, 2));
                sumDB = sumDB + Math.sqrt(Math.pow(copiedarray[z][i] - averageRatingInputP, 2));
            }
            denominator = sumDA * sumDB;
            Wpk = counter / denominator;
            z++;
        } while (z < 5);
    }

    //emphasizing the difference in Pearson coefficient between User P and other users
    public void normalization() {
        int q = 2; //this parameter specifies how much should be emphasized difference
        norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
    }


}
