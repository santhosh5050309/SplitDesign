package com.company;

import java.util.ArrayList;

public interface ISplitDesign {
    void transaction(Expense expense);
    void showBalancesForAllUsers(ArrayList<User> users);
    void showBalanceForUser(User user);
}
