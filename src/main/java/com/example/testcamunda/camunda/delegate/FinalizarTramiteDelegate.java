package com.example.testcamunda.camunda.delegate;

import com.example.testcamunda.camunda.model.NombreFase;
import com.example.testcamunda.camunda.model.NombreTramite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FinalizarTramiteDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String idTramite = (String)delegateExecution.getVariable(DelegateConstants.VAR_ID_TRAMITE);
        NombreTramite nombreTramite =  NombreTramite.valueOf(
            (String) delegateExecution.getVariable(DelegateConstants.VAR_NOMBRE_TRAMITE));
        log.info("Finalizando tramite: {} - {}", nombreTramite.name(), idTramite);
    }
}
