package com.example.controlependencias;

import com.example.controlependencias.controller.PendenciaController;
import com.example.controlependencias.dao.PendenciaDAO;
import com.example.controlependencias.view.PendenciaView;

public class Main {
    public static void main(String[] args) {
        PendenciaDAO pendenciaDAO = new PendenciaDAO();
        PendenciaView pendenciaView = new PendenciaView();
        PendenciaController pendenciaController = new PendenciaController(pendenciaDAO, pendenciaView);

        pendenciaController.iniciarAplicacao();
    }
}

