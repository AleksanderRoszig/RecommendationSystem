package com.company;

//Memory-based Collaborative Filtering
public class MemoryBased {
    //Pearson correlation coefficient
    double Wpk; //Pearson correlation coefficient between user P and user K
    double norWPK; //Normalized Pearson correlaction
    private double counter1;
    private double denominator1;
    private double counter2;
    private double denominator2;
    private double sumA = 0;
    private double sumDA = 0;
    private double sumB = 0;
    private double sumDB = 0;
    private double averageRatingInputUser;
    private double averageRatingComparedUser;
    private double inputUserRatingSumP = 0;
    private double comparedUserRatingSumK = 0;
    private int itemI;
    private double weightedRating;
    private double averageRatingExI;
    public int[][] setOfUsersU = new int[100][100];
    private double[] arrayofNorWpk = new double[100];
    public double[] weighted = new double[1000];

    int i;
    int m;
    int id; //idUser from dataBaseOfUsers
    private int howMuchProductsBothUsersRated;
    int howMuchProductsComparedUserRated;
    int[] productsRatedByBothUsers = new int[100];
    int[] arrayOfValues = new int[10000]; //check how big it should be later

    //check how much products rated by both users
    private int howMuchProductsBothUsersRated(double[][] comparedUser, double[][] dataBase) {
        double a;
        double b;
        for (i = 1; i < comparedUser.length; i++) {
            a = comparedUser[i][0];
            b = dataBase[id][i]; //something wrong with id value
            if (a * b == 0) {
                productsRatedByBothUsers[i] = 0;
            } else
                productsRatedByBothUsers[i] = 1;
        }
        for (i = 1; i < productsRatedByBothUsers.length; i++) {
            howMuchProductsBothUsersRated = howMuchProductsBothUsersRated + productsRatedByBothUsers[i];
        }
        return howMuchProductsBothUsersRated;
    }

    //check how much products rated by user ComparedUser
    private int howMuchProductsCompaRated(double[][] comparedUser) {
        for (i = 1; i < comparedUser.length; i++) {
            if (comparedUser[i][0] != 0) howMuchProductsComparedUserRated = howMuchProductsComparedUserRated + 1;
        }
        return howMuchProductsComparedUserRated;
    }

    //average rating of all items rated by user ComparedUser exception item I
    private double averageComparedUsrI(double[][] comparedUser, int itemI) {
        double sumofallratingexi = 0;
        for (i = 1; i < comparedUser.length; i++) {
            if (i == itemI) i++;
            sumofallratingexi = sumofallratingexi + comparedUser[i][0];
        }
        return sumofallratingexi;
    }

    //average rating of all items rated by user dataBase exception item I
    private double averageDataBaUsrI(double[][] dataBase, int itemI, int id) {
        double sumofallratingexi = 0;
        for (i = 1; i < dataBase.length; i++) {  //is this lenght ok?
            if (i == itemI) i++;
            sumofallratingexi = sumofallratingexi + dataBase[id][i];
        }
        return sumofallratingexi;
    }

    //comparedUser that's our user from User class, DataBase that's for comparing
    public MemoryBased(double[][] comparedUser, double[][] dataBase) {
        counter2 = 0;
        denominator2 = 0;
        weightedRating = 0;
        averageRatingExI = 0;

        //Calculate Pearson correlation coefficient
        for(int id = 0; id < dataBase.length; id++){
        for (i = 1; i < comparedUser.length; i++) {
            inputUserRatingSumP = inputUserRatingSumP + comparedUser[i][0];
            comparedUserRatingSumK = comparedUserRatingSumK + dataBase[id][i];
        }
        averageRatingInputUser = (inputUserRatingSumP / howMuchProductsBothUsersRated(comparedUser, dataBase));
        averageRatingComparedUser = (comparedUserRatingSumK / howMuchProductsBothUsersRated(comparedUser, dataBase));

        //sumA = left side of counter, sumB = right side of counter
        for (int i = 1; i < m; i++) {
            if (productsRatedByBothUsers[i] == 1) {
                sumA = sumA + (comparedUser[i][0] - averageRatingInputUser);
                sumB = sumB + (dataBase[id][i] - averageRatingComparedUser);
            }
        }
        counter1 = sumA * sumB;
        for (int i = 1; i < m; i++) {
            if (productsRatedByBothUsers[i] == 1) {
                sumDA = sumDA + Math.sqrt(Math.pow(comparedUser[i][0] - averageRatingInputUser, 2));
                sumDB = sumDB + Math.sqrt(Math.pow(dataBase[id][i] - averageRatingComparedUser, 2));
            }
        }
            denominator1 = sumDA * sumDB;
            Wpk = counter1 / denominator1;
            //end Calculate Pearson correlation coefficient

            //emphasizing the difference in Pearson coefficient between User P and oth er users
            int q = 2; //this parameter specifies how much should be emphasized difference
            norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
            arrayofNorWpk[id] = norWPK; //check this id!!todo
        }

            //end emphasing
            //-------------------------------------------^ good

            //weighted rating of other users of the I item counted for user ComparedUser
            //--------------------------------------
            for (int k = 0; k < dataBase.length; k++) {
                counter2 = counter2 + (dataBase[id][itemI] - averageDataBaUsrI(dataBase, itemI, id)) * arrayofNorWpk[id];
                denominator2 = denominator2 + Math.abs(norWPK);

                weighted[itemI] = averageComparedUsrI(comparedUser, itemI) + counter2 / denominator2;
                System.out.println(weighted[itemI]);
            }
        }
    }
