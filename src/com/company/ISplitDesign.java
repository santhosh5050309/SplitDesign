package com.company;

import java.util.ArrayList;

public interface ISplitDesign {
     void executeTransaction(ArrayList<User> users_list,iTransaction transaction,Expense expense);
     void showBalancesForAllUsers(ArrayList<User> users);
     void showBalanceForUser(User user);
}
