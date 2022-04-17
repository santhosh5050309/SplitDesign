package com.company;

import java.util.ArrayList;

public class SplitWise {
    private  ArrayList<ArrayList<Integer>> amountOwedByUsers;
    private int no_of_users;
    SplitWise(int no_of_users) {
        this.no_of_users = no_of_users;
        amountOwedByUsers = new ArrayList<ArrayList<Integer>>();
    }
}
