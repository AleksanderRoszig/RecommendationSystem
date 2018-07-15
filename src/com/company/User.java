package com.company;


public class User {
    int ID;
    String name;
    String surname;
    int age;
    public int[] copiedUser = new int[5];
    public User(String name,  int [] userpref) {
        this.name = name;
        for (int i = 0; i < userpref.length; i++) {
            copiedUser[i] = userpref[i];
        }
    }


    public String toString(){
        return "ID: " + ID + "\n" + "Name: " + name + "\n" + "Surname: " + surname;
    }

}
