module com.example.testdesk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testdesk to javafx.fxml;
    exports com.example.testdesk;
}