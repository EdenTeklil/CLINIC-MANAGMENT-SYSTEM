module com.example.cms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cms to javafx.fxml;
    exports com.example.cms;
}