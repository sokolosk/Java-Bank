package org.academiadecodigo.javabank.application.controls;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.views.DepositView;
import org.academiadecodigo.javabank.application.views.WithDrawView;

import java.util.Map;

public class WithdrawControl {

    private WithDrawView withdrawView;
    private Map<Integer, Operation> operationsMap;

    public WithdrawControl(){
        this.withdrawView = new WithDrawView();
    }


    public void init(Map map, int choice){
       this.operationsMap = map;
       if(withdrawView.buildWithdrawView(map, choice)){
           operationsMap.get(choice).execute();
       }

    }}
