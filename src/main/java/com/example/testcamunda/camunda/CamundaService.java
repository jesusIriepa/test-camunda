package com.example.testcamunda.camunda;

import com.example.testcamunda.camunda.delegate.DelegateConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CamundaService {

    private final RuntimeService runtimeService;

    public void startProcess(String processName, String idExpediente) {
        runtimeService.createMessageCorrelation("MSG_Iniciar_Fase_Instruccion")
                .setVariable(DelegateConstants.VAR_ID_EXPEDIENTE, idExpediente)
                    .correlate();
    }

    public void sendMessage(String message, String idExpediente) {
        runtimeService.createMessageCorrelation(message)
            .setVariable(DelegateConstants.VAR_ID_EXPEDIENTE, idExpediente)
            .correlate();
    }

    public void finalizarTramite(String message, String idExpediente, String idTramite) {
        runtimeService.createMessageCorrelation(message)
            .setVariable(DelegateConstants.VAR_ID_EXPEDIENTE, idExpediente)
            .setVariable(DelegateConstants.VAR_ID_TRAMITE, idTramite)
            .correlate();
    }
}
