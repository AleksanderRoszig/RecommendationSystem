package com.company;

//Memory-based Collaborative Filtering
public class MemoryBased {
    double Wpk; //Pearson correlation coefficient between user ComparedUSer and user DataBase
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
    //private int itemI;
    private double weightedRating;
    private double averageRatingExI;
    public int[][] setOfUsersU = new int[100][100];
    private double[] arrayofNorWpk = new double[100];
    public double[] weighted = new double[1000];
    private int[] itemI = new int[11];
    public int howmuch12;
    int u;
    int i;
    int m;
    int id; //idUser from dataBaseOfUsers
    private int howMuchProductsBothUsersRated;
    int howMuchProductsComparedUserRated;
    int[] productsRatedByBothUsers = new int[11];


    private void whichProdutsNotComaredUser(double[][] comparedUser) {
        for (int i = 1; i < comparedUser.length; i++) {
            if (comparedUser[i][0] == 0) {
                howmuch12++;
                itemI[i] = 1;
            } else itemI[i] = 0;
        }
    }

    //check how much products rated by both users
    private void whichProductsAreRatedByBothUsers(double[][] comparedUser, double[][] dataBase, int id) {
        double a;
        double b;
        this.id = id;
        for (i = 1; i < comparedUser.length; i++) {
            a = comparedUser[i][0];
            b = dataBase[id][i];
            if (a * b == 0) {
                productsRatedByBothUsers[i] = 0;
            } else
                productsRatedByBothUsers[i] = 1;
        }
    }

    private int howMuchProductsBothUsersRated() {
        howMuchProductsBothUsersRated = 0;
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
        int howmuch = 0;
        for (i = 1; i < comparedUser.length; i++) {
            if (i != itemI) {
                sumofallratingexi = sumofallratingexi + comparedUser[i][0];
                howmuch++;
            }
        }
        return sumofallratingexi / howmuch;
    }

    //average rating of all items rated by user dataBase exception item I
    private double averageDataBaUsrI(double[][] dataBase, int itemI, int id) {
        double sumofallratingexi = 0;
        int howmuch = 0;
        for (i = 1; i <= dataBase.length; i++) {
            if (i != itemI) {
                sumofallratingexi = sumofallratingexi + dataBase[id][i];

                howmuch++;
            }
        }
        return sumofallratingexi / howmuch;
    }

    //comparedUser that's our user from User class, DataBase that's for comparing
    public MemoryBased(double[][] comparedUser, double[][] dataBase) {
        u = 0;
        howmuch12 = 0;
        whichProductsAreRatedByBothUsers(comparedUser, dataBase, id);
        whichProdutsNotComaredUser(comparedUser);

        //Calculate Pearson correlation coefficient
        for (int id = 0; id < dataBase.length; id++) {
            counter2 = 0;
            denominator2 = 0;
            weightedRating = 0;
            averageRatingExI = 0;
            inputUserRatingSumP = 0;
            comparedUserRatingSumK = 0;

            for (i = 1; i < comparedUser.length; i++) {
                inputUserRatingSumP = inputUserRatingSumP + comparedUser[i][0];
                comparedUserRatingSumK = comparedUserRatingSumK + dataBase[id][i];
            }
            averageRatingInputUser = (inputUserRatingSumP / comparedUser.length);
            averageRatingComparedUser = (comparedUserRatingSumK / comparedUser.length);

            //sumA = left side of counter, sumB = right side of counter
            for (i = 1; i < comparedUser.length; i++) {
                if (productsRatedByBothUsers[i] == 1) {
                    sumA = sumA + (comparedUser[i][0] - averageRatingInputUser);
                    sumB = sumB + (dataBase[id][i] - averageRatingComparedUser);
                }
            }//end for(int i)
            counter1 = sumA * sumB;
            for (i = 1; i < comparedUser.length; i++) {
                if (productsRatedByBothUsers[i] == 1) {
                    sumDA = sumDA + Math.sqrt(Math.pow(comparedUser[i][0] - averageRatingInputUser, 2));
                    sumDB = sumDB + Math.sqrt(Math.pow(dataBase[id][i] - averageRatingComparedUser, 2));
                }
            }//end for(int i)
            denominator1 = sumDA * sumDB;
            Wpk = counter1 / denominator1;
            //end Calculate Pearson correlation coefficient

            //emphasizing the difference in Pearson coefficient between User P and oth er users
            int q = 2; //this parameter specifies how much should be emphasized difference
            norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
            arrayofNorWpk[id] = norWPK; //its okay
        }//end for(id)
        //end emphasing
        u = 1;
        do { //do for item
            id = 0;
            if (itemI[u] == 1) {//czy item nalezy do zboiru nieratowanych przez comparedusera

                do {// for ids
                    //weighted rating of other users of the I item counted for user ComparedUser
                    //--------------------------------------
                    counter2 = counter2 + (dataBase[id][u] - averageDataBaUsrI(dataBase, u, id)) * arrayofNorWpk[id];
                    denominator2 = denominator2 + Math.abs(norWPK);
                    id++;
                } while (id < dataBase.length);

                weighted[u] = averageComparedUsrI(comparedUser, u) + counter2 / denominator2;

            }
            u++;
        } while (u < 10); //end while(itemI[i] != 0)
        for (u = 0; u < itemI.length; u++) {
            if (itemI[u] == 1) System.out.println(weighted[u] + " weighted for " + u);
        }


    }
}
