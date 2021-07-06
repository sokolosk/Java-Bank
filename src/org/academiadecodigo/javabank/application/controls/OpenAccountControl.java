package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.views.DepositView;
import org.academiadecodigo.javabank.application.views.OpenAccountView;

import java.util.Map;

public class OpenAccountControl {

    private OpenAccountView openAccountView;
    private Map<Integer, Operation> operationsMap;

    public OpenAccountControl(){
        this.openAccountView = new OpenAccountView();
    }


    public void init(Map map, int choice){
        this.operationsMap = map;
        openAccountView.buildOpenAccountView(map, choice);
        operationsMap.get(choice).execute();

    }
}
