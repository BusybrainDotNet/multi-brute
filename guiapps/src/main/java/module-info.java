module com.itmnetwork {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.itmnetwork to javafx.fxml;
    exports com.itmnetwork;
}
