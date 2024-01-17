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
        @RequestParam("bussines_id") String bussinesId) {
        camundaService.startProcess(process, bussinesId);
    }

    @PostMapping("/message")
    public void sendMessage(
        @RequestParam("message") String message,
        @RequestParam("bussines_id") String bussinesId,
        @RequestParam("sub_id") String subId) {
        camundaService.sendMessage(message, bussinesId, subId);
    }
}
