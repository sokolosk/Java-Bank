package org.academiadecodigo.javabank.application.views;

import org.academiadecodigo.javabank.application.operations.Operation;

import java.util.Map;

public class WithDrawView {

    private Map<Integer, Operation> operationsMap;


    public boolean buildWithdrawView(Map map, int userChoice){
        this.operationsMap = map;
        return operationsMap.get(userChoice).makenewOperation();

    }
}
