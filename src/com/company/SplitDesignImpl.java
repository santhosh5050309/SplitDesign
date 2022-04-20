package com.company;

import java.util.*;

public class SplitDesignImpl implements ISplitDesign {
    public ArrayList<User> users;
    static private SplitDesignImpl splitDesign = null;
    private SplitDesignImpl()
    {}

    private void setUsersList(ArrayList<User> users_list)
    {
        this.users = users_list;
    }
    static public SplitDesignImpl getInstance()
    {
        if(splitDesign == null)
        {
            splitDesign = new SplitDesignImpl();
        }
        return splitDesign;
    }

    public void executeTransaction(ArrayList<User> users_list,iTransaction transaction,Expense expense) {
        this.users = users_list;
        transaction.executeTransaction(expense);
    }



    @Override
    public void showBalancesForAllUsers(ArrayList<User> users) {
        System.out.println("USERS BALANCE INFO ");
        for(int i=0;i<users.size();i++)
        {

            showBalanceForUser(users.get(i));
        }
    }

    @Override
    public void showBalanceForUser(User user) {
        Iterator iterator = user.balanceInfo.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            User friend = (User)mapElement.getKey();
            int amount  = (Integer)mapElement.getValue();

            System.out.println(user.getName()+" Owes "+ friend.user_id+": "+amount);
        }
    }
}
