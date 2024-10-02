package application.gymmanagementsystem;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public interface Maintenance {
      static void close() {
            Platform.exit();
      }

      static void minimize(Stage stage, AnchorPane anchorPane) {
            stage = (Stage) anchorPane.getScene().getWindow();
            stage.setIconified(true);
      }


      static void customBar(Parent someRoot, Stage someStage, Scene someScene) {
            final double[] x = {0};
            final double[] y = {0};

            someRoot.setOnMousePressed(
                    event ->
                    {
                          x[0] = event.getSceneX();
                          y[0] = event.getSceneY();
                          someStage.setOpacity(0.8);

                    });

            someRoot.setOnMouseDragged(
                    event ->
                    {
                          someStage.setX(event.getScreenX() - x[0]);
                          someStage.setY(event.getScreenY() - y[0]);
                          someStage.setOpacity(0.8);
                    }
                                      );

            someRoot.setOnMouseReleased(
                    event ->
                            someStage.setOpacity(1)
                                       );
            someStage.initStyle(StageStyle.TRANSPARENT);
            someStage.setScene(someScene);
            someStage.show();


      }

      static void setUserName(Label label) {
            label.setText(LoginController.username);
      }

      static void emptyAlert() {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the blank fields.");
            alert.showAndWait();
      }

      static void errorAlert(String text) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText(text);
            alert.showAndWait();
      }

      static void infoAlert(String text) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFO");
            alert.setHeaderText(null);
            alert.setContentText(text);
            alert.showAndWait();
      }


}






