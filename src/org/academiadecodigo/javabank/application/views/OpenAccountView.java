package org.academiadecodigo.javabank.application.views;

import org.academiadecodigo.javabank.application.operations.Operation;

import java.util.Map;

public class OpenAccountView {

    private Map<Integer, Operation> operationsMap;


    public void buildOpenAccountView(Map map, int userChoice){
        this.operationsMap = map;
        operationsMap.get(userChoice).makenewOperation();

    }
}
