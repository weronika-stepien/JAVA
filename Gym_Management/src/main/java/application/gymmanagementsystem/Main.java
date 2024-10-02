package application.gymmanagementsystem;

import javafx.application.Application;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.stage.*;

import java.io.IOException;

public class Main extends Application {

      @Override
      public void start(Stage stage) throws IOException {
            //    Loading fxml file
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Scene scene = new Scene(root);

            Maintenance.customBar(root, stage, scene);

            stage.setScene(scene);
            stage.show();
      }

      public static void main(String[] args) {
            launch(args);
      }
}