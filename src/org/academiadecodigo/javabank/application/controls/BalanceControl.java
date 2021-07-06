package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.views.BalanceView;

import java.util.Map;

public class BalanceControl {

    private BalanceView balanceView;
    private Map<Integer, Operation> operationsMap;

    public BalanceControl(){
        this.balanceView = new BalanceView();
    }


    public void init(Map map, int choice){
        this.operationsMap = map;
        balanceView.buildBalance(map, choice);

    }
}
