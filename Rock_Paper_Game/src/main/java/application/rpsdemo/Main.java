package application.rpsdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
      private ImageView backgroundImg;

      @Override
      public void start(Stage stage) throws IOException {
//    Creating picture
            Image image = new Image(new FileInputStream("/home/W/IT/JAVA/PORTFOLIO/RPSdemo/src/main/resources/application/rpsdemo/pictures/background.jpg"));
            this.backgroundImg = new ImageView(image);
            backgroundImg.setFitWidth(790);
            backgroundImg.setFitHeight(544);
            backgroundImg.setOpacity(0.5);

//    Loading fxml file
            Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));

//    Setting the picture as a background and adding fmxl file
            Group group = new Group();
            group.getChildren().add(backgroundImg);
            group.getChildren().add(root);

//    Scene settings
            Scene scene = new Scene(group, 790, 544);
//    Stage settings
            stage.setTitle("RPSdemo");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();


      }

      public static void main(String[] args) {
            launch(args);
      }

}