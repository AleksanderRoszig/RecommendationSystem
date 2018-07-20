package com.company;

import java.util.Random;

//Memory-based Collaborative Filtering
public class MemoryBased {
    //Pearson correlation coefficient
    private int ID; //article id
    double Wpk; //Pearson correlation coefficient between user P and user K
    private double counter;
    private double denominator;
    private double sumA = 0;
    private double sumB = 0;
    private double averageRatingInputP;
    private double averageRatingInputK;
    private double userRatingSumP = 0;
    private double userRatingSumK = 0;
    private double
    //1 User, 2 User rating
    double[][] copiedarray = new double[n][m];
    private int n = 5; //number of Users
    private int m = 5; //number of rated Articles
    private int z = 0; //user
    Random r = new Random();
    
    //constructor for users array with random values
    public MemoryBased(String ArticleName, int[][] UsersInputs) {
        for (int i = 0; i < n; i++) {
            int m = 0;
            do {
                UsersInputs[i][m] = r.nextInt(11);
                m++;
            } while (m < n + 1);
        }
        for (int k = 0; k < copiedarray.length; k++) {
            copiedarray[k][k] = UsersInputs[k][k];
        }
    }

    public void calcPearson() {
        //todo
        //average articles rating of user P
        //here write for for all users with z
        //check all

        //user P counter
        for (int i = 0; i < m; i++) {
            userRatingSumP = userRatingSumP + copiedarray[z][m];
        }
        averageRatingInputP = (userRatingSumP / m);
        sumA = copiedarray[z][m] - averageRatingInputP;

        //user K counter
        for (int i = 0; i < m; i++) {
            userRatingSumK = userRatingSumK + copiedarray[z + 1][m];
        }
        averageRatingInputK = (userRatingSumK / m);
        sumB = copiedarray[z + 1][m] - averageRatingInputK;

        //counter = user k * user p E(0, M)
        // this must be done in for
        denominator = Math.sqrt(Math.pow(sumA, 2)) * Math.sqrt(Math.pow(sumB, 2));
        Wpk = counter / denominator;
        normalization();
    }

    //emphasizing the difference in Pearson coefficient between User P and other users
    public void normalization() {

    }


}
