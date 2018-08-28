package com.demo.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import com.demo.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;
import static com.demo.akka.SpringExtension.SPRING_EXTENSION_PROVIDER;

/**
 * 控制类;
 * on 2018/08/13 by vitty;
 */
@RestController
@RequestMapping(value = "/demo")
public class ContractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    ContractService contract0Service;
    @Autowired
    ActorSystem actorSystem;
    /**
     * test方法;
     */
    @RequestMapping(method = RequestMethod.GET)
    public String testConnect() {
        return "connect OK.";
    }

    /**
     * 执行空;
     */
    @RequestMapping(value = "/ct0", method = RequestMethod.GET)
    public Boolean handleContract0() {
        //计算耗时;
        long startTime = System.currentTimeMillis();
        boolean rtn = contract0Service.handleContract();
        LOGGER.info("handleContract0 耗时(毫秒):"+(System.currentTimeMillis()-startTime));
        return rtn;
    }

    /**
     * 采用akka方式压测;
     * @return
     */
    @RequestMapping(value = "/akka", method = RequestMethod.GET)
    public Boolean handleContractAkka() {
        //生成随机数;
        String uuid = UUID.randomUUID().toString();
        ActorRef contractRef = actorSystem.actorOf(SPRING_EXTENSION_PROVIDER.get(actorSystem).props("contractActor"), uuid);
        FiniteDuration duration = FiniteDuration.create(1, TimeUnit.SECONDS);
        Timeout timeout = Timeout.durationToTimeout(duration);
        Future<Object> result = ask(contractRef, uuid, timeout);
        try {
            return (Boolean)Await.result(result, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
