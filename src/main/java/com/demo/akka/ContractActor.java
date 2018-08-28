package com.demo.akka;

import akka.actor.UntypedActor;
import com.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ContractActor extends UntypedActor {

    @Autowired
    private ContractService contractService;

    public ContractActor(ContractService contractService) {
        this.contractService = contractService;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            System.out.println("uuid: "+message);
            getSender().tell(contractService.handleContract(), getSelf());
        } else {
            unhandled(message);
        }
    }
}
