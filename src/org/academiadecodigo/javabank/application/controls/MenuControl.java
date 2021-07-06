package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.controls.LoginControl;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.views.MenuView;

import java.util.Map;

public class MenuControl {

    private MenuInputScanner menu;
    private Map<Integer, Operation> operationsMap;
    private MenuView menuView;
    private LoginControl loginControl;
    private Prompt prompt;
    private BalanceControl bc;
    private DepositControl dc;
    private WithdrawControl wc;
    private OpenAccountControl oac;

    public MenuControl(LoginControl loginControl, Prompt prompt){
        this.menuView = new MenuView();
        this.loginControl = loginControl;
        this.prompt = prompt;

    }

    public void start() {
        menu = menuView.buildMainMenu();
        operationsMap = menuView.buildOperationsMap(loginControl);
        menuLoop();
    }

    private void menuLoop() {

        int userChoice = prompt.getUserInput(menu);

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }
        switch (userChoice){
            case 1:
                bc = new BalanceControl();
                bc.init(operationsMap, userChoice);
                break;
            case 2:
                dc = new DepositControl();
                dc.init(operationsMap, userChoice);
                break;
            case 3:
                wc = new WithdrawControl();
                wc.init(operationsMap, userChoice);
                break;
            case 4:
                oac = new OpenAccountControl();
                oac.init(operationsMap, userChoice);
                break;

        }

        /*operationsMap.get(userChoice).execute()*/;
        menuLoop();
    }
}
