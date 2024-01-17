package com.example.testcamunda.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class SetValueDelegateTask implements JavaDelegate {
    private final Random random = new Random();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Integer value = random.nextInt();
        delegateExecution.setVariable("value", value);
        log.info("SET VALUE DELEGATE TASK -> value : " + value);
    }
}
