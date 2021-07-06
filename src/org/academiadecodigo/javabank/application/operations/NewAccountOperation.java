package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.domain.account.AccountType;

/**
 * A bank operation to create new accounts
 * @see AbstractBankOperation
 * @see UserOptions#OPEN_ACCOUNT
 */
public class NewAccountOperation extends AbstractBankOperation {

    private int accountId;

    /**
     * Creates a new {@code NewAccountOperation}
     *
     * @see AbstractBankOperation#AbstractBankOperation(LoginControl)
     */
    public NewAccountOperation(LoginControl loginControl) {
        super(loginControl);
    }

    /**
     * Creates a new bank account
     *
     * @see AbstractBankOperation#execute()
     */
    @Override
    public void execute() {

        accountId = customer.openAccount(AccountType.CHECKING);

    }

    @Override
    public boolean makenewOperation() {
        System.out.println("\n" + Messages.CREATED_ACCOUNT + customer.getName() + " : " + accountId);
        return false;
    }
}
