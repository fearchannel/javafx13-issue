package me.project.mosaic.login;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private JFXButton confirmButton;

    @FXML
    private Label errorLabel;

    @FXML
    private ImageView fecharImage;

    @FXML
    private ImageView minimizarImage;

    private Stage currentStage;

    private void fazLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (!emailField.getText().equals("") && !passwordField.getText().equals("")) {
            confirmButton.setDisable(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        minimizarImage.setOnMouseClicked(event -> {
            currentStage = (Stage) fecharImage.getScene().getWindow();
            currentStage.setIconified(true);
        });
        fecharImage.setOnMouseClicked(event -> System.exit(0));
        confirmButton.setOnAction(event -> fazLogin());
        passwordField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                fazLogin();
            }
        });
    }

}
