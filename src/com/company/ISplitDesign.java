package com.company;

public interface ISplitDesign {
    void addUser(User user);
    void transaction(Expense expense);
    void showBalancesForAllUsers();
    void showBalanceForUser(User user);
}
