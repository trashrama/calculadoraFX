module com.projetossala.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projetossala.calculadora to javafx.fxml;
    exports com.projetossala.calculadora;
}