package com.example.testcamunda.camunda.delegate;

import com.example.testcamunda.camunda.model.Fase;
import com.example.testcamunda.camunda.model.NombreFase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.plugin.variable.SpinValues;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class IniciarFaseDelegate implements JavaDelegate {

    private final ObjectMapper objectMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        NombreFase nombreFase =  NombreFase.valueOf(
            (String) delegateExecution.getVariable(DelegateConstants.VAR_NOMBRE_FASE));
        log.info("Iniciando fase: {}", nombreFase);
        Fase fase = new Fase();
        fase.setNombreFase(nombreFase);
        fase.setIdFase(UUID.randomUUID().toString());
        delegateExecution.setVariable(DelegateConstants.VAR_ID_FASE, fase.getIdFase());
        delegateExecution.setVariable(
            DelegateConstants.VAR_JSON_FASE,
            SpinValues.jsonValue(objectMapper.writeValueAsString(fase)).create());
    }
}
