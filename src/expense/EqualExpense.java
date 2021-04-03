package expense;

import split.EqualSplit;
import split.Split;
import split.User;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}