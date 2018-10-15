package com.company;


import java.util.Collections;

public class User {
    int ID;
    String name;
    String surname;
    int age;
    double[][] userpref = new double[10][10];
    //array userpref that is |0 index for rating of this product if it was rated by user| 1-n index for product own rates by catogegory like horror, comedy, for girl, for boy etc.
    public User(String name,  double[][] userpref) {
    }

    public double[][] returnUserArray(){
    return userpref;
    } // tablice usera

    public String toString(){
        return "ID: " + ID + "\n" + "Name: " + name + "\n" + "Surname: " + surname;
    }

}
