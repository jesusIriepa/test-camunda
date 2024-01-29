package com.example.testcamunda.camunda.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tramite {
    private String idTramite;
    private NombreTramite nombre;
    private Boolean completo;
    private List<Accion> acciones = new ArrayList<>();
}
