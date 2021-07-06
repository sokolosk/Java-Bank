package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.views.BalanceView;
import org.academiadecodigo.javabank.application.views.DepositView;

import java.util.Map;

public class DepositControl {

    private DepositView depositView;
    private Map<Integer, Operation> operationsMap;

    public DepositControl(){
        this.depositView = new DepositView();
    }


    public void init(Map map, int choice){
        this.operationsMap = map;

        if(depositView.buildDepositView(map, choice)){
            operationsMap.get(choice).execute();
        }


    }
}
