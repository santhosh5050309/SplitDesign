package com.company;

public abstract class iTransaction {
    abstract void executeTransaction(Expense expense);

    public void updateBalances(Integer amount_to_pay, User user, User buyer) {
        if (amount_to_pay > 0) {
            user.getBalanceInfo().put(buyer, amount_to_pay);
            buyer.getBalanceInfo().remove(user);
        } else {
            user.getBalanceInfo().remove(buyer);
            if (amount_to_pay != 0) {
                buyer.getBalanceInfo().put(user, -amount_to_pay);
            }
        }
    }
}
