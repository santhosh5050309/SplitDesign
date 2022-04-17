package com.company;

import java.util.*;

public class SplitDesignImpl implements ISplitDesign {
    private  ArrayList<User> userAmountInfo;
    @Override
    public void addUser(User user) {
        userAmountInfo.add(user);
    }

    @Override
    public void transaction(Expense expense) {
        if(expense.expenseType.equals("EXACT"))
        {
            exactTransaction(expense);
        }
        else if(expense.expenseType.equals("EQUAL"))
        {
            equalTransaction(expense);
        }
        else if(expense.expenseType.equals("PERCENT"))
        {
            percentTransaction(expense);
        }
        else
        {
            System.out.println("Invalid Operation");
        }
    }

    void equalTransaction(Expense expense)
    {
        User buyer = expense.buyer;
        int no_of_friends = expense.friends.size();
        int individualAmount  = expense.amount/no_of_friends;
        for(int i=0;i<no_of_friends;i++)
        {
            User user = expense.friends.get(i);
            if(user!=buyer) {
                int amount_to_pay = user.balanceInfo.get(buyer)+individualAmount;
                int buyer_to_friend = buyer.balanceInfo.get(user);
                amount_to_pay-=buyer_to_friend;
                if(amount_to_pay>0)
                {
                    user.balanceInfo.put(user, amount_to_pay);
                    buyer.balanceInfo.remove(user);
                }
                else
                {
                    user.balanceInfo.remove(buyer);
                    if(amount_to_pay!=0)
                        buyer.balanceInfo.put(user,-amount_to_pay);
                }

            }
        }
    }

    void exactTransaction(Expense expense)
    {
        User buyer = expense.buyer;
        int no_of_friends = expense.friends.size();
        int total_distributed_amount = 0;
        for(int i=0;i<no_of_friends;i++)
        {
            total_distributed_amount+= expense.amountDistribution.get(i);
        }
        if(total_distributed_amount != expense.amount)
        {
            System.out.println("total_distributed_amount IS NOT EQUAL TO amount spent");
        }
        else
        {
            for(int i=0;i<no_of_friends;i++)
            {
                User user = expense.friends.get(i);
                int individualAmount = expense.amountDistribution.get(i);
                if(user!=buyer) {
                    int amount_to_pay = user.balanceInfo.get(buyer)+individualAmount;
                    int buyer_to_friend = buyer.balanceInfo.get(user);
                    amount_to_pay-=buyer_to_friend;
                    if(amount_to_pay>0)
                    {
                        user.balanceInfo.put(user, amount_to_pay);
                        buyer.balanceInfo.remove(user);
                    }
                    else
                    {
                        user.balanceInfo.remove(buyer);
                        if(amount_to_pay!=0)
                            buyer.balanceInfo.put(user,-amount_to_pay);
                    }
                }
            }
        }
    }

    void percentTransaction(Expense expense)
    {
        User buyer = expense.buyer;
        int no_of_friends = expense.friends.size();
        int total_percent = 0;
        for(int i=0;i<no_of_friends;i++)
        {
            total_percent+=expense.percentageDistribution.get(i);
        }
        if(total_percent != 100)
        {
            System.out.println("total_total_percent IS NOT EQUAL 100");
        }
        else
        {
            for(int i=0;i<no_of_friends;i++)
            {
                User user = expense.friends.get(i);
                float percentage = expense.percentageDistribution.get(i);
                int individualAmount = (int)((float)expense.amount*percentage)/100;
                if(user!=buyer)
                {
                    int amount_to_pay = user.balanceInfo.get(buyer)+individualAmount;
                    int buyer_to_friend = buyer.balanceInfo.get(user);
                    amount_to_pay-=buyer_to_friend;
                    if(amount_to_pay>0)
                    {
                        user.balanceInfo.put(user, amount_to_pay);
                        buyer.balanceInfo.remove(user);
                    }
                    else
                    {
                        user.balanceInfo.remove(buyer);
                        if(amount_to_pay!=0)
                            buyer.balanceInfo.put(user,-amount_to_pay);
                    }
                }
            }
        }
    }

    @Override
    public void showBalancesForAllUsers() {
        for(int i=0;i<userAmountInfo.size();i++)
        {
            showBalanceForUser(userAmountInfo.get(i));
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

            System.out.println(user+" Owes "+ friend.user_id+": "+amount);
        }
    }
}
