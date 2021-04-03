package expense;

import split.PercentageSplit;
import split.Split;
import split.User;

import java.util.List;

public class PercentageExpense extends Expense {
    public PercentageExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentageSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentageSplit exactSplit = (PercentageSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}