package com.company;

//Content-based Filtering
public class ContentBased {
    int ID;
    String name;
    //Cosine similarity
    double dUD; //Cosine similarity beteween user and article
    private double counter = 0;
    private double denominator;
    private double A;
    private double sumA = 0;
    private double B;
    private double sumB = 0;
    private int n = 0;

    public ContentBased(double[][] comparedUser, double[][] dataBase) {
        //Contend-based Filtering and cosine similarity
        for (n = 0; n < dataBase.length; n++) {
            int i;
            for (i = 1; i < dataBase.length; i++) {
                counter = counter + (dataBase[n][i] * comparedUser[0][i]);
            }
            for (i = 1; i < dataBase.length; i++) {
                sumA = sumA + Math.pow(comparedUser[0][i], 2);
                sumB = sumB + Math.pow(dataBase[n][i], 2);
            }
            A = Math.sqrt(sumA);
            B = Math.sqrt(sumB);
            denominator = sumA + sumB;
            dUD = counter / denominator;
            dataBase[n][0] = dUD;

        }
    }

    public void bubbleSort(double[][] tab) {
        double temp;
        int n = 1;
        while (n > 0) {
            n = 0;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i][0] > tab[i + 1][0]) {
                    temp = tab[i + 1][0];
                    tab[i + 1][0] = tab[i][0];
                    tab[i][0] = temp;
                    n++;
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}



