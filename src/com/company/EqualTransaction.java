package com.company;

public class EqualTransaction extends iTransaction {
    public void executeTransaction(Expense expense) {
        if (expense.getExpenseType() != ExpenseType.EQUAL) {
            throw new IllegalStateException("Expense type should be Equal");
        }
        User buyer = expense.getBuyer();
        int no_of_friends = expense.getFriends().size();
        double individualAmount = expense.getAmount() / (no_of_friends + 1);
        for (int i = 0; i < no_of_friends; i++) {
            User user = expense.getFriends().get(i);
            if (user != buyer) {
                Integer amount = user.getBalanceInfo().getOrDefault(buyer, 0);
                Integer amount_to_pay = amount + (int) individualAmount;
                Integer buyer_to_friend = buyer.getBalanceInfo().getOrDefault(user, 0);
                amount_to_pay -= buyer_to_friend;
                this.updateBalances(amount_to_pay, user, buyer);
            }
        }
    }
}
