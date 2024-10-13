module application.rpsdemo {
      requires javafx.controls;
      requires javafx.fxml;
      requires javafx.web;
      requires org.controlsfx.controls;
      requires com.dlsc.formsfx;
      requires net.synedra.validatorfx;
      requires org.kordamp.ikonli.javafx;
      requires org.kordamp.bootstrapfx.core;
      requires eu.hansolo.tilesfx;
      requires com.almasb.fxgl.all;

      opens application.rpsdemo to javafx.fxml;
      exports application.rpsdemo;
}
