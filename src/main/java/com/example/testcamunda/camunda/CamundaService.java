package com.example.testcamunda.camunda;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class CamundaService {

    private final RuntimeService runtimeService;

    public void startProcess(String processName, String bussinesId) {
        runtimeService.startProcessInstanceByKey(processName, bussinesId);
    }

    public void sendMessage(String message, String bussinesId, String subId) {
        MessageCorrelationResult result = runtimeService.createMessageCorrelation(message)
            .processInstanceBusinessKey(bussinesId)
            .processInstanceVariableEquals("sub-id", subId)
            .correlateWithResult();
        log.info(result.toString());
    }
}
