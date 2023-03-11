package com.itmnetwork;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IndexController implements Initializable {

    @FXML
    private TextField sitename, port, hostname;
    @FXML
    private CheckBox anonymous, dontsave, ssl, ccc, proxy, combo;
    @FXML
    private RadioButton thread1, thread2, thread3, thread4, thread5, thread6;
    @FXML
    private Spinner<Integer> retries, timeout;
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
        message.setText("");
        // Invoke Form Field Validation
        fieldValidation();

    }

    // Validate Form Fields
    private void fieldValidation() {
        String site = sitename.getText();
        String host = hostname.getText();
        String portnum = port.getText();
        String proxys = proxylist.getText();
        String combos = combolist.getText();

        if (site.isEmpty()) {
            String name = "Site Name";
            formValidationError(name);
        } else if (host.isEmpty()) {
            String name = "Host Name";
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
        } else {
            connectURL();
        }
    }

    // Display Error Message
    private void formValidationError(String string) {
        message.setTextFill(Color.RED);
        message.setText("ERROR: " + string + " Can't Be Empty");
    }

    // Reset Form Fields
    public void resetFormFields(ActionEvent event) {
        sitename.clear();
        hostname.clear();
        port.clear();
        combolist.clear();
        proxylist.clear();
        message.setText("");
    }

    // Close Application Button
    public void closePanel(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Close Application");
        alert.setHeaderText("You Are About To Close This Application");
        alert.setContentText("Hey, Do You Really Want To Close This Application?");
        message.setText("");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePanel.getScene().getWindow();
            stage.close();
        }
    }

    // Check For Internet Connection
    public void connectURL() {
        String host = hostname.getText();
        try {
            URL url = new URL(host);
            URLConnection connection = url.openConnection();
            connection.connect();
            message.setTextFill(Color.GREEN);
            message.setText("Loading: Please Wait, Process Is Ongoing...");
        } catch (Exception e) {
            message.setTextFill(Color.RED);
            message.setText("ERROR: Internet Is Not Connected!");
        }
    }

    // Spinners Setting
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 9);
        valueFactory.setValue(3);
        retries.setValueFactory(valueFactory);

        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 60);
        valueFactory1.setValue(30);
        timeout.setValueFactory(valueFactory1);
    }

}
