package org.academiadecodigo.javabank.application.operations.transaction;

import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.application.UserOptions;

/**
 * An account transaction used to withdraw an amount
 * @see AbstractAccountTransactionOperation
 * @see UserOptions#WITHDRAW
 */
public class WithdrawOperation extends AbstractAccountTransactionOperation {

    /**
     * Initializes a new {@code WithdrawOperation}
     *
     * @see AbstractAccountTransactionOperation
     */
    public WithdrawOperation(LoginControl loginControl) {
        super(loginControl);
    }

    /**
     * Withdraw an amount from an account
     *
     * @see AbstractAccountTransactionOperation#execute()
     */
    @Override
    public void execute() {


        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (customer.getAccountIds().contains(accountId)) {
            accountManager.withdraw(accountId, amount);
        }
    }

    @Override
    public boolean makenewOperation() {
        super.execute();

        if (!hasAccounts()) {
            return false;
        }
        return true;
    }
}
