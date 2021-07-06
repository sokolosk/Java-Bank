package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.views.LoginView;
import org.academiadecodigo.javabank.domain.Bank;

/**
 * The bank application
 */
public class LoginControl {

    private Prompt prompt;

    private Bank bank;
    private int accessingCustomerId;

    private LoginView loginView;
    private MenuControl menuControl;

    /**
     * Creates a new instance of a {@code BankApplication}, initializes it with the given {@link Bank}
     *
     * @param bank the bank instance
     */
    public LoginControl(Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in, System.out);
        this.loginView = new LoginView();
        this.menuControl = new MenuControl(this, prompt);
    }

    /**
     * Gets the prompt used for the UI
     *
     * @return the prompt
     */
    public Prompt getPrompt() {
        return prompt;
    }

    /**
     * Gets the bank used by this application
     *
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Gets the id of the customer using the Bank Application
     *
     * @return the customer id
     */
    public int getAccessingCustomerId() {
        return accessingCustomerId;
    }

    /**
     * Starts the bank application
     */
    public void start() {


        accessingCustomerId = loginView.scanCustomerId(bank, prompt);
        menuControl.start();

    }

}
