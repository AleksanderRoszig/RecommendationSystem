package com.company;
import java.util.Random;
import java.util.*;
public class Data {
    private int ID;
    double dUD;
    double counter = 0;
    double denominator;
    double A;
    double sumA = 0;
    double B;
    double sumB = 0;
    int n = 5; //number of features
    Random r = new Random();
    int[] copiedData = new int[5];
    int[] copiedUser = new int[5];

    public Data(int[] copied) {
        copied[0] = 69; //there should be ID of service/book etc.
        for (int i = 1; i < n; i++) {
            copied[i] = r.nextInt(11);
        }
        for (int k = 0; k < copied.length; k++) {
            copiedData[k] = copied[k];
            System.out.println(copiedData[k] + "     kopiowane: " + "a");
        }
    }

    public void ForArray(int[] anotherarray) {
        for (int i = 0; i < n; i++) {
            copiedUser[i] = anotherarray[i];
        }
    }

    public void recAlgo() {
            for (int i = 0; i < copiedData.length; i++) {
                counter = counter + (copiedData[i] + copiedUser[i]);

                for(i = 0; i < copiedUser.length; i++) {
                    sumA = sumA + Math.pow(copiedUser[i], 2);
                    sumB = sumB + Math.pow(copiedData[i], 2);
                }

                A = Math.sqrt(sumA);
                B = Math.sqrt(sumB);
                denominator = sumA + sumB;
                dUD = counter / denominator;
            }
        System.out.println("dUD: " + dUD);
    }
}

    //@Override
   /* public String toString(){
        return //maybe return obj name?
    }*/

