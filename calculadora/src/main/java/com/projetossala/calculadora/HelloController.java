package com.projetossala.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class HelloController {


    @FXML
    private TextField construcao;

    @FXML
    private Label resultado;

    @FXML
    private boolean verifica(String c){

        // também não pode deixar começar com algum dos simbolos proibidos

        boolean quebrou = false;
        Set<Character> simbolosProibidos = Set.of('+','-', 'x', '/'); // consertar para **
        char ant, now;
        if(c.length()>2){
            ant = c.charAt(c.length()-2);
            now = c.charAt(c.length()-1);

            if (simbolosProibidos.contains(ant) && simbolosProibidos.contains(now))
                quebrou = true;
         }

        return quebrou;

    }

    @FXML
    private void add(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        if (!verifica(construcao.getText()+botaoClicado.getText()))
            construcao.setText(construcao.getText()+botaoClicado.getText());
    }
    @FXML
    private void del(ActionEvent event){
        construcao.setText(construcao.getText().substring(0, construcao.getLength()-2));
    }
    @FXML
    private void calcular(ActionEvent event) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        resultado.setText((String) engine.eval(construcao.getText()));
    }
}