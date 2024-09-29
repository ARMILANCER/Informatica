module org.example.eli {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.eli to javafx.fxml;
    exports org.example.eli;
}
