package com.company;

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
    private double averageRatingInputUser;
    private double averageRatingComparedUser;
    private double inputUserRatingSumP = 0;
    private double comparedUserRatingSumK = 0;
    private double fraction = 0;
    int i;


    //comparedUser that's our user from User class, DataBase that's for comparing
    public MemoryBased(double[][] comparedUser, double[][] dataBase) {
        int m;
        int id; //idUser from dataBaseOfUsers
        double a;
        double b;
        int howMuchProductsBothUsersRated;
        int[] productsRatedByBothUsers = new int[comparedUser.length];
        int[] arrayOfValues = new int[10000]; //check how big it should be later

        id = 0;
        howMuchProductsBothUsersRated = 0;
        m = comparedUser.length;

        //todo
        //---------------------------------------------------------------------------------------------------
        //tutaj powinna byc petla zaczynajaca sie po ID zeby przelcizyc algorytm dla kazdego usera z dataBase.

        System.out.println(m + " : Test wielkości tablicy"); //sprawdzić jaką wilekość talbicy daje to polecenie i w razie czego zmienic dla reszty.



        //check which products are compared by both users
        for (i = 1; i < m; i++) {
            a = comparedUser[i][0];
            b = dataBase[id][i];
            if (a * b == 0) {
                productsRatedByBothUsers[i] = 0;
            } else
                productsRatedByBothUsers[i] = 1;
        }
        for (i = 1; i < productsRatedByBothUsers.length; i++){
            howMuchProductsBothUsersRated = howMuchProductsBothUsersRated + productsRatedByBothUsers[i];
        }

        //Calculate Pearson correlation coefficient
        for (i = 1; i < m; i++) {
            //check which products are compared by both users to sum that
            a = comparedUser[i][0];
            b = dataBase[id][i];
            if (a * b == 0 ){ i ++;}
            inputUserRatingSumP = inputUserRatingSumP + comparedUser[i][0];
            comparedUserRatingSumK = comparedUserRatingSumK + dataBase[id][i];
        }
        averageRatingInputUser = (inputUserRatingSumP / howMuchProductsBothUsersRated);
        averageRatingComparedUser = (comparedUserRatingSumK / howMuchProductsBothUsersRated);


        //sumA = left side of counter, sumB = right side of counter
        for (int i = 1; i < m; i++) {
            if(productsRatedByBothUsers[i] == 1) {
                sumA = sumA + (comparedUser[i][0] - averageRatingInputUser);
                sumB = sumB + (dataBase[id][i] - averageRatingComparedUser);
            }
        }
        counter = sumA * sumB;
        for (int i = 1; i < m; i++) {
            if(productsRatedByBothUsers[i] == 1) {
            sumDA = sumDA + Math.sqrt(Math.pow(comparedUser[i][0] - averageRatingInputUser, 2));
            sumDB = sumDB + Math.sqrt(Math.pow(dataBase[id][i] - averageRatingComparedUser, 2));
        }
        denominator = sumDA * sumDB;
        Wpk = counter / denominator;
        //end Calculate Pearson correlation coefficient

        //emphasizing the difference in Pearson coefficient between User P and oth er users
        int q = 2; //this parameter specifies how much should be emphasized difference
        norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
        //end emphasing
        //-------------------------------------------^ good



        //todo
        // storna 26

        //calculate weighted sum of ratings of users of article I for user P
        private void calcBest () {
            double counter = 0;
            double denominator = 0;
            double averagerateusrz = 0;
            double rateuserki = 0;
            double averagerateusrp = 0;
            int k = 0;
            int o = 0; //article I
            //todo
            do {
                rateuserki = 0;
                averagerateusrz = 0;
                counter = 0;
                denominator = 0;
                fraction = 0;
                averagerateusrp = 0;
                calcbbbbb = 0;
                z = 1;
                //todo
                //now i calculate one user but i made +z without any sense
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
                    fraction = fraction + (counter / denominator);
                    //------------------
                    z++;
                } while (z < n);


                //average rate of all articles without article I for user P
                for (int i = 0; i < m; i++) {
                    averagerateusrp = averagerateusrp + comparedUser[0][i];
                }

                calcbbbbb = (averagerateusrp / m) + fraction;


                o++;
                System.out.println(calcbbbbb + " callasd");
            } while (o < m);

        }


    }


    }
}
