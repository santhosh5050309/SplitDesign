package com.company;

public class PercentTransaction extends iTransaction {
    public void executeTransaction(Expense expense) {
        if (expense.getExpenseType() != ExpenseType.PERCENT) {
            throw new IllegalStateException("Expense type should be Percent");
        }
        User buyer = expense.getBuyer();
        int no_of_friends = expense.getFriends().size();
        int total_percent = 0;
        for (int i = 0; i < no_of_friends; i++) {
            Double amount = expense.getDistribution().get(i) == null ? Double.valueOf("0") : expense.getDistribution().get(i);
            total_percent += amount;
        }
        if (total_percent != 100) {
            throw new IllegalStateException("total_total_percent IS NOT EQUAL 100");
        } else {
            for (int i = 0; i < no_of_friends; i++) {
                User user = expense.getFriends().get(i);
                Double percentage = expense.getDistribution().get(i) == null ? Double.valueOf("0") : expense.getDistribution().get(i);
                double individualAmount = (expense.getAmount() * percentage) / 100;
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
}
