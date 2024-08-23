package com.projetossala.calculadora.utils;

import javafx.scene.control.Alert;

public class Alerta {
    public Alert invocarAlerta(String titulo, String conteudo){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(conteudo);
        return alerta;
    }
}
