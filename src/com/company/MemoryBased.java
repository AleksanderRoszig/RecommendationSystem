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
    private double averageRatingInputP;
    private double averageRatingInputK;
    private double userRatingSumP = 0;
    private double userRatingSumK = 0;
    private double fraction = 0;




    //comparedUser thats our user from User class, DataBase thats for comparing
    public MemoryBased(double[][] comparedUser, double[][] dataBase) {
        private int m;
        private int k; //idUser from dataBaseOfUsers
        private int p; //idProduct
        k = 0;
        p = 0;
        m = comparedUser.length;
        System.out.println(m + " : Test wielkości tablicy") ;


        //todo

        //Calculate Pearson corelation coefficient
        for (int i = 1; i < m; i++) {
            userRatingSumP = userRatingSumP + comparedUser[i][0];
            userRatingSumK = userRatingSumK + dataBase[k][p];
        }
        averageRatingInputP = (userRatingSumP / m);
        averageRatingInputK = (userRatingSumK / m);
        //sumA = left side of counter, sumB = right side of counter
        for (int i = 1; i < m; i++) {
            sumA = sumA + (comparedUser[i][0] - averageRatingInputP);
            sumB = sumB + (dataBase[k][p] - averageRatingInputK);
        }
        counter = sumA * sumB;
        for (int i = 1; i < m; i++) {
            sumDA = sumDA + Math.sqrt(Math.pow(comparedUser[0][i] - averageRatingInputP, 2));
            sumDB = sumDB + Math.sqrt(Math.pow(dataBase[k][p] - averageRatingInputP, 2));
        }
        denominator = sumDA * sumDB;
        Wpk = counter / denominator;
        //end Calculate Pearson corelation coefficient



        //emphasizing the difference in Pearson coefficient between User P and oth er users
            int q = 2; //this parameter specifies how much should be emphasized difference
            norWPK = Wpk * Math.pow(Math.abs(Wpk), q - 1);
        //end emphasing

        // X = set of user who rate aritcle I, xeX, X=/P,
        // z = average rate of all articles rated by user x
        // E xeX,(Bx,i - z)
        private void calcB() {
            sumrates = (sumrates + getnormRates());
            arrayofrates[0] = arrayofrates[0] + sumrates;
        }

        private int getnormRates() {
            int summa = 0;
            for (int i = 0; i < n; i++) {
                summa = summa + copiedarray[z][i];
            }
            return summa;
        }


        //calculate weighted sum of ratings of users of article I for user P
        private void calcBest() {
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

    /*
    private void calcPearson() {
        for (int i = 0; i < m; i++) {
            userRatingSumP = userRatingSumP + comparedUser[][i];
            userRatingSumK = userRatingSumK + copiedarray[z][i];
        }
        System.out.println("\n");
        averageRatingInputP = (userRatingSumP / m);
        averageRatingInputK = (userRatingSumK / m);
        //sumA = left side of counter, sumB = right side of counter
        for (int i = 0; i < m; i++) {
            sumA = sumA + (comparedUser[0][i] - averageRatingInputP);
            sumB = sumB + (copiedarray[z][i] - averageRatingInputK);
        }
        counter = sumA * sumB;
        for (int i = 0; i < m; i++) {
            sumDA = sumDA + Math.sqrt(Math.pow(comparedUser[0][i] - averageRatingInputP, 2));
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
    private void calcB() {
        sumrates = (sumrates + getnormRates());
        arrayofrates[0] = arrayofrates[0] + sumrates;
    }

    private int getnormRates() {
        int summa = 0;
        for (int i = 0; i < n; i++) {
            summa = summa + copiedarray[z][i];
        }
        return summa;
    }

    */

    //calculate weighted sum of ratings of users of article I for user P
    private void calcBest() {
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


    private double getNorWPK() {
        return norWPK;
    }


}
