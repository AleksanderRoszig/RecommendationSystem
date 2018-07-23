package com.company;

import java.util.Random;
import java.util.*;

//Content-based Filtering
public class Data {
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
    double[] copiedData = new double[5];
    private double[] copiedUser = new double[5];
    private int n = 5; //number of features
    Random r = new Random();

    //constructor for data array with random values
    public Data(String name, double[] copied) {
        copied[0] = 69; //there should be ID of service/book etc.
        for (int i = 1; i < n; i++) {
            copied[i] = r.nextInt(10)+1;
        }
        for (int k = 0; k < copied.length; k++) {
            copiedData[k] = copied[k];
        }

    }
    //constructor for data array with normal values
   /* public Data(String name, double[] copied) {
       this.name = name;
       for(int i = 1; i < n; i++){
           copiedData[i] = copied[i];
       }

   } */
    public void ForArray(double[] anotherarray) { //
        for (int i = 0; i < n; i++) {
            copiedUser[i] = anotherarray[i];
        }
    }
    //Contend-based Filtering and cosine similarity
    public void calcCosin() {
        int i;
        for (i = 1; i < copiedData.length; i++) {
            counter = counter + (copiedData[i] * copiedUser[i]);
        }
        for (i = 1; i < copiedData.length; i++) {
            sumA = sumA + Math.pow(copiedUser[i], 2);
            sumB = sumB + Math.pow(copiedData[i], 2);
        }
        A = Math.sqrt(sumA);
        B = Math.sqrt(sumB);
        denominator = sumA + sumB;
        dUD = counter / denominator;
        copiedData[0] = dUD;
    }


    public String getName() {
        return name;
    }




}



