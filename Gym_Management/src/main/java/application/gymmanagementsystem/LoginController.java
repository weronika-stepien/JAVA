package application.gymmanagementsystem;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class LoginController implements Initializable, Maintenance {

      //    FXML Widgets
      @FXML
      private AnchorPane main_form;

      @FXML
      private Button close;

      @FXML
      private FontAwesomeIcon close_icon;

      @FXML
      private AnchorPane left_form;

      @FXML
      private Button lForm_signUpButton;

      @FXML
      private Label edit_label;

      @FXML
      private AnchorPane right_form;

      @FXML
      private TextField rForm_username;

      @FXML
      private PasswordField rForm_password;

      @FXML
      private Button rForm_loginButton;

      @FXML
      private AnchorPane reg_form;

      @FXML
      private TextField reg_email;

      @FXML
      private TextField reg_username;

      @FXML
      private PasswordField reg_password;

      @FXML
      private Button reg_signUpButton;

      @FXML
      private Button lForm_signInButton;

      //    Database tools
      private Connection connect;
      private PreparedStatement preparedStatement;
      private ResultSet resultSet;

      String sql;

      //    Maintenance
      TranslateTransition transition1;
      TranslateTransition transition2;

      Stage stage;
      static String username;

      public void login() {
            sql = "SELECT * FROM admin WHERE username = ? and password = ?";

            connect = Database.connectDb();

            try {
                  preparedStatement = connect.prepareStatement(sql);
                  preparedStatement.setString(1, rForm_username.getText());
                  preparedStatement.setString(2, rForm_password.getText());
                  resultSet = preparedStatement.executeQuery();

                  //    Saving username
                  username = rForm_username.getText();

                  if (rForm_username.getText().isEmpty() || rForm_password.getText().isEmpty()) {
                        Maintenance.emptyAlert();
                  }
                  else {
                        if (resultSet.next()) {
                              Maintenance.infoAlert("Successfully logged in.");

                              //    To change the scene to the dashboard
                              Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                              stage = new Stage();
                              Scene scene = new Scene(root);

                              Maintenance.customBar(root, stage, scene);

                              stage.setScene(scene);
                              stage.show();

                              //    To hide a login form
                              rForm_loginButton.getScene().getWindow().hide();
                        }
                        else {
                              Maintenance.errorAlert("Incorrect password or username. ");
                        }
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
            }
      }


      public void register() {
            sql = "INSERT INTO admin (email, username, password) VALUES (?, ?, ?)";
            connect = Database.connectDb();

            try {
                  if (reg_email.getText().isEmpty() || reg_username.getText().isEmpty() || reg_password.getText().isEmpty()) {
                        Maintenance.emptyAlert();
                  }
                  else {
                        if (reg_password.getText().length() < 8) {
                              Maintenance.errorAlert("Password needs to be min. 8 characters.");
                        }
                        else {
                              preparedStatement = connect.prepareStatement(sql);
                              preparedStatement.setString(1, reg_email.getText());
                              preparedStatement.setString(2, reg_username.getText());
                              preparedStatement.setString(3, reg_password.getText());

                              Maintenance.infoAlert("Account created successfully!");

                              preparedStatement.executeUpdate();

                              reg_email.setText("");
                              reg_username.setText("");
                              reg_password.setText("");
                        }
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
            }
      }


      public void registerSliding() {
            transition1 = new TranslateTransition();
            transition1.setNode(left_form);
            transition1.setToX(300);
            transition1.setDuration(Duration.seconds(.5));
            transition1.play();
            transition1.setOnFinished((ActionEvent action)
                            ->
                    {
                          edit_label.setText("Login Account");
                          close_icon.setFill(Color.valueOf("#fff"));



                          lForm_signInButton.setVisible(true);
                          lForm_signUpButton.setVisible(false);
                    }
                                     );
      }



      public void loginSliding() {
            transition2 = new TranslateTransition();
            transition2.setNode(left_form);
            transition2.setToX(0);
            transition2.setDuration(Duration.seconds(.5));
            transition2.play();

            close_icon.setFill(Color.valueOf("#000"));

            transition2.setOnFinished((ActionEvent action)
                            ->
                    {

                          edit_label.setText("Register Account");

                          lForm_signInButton.setVisible(false);
                          lForm_signUpButton.setVisible(true);

                    }
                                     );
      }




      public void close() {
            Maintenance.close();
      }

      @Override
      public void initialize(URL url, ResourceBundle resourceBundle) {

      }
}
