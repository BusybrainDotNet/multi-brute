package com.itmnetwork;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

public class IndexController {

    @FXML
    private TextField sitename;
    private TextField hostname;
    private TextField username;
    private TextField password;
    private TextField port;
    private TextField timeout;
    private TextField retries;
    private CheckBox anonymous;
    private CheckBox dontsave;
    private CheckBox ssl;
    private CheckBox ccc;
    private CheckBox proxy;
    private CheckBox combo;
    private Button newfile;
    private Button reset;
    private Button close;
    private Button start;
    private Button upload;
    private TextArea list;
    private TextArea comment;
    private Label message;
    private AnchorPane scenePanel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void checkForm(ActionEvent event) throws IOException {

        // String host = hostname.getText();
        // String user = username.getText();
        // String pass = password.getText();
        // String trytime = retries.getText();
        // String outnum = timeout.getText();
        // String portnum = port.getText();

        if (sitename == null) {
            // String site = sitename.getText().trim();
            String name = "Username";
            displayError(name);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("index.fxml"));
        root = loader.load();

    }

    // Close Application
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

    // Display Error Message
    private void displayError(String string) {
        message.setText(string + "Can Not Be An Empty Field");
    }

}
