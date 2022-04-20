package com.company;

import java.io.PipedWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        int i;
        for(i=0;i<4;i++)
        {
            User user = new User(i+1);
            users.add(user);
        }

       //test1
        ArrayList<User> friends = new ArrayList<>();
        friends.add(users.get(1));
        friends.add(users.get(2));
        friends.add(users.get(3));

        Expense expense = new Expense(users.get(0),friends,"EQUAL",1000);
        EqualTransaction equalTransaction = new EqualTransaction();
        SplitDesignImpl splitDesign = SplitDesignImpl.getInstance();
        splitDesign.executeTransaction(users,equalTransaction,expense);
        splitDesign.showBalancesForAllUsers(users);

        //test2
        //u1 1250 2 u2 u3 EXACT 370 880
        ArrayList<User> friends2 = new ArrayList<>();
        friends2.add(users.get(1));
        friends2.add(users.get(2));
        ArrayList<Integer> amountDistribution = new ArrayList<>();
        amountDistribution.add(370);
        amountDistribution.add(880);
        Expense expense2 = new Expense(users.get(0),friends2,"EXACT",1250);
        ExactTransaction exactTransaction = new ExactTransaction();
        expense2.setAmountDistribution(amountDistribution);
        splitDesign.executeTransaction(users,exactTransaction,expense2);
        splitDesign.showBalancesForAllUsers(users);


        //test3
        //u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
        ArrayList<User> friends3 = new ArrayList<>();
        friends3.add(users.get(0));
        friends3.add(users.get(1));
        friends3.add(users.get(2));
        friends3.add(users.get(3));
        ArrayList<Float> percentDistribution = new ArrayList<>();
        percentDistribution.add((float)40);
        percentDistribution.add((float)20);
        percentDistribution.add((float)20);
        percentDistribution.add((float)20);
        Expense expense3 = new Expense(users.get(3),friends3,"PERCENT",1200);
        PercentTransaction percentTransaction = new PercentTransaction();
        expense3.setPercentageDistribution(percentDistribution);
        splitDesign.executeTransaction(users,percentTransaction,expense3);
        splitDesign.showBalancesForAllUsers(users);

    }
}
