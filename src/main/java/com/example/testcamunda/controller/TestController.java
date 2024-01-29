package com.example.testcamunda.controller;

import com.example.testcamunda.camunda.CamundaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final CamundaService camundaService;

    @PostMapping
    public void startProcess(
        @RequestParam("process") String process,
        @RequestParam("expediente_id") String idExpediente) {
        camundaService.startProcess(process, idExpediente);
    }

    @PostMapping("/message")
    public void sendMessage(
        @RequestParam("message") String message,
        @RequestParam("expediente_id") String idExpediente) {
        camundaService.sendMessage(message, idExpediente);
    }
    @PostMapping("/finalizar-tramite")
    public void finalizarTramite(
        @RequestParam("message") String message,
        @RequestParam("expediente_id") String idExpediente,
        @RequestParam("tramite_id") String idTramite) {
        camundaService.finalizarTramite(message, idExpediente, idTramite);
    }
}
