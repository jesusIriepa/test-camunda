package com.example.testcamunda.camunda.delegate;

import com.example.testcamunda.camunda.model.NombreFase;
import com.example.testcamunda.camunda.model.NombreTramite;
import com.example.testcamunda.camunda.model.Tramite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.camunda.spin.plugin.variable.value.JsonValue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class IniciarTramiteDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        NombreTramite nombreTramite = NombreTramite.valueOf(
            (String) delegateExecution.getVariable(DelegateConstants.VAR_NOMBRE_TRAMITE));
        Tramite tramite = new Tramite();
        tramite.setIdTramite(UUID.randomUUID().toString());
        tramite.setNombre(nombreTramite);
        tramite.setCompleto(Boolean.FALSE);
        log.info("Añadir tramite al Json General");
        JsonValue jsonFase = delegateExecution.getProcessInstance().getSuperExecution()
            .getVariableTyped(DelegateConstants.VAR_JSON_FASE);
        jsonFase.getValue().prop("tramites").append(Spin.JSON(tramite));
        log.info("Iniciando Tramite: {} - {}", nombreTramite.name(), tramite.getIdTramite());
        delegateExecution.getProcessInstance().getSuperExecution()
                .setVariable(DelegateConstants.VAR_JSON_FASE, jsonFase);
        delegateExecution.setVariable(DelegateConstants.VAR_ID_TRAMITE, tramite.getIdTramite());
        delegateExecution.setVariable(DelegateConstants.VAR_NOMBRE_TRAMITE, nombreTramite.name());
    }
}
