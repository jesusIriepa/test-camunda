package com.example.testcamunda.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendMessageValueB implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Integer value = (Integer) delegateExecution.getVariable("value");
        log.info("RECEIVED MESSAGE B. Value = " + value);
    }
}
