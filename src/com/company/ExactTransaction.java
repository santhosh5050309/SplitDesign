package com.company;

public class ExactTransaction extends iTransaction {
    public void executeTransaction(Expense expense) {
        if (expense.getExpenseType() != ExpenseType.EXACT) {
            throw new IllegalStateException("Expense type should be Exact");
        }
        User buyer = expense.getBuyer();
        int no_of_friends = expense.getFriends().size();
        int total_distributed_amount = 0;
        for (int i = 0; i < no_of_friends; i++) {
            int amount = expense.getDistribution().get(i).intValue();

            total_distributed_amount += amount;
        }
        if (total_distributed_amount != expense.getAmount().intValue()) {
            throw new IllegalStateException("total_distributed_amount IS NOT EQUAL TO amount spent");
        } else {
            for (int i = 0; i < no_of_friends; i++) {
                User user = expense.getFriends().get(i);
                Double individualAmount = expense.getDistribution().get(i) == null ? Double.valueOf("0") : expense.getDistribution().get(i);
                if (user != buyer) {
                    Integer amount = user.getBalanceInfo().getOrDefault(buyer, 0);
                    Integer amount_to_pay = amount + individualAmount.intValue();
                    Integer buyer_to_friend = buyer.getBalanceInfo().getOrDefault(user, 0);
                    amount_to_pay -= buyer_to_friend;
                    this.updateBalances(amount_to_pay, user, buyer);
                }
            }
        }
    }
}
