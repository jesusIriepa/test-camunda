package com.example.testcamunda.camunda.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Fase {
    private String idExpediente;
    private String idFase;
    private NombreFase nombreFase;
    private List<Tramite> tramites = new ArrayList<>();
}
