package com.company;

import java.util.List;
import java.util.Map;

public class SplitDesignImpl implements ISplitDesign {
    public List<User> users;
    static private SplitDesignImpl splitDesign = null;

    private SplitDesignImpl() {
    }

    static public SplitDesignImpl getInstance() {
        if (splitDesign == null) {
            synchronized (SplitDesignImpl.class) {
                if (splitDesign == null) {
                    splitDesign = new SplitDesignImpl();
                }
            }
        }
        return splitDesign;
    }

    public void executeTransaction(List<User> users_list, iTransaction transaction, Expense expense) {
        this.users = users_list;
        transaction.executeTransaction(expense);
    }

    @Override
    public void showBalancesForAllUsers(List<User> users) {
        System.out.println("USERS BALANCE INFO ");
        for (User user : users) {
            showBalanceForUser(user);
        }
    }

    @Override
    public void showBalanceForUser(User user) {
        for (Map.Entry<User, Integer> userIntegerEntry : user.getBalanceInfo().entrySet()) {
            if (userIntegerEntry.getValue() != 0) {
                System.out.println(user.getName() + " Owes " + userIntegerEntry.getKey().getUser_id() +
                        ": " + userIntegerEntry.getValue());
            }
        }
    }
}
