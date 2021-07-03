package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.managers.AccountVerification;

import java.util.Scanner;

public class BankInterface {

    private Bank bank;
    private AccountManager accountManager;
    private AccountVerification accountVerification;
    private Customer customer;


    public BankInterface(){
        accountManager = new AccountManager();
        bank = new Bank(accountManager);
        customer = new Customer();
    }

    public void init() {
        bank.addCustomer(customer);
        System.out.println(customer.openAccount(AccountType.CHECKING));
        System.out.println(customer.openAccount(AccountType.SAVINGS));


        Prompt prompt = new Prompt(System.in, System.out);
        Scanner scan = new Scanner(System.in);

        IntegerInputScanner userID = new IntegerInputScanner();
        userID.setMessage("Please insert the customer ID: \n");
        int showID = prompt.getUserInput(userID);
        System.out.println(showID + " user ID");

        accountVerification = new AccountVerification(customer);

        if (accountVerification.verify(showID)){
            System.out.println("Java Bank Client");
        }
        else{
            System.out.println("");
            String[] newCustomer = {"Yes", "No"};
            MenuInputScanner scanner1 = new MenuInputScanner(newCustomer);
            scanner1.setMessage("Create new account?");
            int answer = prompt.getUserInput(scanner1);
            System.out.println(newCustomer[answer - 1]);
            if (answer==1) {
                bank.addCustomer(customer);
                System.out.println(customer.openAccount(AccountType.SAVINGS));
                System.out.println(customer.openAccount(AccountType.CHECKING));


            }
            else{
                System.out.println("Thanks for comming");
                System.exit(0);
            }

        }
while(true) {
    String[] options = {"View Balance", "Make Deposit", "Make Withdraw", "Open Account", "Transfer Money", "Quit"};
    MenuInputScanner scanner = new MenuInputScanner(options);
    scanner.setMessage("Welcome to Java Bank");
    int answerIndex = prompt.getUserInput(scanner);
    System.out.println(options[answerIndex - 1]);

    switch (answerIndex){
        case 1:
            System.out.println("which account do you want to get balance?");
            int balance = scan.nextInt();
            System.out.println("Your balance is: " + customer.getBalance(balance));

            break;

        case 2:
            System.out.println("How much do you want deposit?");
            int value = scan.nextInt();
            accountManager.deposit(showID,value);
            System.out.println("Your balance is: " + customer.getBalance(showID));
            break;
        case 3:
            System.out.println("How much do you want withdraw?");
            int value2 = scan.nextInt();
            accountManager.withdraw(showID,value2);
            System.out.println("Your balance is: " + customer.getBalance(showID));
            break;
        case 4:
            String[] newAccount = {"Checking Account", "Saving Account"};
            MenuInputScanner scanner1 = new MenuInputScanner(newAccount);
            scanner1.setMessage("Create which account?");
            int accountType = prompt.getUserInput(scanner1);
            System.out.println(newAccount[accountType - 1]);
            if (accountType==1){
                customer.openAccount(AccountType.CHECKING);
                System.out.println("opening checking account");
            }
            else {
                customer.openAccount(AccountType.SAVINGS);
                System.out.println("opening saving account");
            }
            break;
        case 5:
            System.out.println("Select account from: ");
            int account1 = scan.nextInt();
            System.out.println("Select account to: ");
            int account2 = scan.nextInt();
            System.out.println("Amount to transfer: ");
            int amount = scan.nextInt();
            accountManager.transfer(account1,account2, amount);
            System.out.println("Balance in account = " + account1 + customer.getBalance(account1));
            System.out.println("Balance in account = " + account2 + customer.getBalance(account2));
            break;
        case 6:
            System.out.println("Thanks for comming");
            System.exit(0);

    }
}
    }
}
