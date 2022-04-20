package com.company;

import java.util.ArrayList;

public class Expense {
    public User buyer;
    public ArrayList<User> friends;
    public String expenseType;
    public int amount;
    public ArrayList<Float> percentageDistribution;    public ArrayList<Integer> amountDistribution;

    Expense(User buyer,ArrayList<User> friends ,String expenseType,int amount) {
        this.buyer = buyer;
        this.friends = friends;
        this.expenseType = expenseType;
        this.amount = amount;
    }

    public void setAmountDistribution(java.util.ArrayList<Integer> amountDistribution) {
        this.amountDistribution = amountDistribution;
    }

    public void setPercentageDistribution(java.util.ArrayList<Float> percentageDistribution) {
        this.percentageDistribution = percentageDistribution;
    }
}
