package com.projetossala.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloController {


    @FXML
    private TextField construcao;

    @FXML
    private boolean verifica(String c){
        boolean quebrou = false;
        String[] simbolosProibidos = {"+","-", "*", "/"}; // consertar para **
        if(construcao.getLength()>0){
            for(String s: simbolosProibidos){
                if (s.equals(construcao.getText().substring(construcao.getLength()-1))){
                    quebrou = true;
                }
            }
            if (construcao.getText().substring(construcao.getLength()-1).equals(c))
                quebrou = true;

        }
        return quebrou;

    }

    @FXML
    private void add(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        if (!verifica(botaoClicado.getText()))
            construcao.setText(construcao.getText()+botaoClicado.getText());
    }

    private void del(ActionEvent event){
        construcao.setText(construcao.getText().substring(0, construcao.getLength()-2));
    }
}