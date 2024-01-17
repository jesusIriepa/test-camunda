package com.example.testcamunda.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogDelegateTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String input = (String) delegateExecution.getVariable("input");
        String value = (String) delegateExecution.getVariable("value");
        log.info("LOG DELEGATE TASK -> input: " + input + " / value: " + value);
    }
}
