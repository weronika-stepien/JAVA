package application.earth3d;

import javafx.animation.AnimationTimer;
import javafx.beans.property.*;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.*;
import javafx.stage.Stage;

import java.io.*;

public class Application extends javafx.application.Application {
      private static final float WIDTH = 800;
      private static final float HEIGHT = 600;

      private final Sphere sphere = new Sphere(150);
      private Slider slider;

      private double anchorX, anchorY;
      private double anchorAngleX = 0;
      private double anchorAngleY = 0;
      private final DoubleProperty angleX = new SimpleDoubleProperty(0);
      private final DoubleProperty angleY = new SimpleDoubleProperty(0);

      @Override
      public void start(Stage stage) throws IOException {
            Camera camera = new PerspectiveCamera(true);
            camera.setNearClip(1);
            camera.setFarClip(10000);
            camera.translateZProperty().set(-1000);

            slider = setSlider();

            //  Creating SmartGroup object
            SmartGroup world = new SmartGroup();
            world.getChildren().add(globeEarth());
            world.translateZProperty().bind(slider.valueProperty());

            //  Creating a Group object to make background image independent to the sphere
            Group root = new Group();
            root.getChildren().add(world);
            root.getChildren().add(setBackImg());
            root.getChildren().add(slider);

            Scene scene = new Scene(root, WIDTH, HEIGHT, true);
            scene.setFill(Color.SILVER);
            scene.setCamera(camera);

            // Calling Mouse control method
            mouseControl(world, scene, stage);

            //  Setting up the stage
            stage.setTitle("Earth 3D");
            stage.setScene(scene);
            stage.show();

            //  Calling a method responsible for rotating the sphere
            rotationAnimation();

      }

      //  Creating a method which will rotate the sphere
      private void rotationAnimation() {
            AnimationTimer animationTimer = new AnimationTimer() {
                  @Override
                  public void handle(long now) {
                        sphere.rotateProperty().set(sphere.getRotate() + 0.05); // The higher the added value the higher speed od spinning
                  }
            };

            animationTimer.start();
      }

      //  Creating a method that will set background image
      private ImageView setBackImg() throws FileNotFoundException {
            Image image = new Image(getClass().getResourceAsStream("/space.jpg"));
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.getTransforms().add(new Translate(-image.getWidth() / 2, -image.getHeight() / 2, 800));

            return imageView;
      }

      //  Creating a method that creates slider object
      private Slider setSlider() {
            Slider slider = new Slider();
            slider.setOrientation(Orientation.VERTICAL);
            slider.setMax(800);
            slider.setMin(-400);
            slider.setValue(0);
            slider.setPrefWidth(300d);
            slider.setLayoutX(150);
            slider.setLayoutY(100);
            slider.setShowTickLabels(true);
            slider.setMajorTickUnit(100);
            slider.setTranslateZ(10);
            slider.setStyle("-fx-base: black");
            return slider;
      }

      //  Creating a method that sets sphere texture
      private Node globeEarth() throws FileNotFoundException {
            PhongMaterial earthMaterial = new PhongMaterial();

            //  Setting rectangular texture over a sphere
            earthMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("/world.jpg")));
            //  Setting illumination over the world map
            earthMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/world-lights.jpg")));
            //  Setting shadows
            earthMaterial.setSpecularMap(new Image(getClass().getResourceAsStream("/shadows2.png")));
            //  Setting bumps aka mountains etc.
            earthMaterial.setBumpMap(new Image(getClass().getResourceAsStream("/bumps.jpg")));

            sphere.setRotationAxis(Rotate.Y_AXIS);
            sphere.setMaterial(earthMaterial);
            return sphere;
      }

      //  Creating a method that will enable rotating the earth by mouse
      private void mouseControl(SmartGroup group, Scene scene, Stage stage) {
            Rotate xRotate;
            Rotate yRotate;
            group.getTransforms().addAll
                    (
                            xRotate = new Rotate(0, Rotate.X_AXIS),
                            yRotate = new Rotate(0, Rotate.Y_AXIS)
                    );
            xRotate.angleProperty().bind(angleX);
            yRotate.angleProperty().bind(angleY);

            scene.setOnMousePressed
                    (event ->
                            {
                                  anchorX = event.getSceneX();
                                  anchorY = event.getSceneY();
                                  anchorAngleX = angleX.get();
                                  anchorAngleY = angleY.get();
                            }
                    );

            scene.setOnMouseDragged
                    (event ->
                            {
                                  angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
                                  angleY.set(anchorAngleY + (anchorX - event.getSceneX()));
                            }
                    );

      }


      class SmartGroup extends Group {
            Rotate rotate;
            Transform transform = new Rotate();

            void rotateByX(int angle) {
                  rotate = new Rotate(angle, Rotate.X_AXIS);
                  transform = transform.createConcatenation(rotate);
                  this.getTransforms().clear();
                  this.getTransforms().addAll(transform);
            }

            void rotateByY(int angle) {
                  rotate = new Rotate(angle, Rotate.Y_AXIS);
                  transform = transform.createConcatenation(rotate);
                  this.getTransforms().clear();
                  this.getTransforms().addAll(transform);
            }

      }

      public static void main(String[] args) {
            launch(args);
      }


}