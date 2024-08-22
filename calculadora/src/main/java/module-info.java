module com.projetossala.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens com.projetossala.calculadora to javafx.fxml;
    exports com.projetossala.calculadora;
}