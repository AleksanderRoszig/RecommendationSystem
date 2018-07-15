package com.company;
import java.util.Random;
public class Data {
    private int ID;
    int dUD;
    int counter;
    int denominator;
    int n = 5; //number of features
    Random r = new Random();
    int[] copiedData = new int[5];


    public Data(int[] copied) {
        copied[0] = 69; //there should be ID of service/book etc.
        for (int i = 1; i < n; i++) {
            copied[i] = r.nextInt(11);
            }
        for(int k = 0; k < copied.length; k++) {
            copiedData[k] = copied[k];
            System.out.println(copiedData[k] + "     kopiowane: " + "a");
        }
    }
    public void recAlgo() {
        for (int z = 0; z < copiedData.length; z++) {
            System.out.println(copiedData[z] + "recalgo");
            for(int i = 0; i < copiedData.length)
            counter = (copiedData[i]); //There I must add array from User class
            dUD = counter/denominator;
            }

    }


}

    //@Override
   /* public String toString(){
        return //maybe return obj name?
    }*/

