package com.projetossala.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class HelloController {


    @FXML
    private TextField construcao;
    private String nAtual;

    private Integer n1, n2;
    private float r;
    Set<Character> simbolosProibidos = Set.of('+','-', 'x', '/'); // consertar para **


    @FXML
    private Label resultado;

    @FXML
    private boolean verifica(String c){

        // talvez nem vou precisar
        // também não pode deixar começar com algum dos simbolos proibidos

        boolean quebrou = false;
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
    private void organiza(String cons){
        int pos = 0;

        for (char c: cons.toCharArray()){
            if (simbolosProibidos.contains(c)){
                if (n1 == null){
                    n1 = Integer.parseInt(cons.substring(0, pos));
                }
            }
            pos++;
        }

    }


    @FXML
    private void add(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        //if (!verifica(construcao.getText()+botaoClicado.getText()))
        construcao.setText(construcao.getText()+botaoClicado.getText());
        nAtual += botaoClicado.getText();
    }
    @FXML
    private void del(ActionEvent event){
        construcao.setText(construcao.getText().substring(0, construcao.getLength()-1));
    }
    @FXML
    private void calcular(ActionEvent event) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(((String) engine.eval(construcao.getText())));
        //resultado.setText);
    }
}