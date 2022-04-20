package com.company;

public class ExactTransaction implements iTransaction {
    public void executeTransaction(Expense expense) {
        User buyer = expense.buyer;
        int no_of_friends = expense.friends.size();
        int total_distributed_amount = 0;
        for (int i = 0; i < no_of_friends; i++) {
            Integer amount = expense.amountDistribution.get(i);

            total_distributed_amount += amount;
        }
        if (total_distributed_amount != expense.amount) {
            System.out.println("total_distributed_amount IS NOT EQUAL TO amount spent");
        } else {
            for (int i = 0; i < no_of_friends; i++) {
                User user = expense.friends.get(i);
                Integer individualAmount = expense.amountDistribution.get(i);
                if (individualAmount == null) {
                    individualAmount = 0;
                }
                if (user != buyer) {
                    Integer amount = user.balanceInfo.get(buyer);
                    if (amount == null) {
                        amount = 0;
                    }
                    int amount_to_pay = amount + individualAmount;
                    Integer buyer_to_friend = buyer.balanceInfo.get(user);
                    if (buyer_to_friend == null) {
                        buyer_to_friend = 0;
                    }
                    amount_to_pay -= buyer_to_friend;
                    if (amount_to_pay > 0) {
                        user.balanceInfo.put(buyer, amount_to_pay);
                        buyer.balanceInfo.remove(user);
                    } else {
                        user.balanceInfo.remove(buyer);
                        if (amount_to_pay != 0)
                            buyer.balanceInfo.put(user, -amount_to_pay);
                    }
                }
            }
        }
    }
}
