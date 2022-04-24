package com.company;

import java.util.List;

public interface ISplitDesign {
    void executeTransaction(List<User> users_list, iTransaction transaction, Expense expense);

    void showBalancesForAllUsers(List<User> users);

    void showBalanceForUser(User user);
}
