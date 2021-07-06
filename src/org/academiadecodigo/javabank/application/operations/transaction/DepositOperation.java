package org.academiadecodigo.javabank.application.operations.transaction;

import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.application.UserOptions;

/**
 * An account transaction used to deposit an amount
 * @see AbstractAccountTransactionOperation
 * @see UserOptions#DEPOSIT
 */
public class DepositOperation extends AbstractAccountTransactionOperation {

    /**
     * Initializes a new {@code DepositOperation}
     *
     * @see AbstractAccountTransactionOperation
     */
    public DepositOperation(LoginControl loginControl) {
        super(loginControl);
    }

    /**
     * Deposit an amount into an account
     *
     * @see AbstractAccountTransactionOperation#execute()
     */
    @Override
    public void execute() {


        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (customer.getAccountIds().contains(accountId)) {
            accountManager.deposit(accountId, amount);
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
