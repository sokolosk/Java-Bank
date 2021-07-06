package org.academiadecodigo.javabank.application.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class LoginView {


    public int scanCustomerId(Bank bank, Prompt prompt) {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        return prompt.getUserInput(scanner);
    }


}
