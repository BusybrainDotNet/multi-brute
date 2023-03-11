module com.itmn {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.itmn to javafx.fxml;
    exports com.itmn;
}
