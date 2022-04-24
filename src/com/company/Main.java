package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        int i;
        for (i = 0; i < 4; i++) {
            User user = new User(i + 1);
            users.add(user);
        }

        //test1
        // u1 1000 4 u1 u2 u3 u4 EQUAL
        ArrayList<User> friends = new ArrayList<>();
        friends.add(users.get(1));
        friends.add(users.get(2));
        friends.add(users.get(3));

        Expense expense = new Expense(users.get(0), friends, 1000.0, ExpenseType.EQUAL);
        EqualTransaction equalTransaction = new EqualTransaction();
        SplitDesignImpl splitDesign = SplitDesignImpl.getInstance();
        splitDesign.executeTransaction(users, equalTransaction, expense);
        splitDesign.showBalancesForAllUsers(users);

        //test2
        //u1 1250 2 u2 u3 EXACT 370 880
        ArrayList<User> friends2 = new ArrayList<>();
        friends2.add(users.get(1));
        friends2.add(users.get(2));
        ArrayList<Double> amountDistribution = new ArrayList<>();
        amountDistribution.add(370.0);
        amountDistribution.add(880.0);
        Expense expense2 = new Expense(users.get(0), friends2, 1250.0, ExpenseType.EXACT, amountDistribution);
        ExactTransaction exactTransaction = new ExactTransaction();
        splitDesign.executeTransaction(users, exactTransaction, expense2);
        splitDesign.showBalancesForAllUsers(users);


        //test3
        //u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
        ArrayList<User> friends3 = new ArrayList<>();
        friends3.add(users.get(0));
        friends3.add(users.get(1));
        friends3.add(users.get(2));
        friends3.add(users.get(3));
        ArrayList<Double> percentDistribution = new ArrayList<>();
        percentDistribution.add(40.0);
        percentDistribution.add(20.0);
        percentDistribution.add(20.0);
        percentDistribution.add(20.0);
        Expense expense3 = new Expense(users.get(3), friends3, 1200.0, ExpenseType.PERCENT, percentDistribution);
        PercentTransaction percentTransaction = new PercentTransaction();
        splitDesign.executeTransaction(users, percentTransaction, expense3);
        splitDesign.showBalancesForAllUsers(users);

    }
}
