package com.example.testcamunda.camunda.delegate;

import com.example.testcamunda.camunda.model.NombreFase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FinalizarFaseDelegate implements JavaDelegate {

    private final ObjectMapper objectMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String idFase = (String)delegateExecution.getVariable(DelegateConstants.VAR_ID_FASE);
        NombreFase nombreFase =  NombreFase.valueOf(
            (String) delegateExecution.getVariable(DelegateConstants.VAR_NOMBRE_FASE));
        log.info("Finalizando fase: {} - {}", nombreFase.name(), idFase);
    }
}
