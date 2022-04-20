package com.company;

import java.util.*;

public class SplitDesignImpl implements ISplitDesign {
    public ArrayList<User> users;

    SplitDesignImpl(ArrayList<User> users_list)
    {
        this.users = users_list;
    }


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
        int individualAmount  = expense.amount/(no_of_friends+1);
        for(int i=0;i<no_of_friends;i++)
        {
            User user = expense.friends.get(i);
            if(user!=buyer) {
                Integer amount = user.balanceInfo.get(buyer);
                if(amount == null)
                {
                    amount=0;
                }
                int amount_to_pay = amount+individualAmount;
                Integer buyer_to_friend = buyer.balanceInfo.get(user);
                if(buyer_to_friend == null)
                {
                    buyer_to_friend =0;
                }
                amount_to_pay-=buyer_to_friend;
                if(amount_to_pay>0)
                {
                    user.balanceInfo.put(buyer, amount_to_pay);
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
            Integer amount = expense.amountDistribution.get(i);

            total_distributed_amount+= amount;
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
                Integer individualAmount = expense.amountDistribution.get(i);
                if(individualAmount==null)
                {
                    individualAmount=0;
                }
                if(user!=buyer) {
                    Integer amount =  user.balanceInfo.get(buyer);
                    if(amount == null)
                    {
                        amount=0;
                    }
                    int amount_to_pay = amount+individualAmount;
                    Integer buyer_to_friend = buyer.balanceInfo.get(user);
                    if(buyer_to_friend == null )
                    {
                        buyer_to_friend = 0;
                    }
                    amount_to_pay-=buyer_to_friend;
                    if(amount_to_pay>0)
                    {
                        user.balanceInfo.put(buyer, amount_to_pay);
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
            Float amount = expense.percentageDistribution.get(i);
            if(amount == null)
            {
                amount=(float)0;
            }
            total_percent+=amount;
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
                Float percentage = expense.percentageDistribution.get(i);
                if(percentage == null)
                {
                    percentage = (float)0;
                }
                int individualAmount = (int)((float)expense.amount*percentage)/100;
                if(user!=buyer)
                {
                    Integer amount = user.balanceInfo.get(buyer);
                    if(amount == null )
                    {
                        amount =0;
                    }
                    int amount_to_pay = amount+individualAmount;
                    Integer buyer_to_friend = buyer.balanceInfo.get(user);
                    if(buyer_to_friend == null)
                    {
                        buyer_to_friend =0;
                    }
                    amount_to_pay-=buyer_to_friend;
                    if(amount_to_pay>0)
                    {
                        user.balanceInfo.put(buyer, amount_to_pay);
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
