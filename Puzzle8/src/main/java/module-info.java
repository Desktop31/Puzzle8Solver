module com.example.puzzle8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.puzzle8 to javafx.fxml;
    exports com.example.puzzle8;
}