package com.yrgo.services.calls;

import com.yrgo.domain.Action;
import com.yrgo.domain.Call;
import com.yrgo.services.customers.CustomerManagementService;
import com.yrgo.services.customers.CustomerNotFoundException;
import com.yrgo.services.diary.DiaryManagementService;

import java.util.Collection;

public class CallHandlingServiceImpl implements CallHandlingService{
    private CustomerManagementService customers;
    private DiaryManagementService diaries;

    public CallHandlingServiceImpl(CustomerManagementService customers, DiaryManagementService diaries){
        this.customers = customers;
        this.diaries = diaries;
    }

    @Override
    public void recordCall(String customerId, Call newCall,
                           Collection<Action> actions) throws CustomerNotFoundException {
        customers.recordCall(customerId, newCall);

        for (Action action : actions) {
            diaries.recordAction(action);
        }
    }
}
