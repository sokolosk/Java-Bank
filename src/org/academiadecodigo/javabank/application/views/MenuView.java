package org.academiadecodigo.javabank.application.views;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;

import java.util.HashMap;
import java.util.Map;

public class MenuView {

    public MenuInputScanner buildMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    public Map<Integer, Operation> buildOperationsMap(LoginControl loginControl) {

        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(loginControl));
        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(loginControl));
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawOperation(loginControl));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountOperation(loginControl));

        return map;
    }
}
