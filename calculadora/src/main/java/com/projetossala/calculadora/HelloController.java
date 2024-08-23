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
    private String nAtual = "";
    private char op;
    private Float n1, n2; // pra eu poder pegar null
    private boolean orgN1 = false;

    Set<Character> simbolosProibidos = Set.of('+','-', 'x', '/'); // consertar para **


    @FXML
    private Label resultado;

    @FXML
    private float adicao(float n1, float n2){
        return n1+n2;
    }

    private float subt(float n1, float n2){
        return n1-n2;
    }

    @FXML
    private boolean repetiu(String c){

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
    private boolean organizaN1(){
        int pos = 0;

        for (char c: nAtual.toCharArray()){
            if (simbolosProibidos.contains(c)){
                if (n1 == null){
                    n1 = Float.parseFloat(nAtual.substring(0, pos));
                    op = c;
                    nAtual = "";
                    System.out.println("chegou a termina");
                    return true;
                }

            }
            pos++;
        }

        return false;

    }


    @FXML
    private void add(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        if (!repetiu(construcao.getText()+botaoClicado.getText())) {
            construcao.setText(construcao.getText() + botaoClicado.getText());
            nAtual += botaoClicado.getText();
            System.out.println(nAtual);
            if (!orgN1)
                orgN1 = organizaN1();


        }


    }
    @FXML
    private void del(ActionEvent event){
        construcao.setText(construcao.getText().substring(0, construcao.getLength()-1));
    }
    @FXML
    private void calcular(ActionEvent event) throws ScriptException {

        if (n1 != null){
            n2 = Float.parseFloat(nAtual);
            switch(op){
                case '+':
                    resultado.setText(String.valueOf(adicao(n1, n2)));
                    break;
                case '-':
                    resultado.setText(String.valueOf(subt(n1, n2)));
                    break;
                case 'x':
                    resultado.setText(String.valueOf(mult(n1, n2)));
                    break;
                case 'x':
                    resultado.setText(String.valueOf(mult(n1, n2)));
                    break;
            }
        }
    }
}