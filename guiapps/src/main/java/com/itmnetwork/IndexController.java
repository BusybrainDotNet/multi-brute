package com.itmnetwork;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// import javafx.scene.Parent;
// import javafx.scene.Scene;

public class IndexController {

    @FXML
    private TextField sitename, hostname, username, password, port, timeout, retries;
    @FXML
    private CheckBox anonymous, dontsave, ssl, ccc, proxy, combo;
    @FXML
    private Button reset, close, start;
    @FXML
    private TextArea combolist, proxylist, resultlist;
    @FXML
    private Label message;
    @FXML
    private AnchorPane scenePanel;

    private Stage stage;
    // private Scene scene;
    // private Parent root;

    // Start Brute Button
    public void checkForm(ActionEvent event) throws IOException {

        // Invoke Form Field Validation
        fieldValidation();

    }

    // Validate Form Fields
    private void fieldValidation() {
        String site = sitename.getText();
        String host = hostname.getText();
        String user = username.getText();
        String pass = password.getText();
        String trytime = retries.getText();
        String outnum = timeout.getText();
        String portnum = port.getText();
        String proxys = proxylist.getText();
        String combos = combolist.getText();

        if (site.isEmpty()) {
            String name = "Site Name";
            formValidationError(name);
        } else if (host.isEmpty()) {
            String name = "Host Name";
            formValidationError(name);
        } else if (user.isEmpty()) {
            String name = "Username";
            formValidationError(name);
        } else if (pass.isEmpty()) {
            String name = "Password";
            formValidationError(name);
        } else if (trytime.isEmpty()) {
            String name = "Retries";
            formValidationError(name);
        } else if (outnum.isEmpty()) {
            String name = "Timeout";
            formValidationError(name);
        } else if (portnum.isEmpty()) {
            String name = "Port";
            formValidationError(name);
        } else if (proxy.isSelected() && proxys.isEmpty()) {
            String name = "Proxy List";
            formValidationError(name);
        } else if (combo.isSelected() && combos.isEmpty()) {
            String name = "Combo List";
            formValidationError(name);
        }
    }

    // Display Error Message
    private void formValidationError(String string) {
        message.setText("ERROR: " + string + " Can't Be Empty");
    }

    // Reset Form Fields
    public void resetFormFields(ActionEvent event) {
        sitename.clear();
        hostname.clear();
        username.clear();
        password.clear();
        retries.clear();
        timeout.clear();
        port.clear();
        combolist.clear();
        proxylist.clear();
    }

    // Close Application Button
    public void closePanel(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Close Application");
        alert.setHeaderText("You Are About To Close This Application");
        alert.setContentText("Hey, Do You Really Want To Close This Application?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePanel.getScene().getWindow();
            stage.close();
        }
    }

}
