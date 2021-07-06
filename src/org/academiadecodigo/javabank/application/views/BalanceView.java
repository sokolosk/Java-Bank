package org.academiadecodigo.javabank.application.views;

import org.academiadecodigo.javabank.application.operations.BalanceOperation;
import org.academiadecodigo.javabank.application.operations.Operation;

import java.util.Map;

public class BalanceView {

    private Map<Integer, Operation> operationsMap;


    public void buildBalance(Map map, int userChoice){
        this.operationsMap = map;
        operationsMap.get(userChoice).execute();

    }
}
