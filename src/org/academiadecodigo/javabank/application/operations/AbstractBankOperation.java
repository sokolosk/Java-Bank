package org.academiadecodigo.javabank.application.operations;

import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.domain.Customer;

/**
 * A generic bank operation to be used as a base for concrete types of bank operations
 * @see Operation
 */
public abstract class AbstractBankOperation implements Operation {

    protected LoginControl loginControl;
    protected Customer customer;

    /**
     * Initializes a new {@code AbstractBankOperation} given a bank application
     *
     * @param loginControl the bank application
     */
    public AbstractBankOperation(LoginControl loginControl) {
        this.loginControl = loginControl;
        customer = loginControl.getBank().getCustomer(loginControl.getAccessingCustomerId());
    }
}
