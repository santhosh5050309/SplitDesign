package com.company;

import java.util.List;

public class Expense {
    private User buyer;
    private List<User> friends;
    private Double amount;
    private List<Double> distribution;
    private ExpenseType expenseType;

    public Expense(User buyer, List<User> friends, Double amount, ExpenseType expenseType, List<Double> distribution) {
        this.buyer = buyer;
        this.friends = friends;
        this.amount = amount;
        this.expenseType = expenseType;
        this.distribution = distribution;
    }

    Expense(User buyer, List<User> friends, Double amount, ExpenseType expenseType) {
        this.buyer = buyer;
        this.friends = friends;
        this.amount = amount;
        this.expenseType = expenseType;
        if (expenseType != ExpenseType.EQUAL) {
            throw new IllegalStateException("Expense type must be equal");
        }
    }

    public User getBuyer() {
        return buyer;
    }

    public List<User> getFriends() {
        return friends;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Double> getDistribution() {
        return distribution;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }
}
