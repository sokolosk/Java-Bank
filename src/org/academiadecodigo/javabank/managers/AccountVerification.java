package org.academiadecodigo.javabank.managers;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

public class AccountVerification {

    private int id;
    private Customer customer;
    private Account account;

    public AccountVerification(Customer customer){
        this.customer = customer;
    }
    public boolean verify(int id){
        this.id = id;
        if(customer.hasAccount(id)) {
            System.out.println("has account");
            return true;
        }
        System.out.println("don't have account");
        return false;
    }

}
