module application.gymmanagementsystem {
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
      requires java.sql;
      requires mysql.connector.java;
      requires fontawesomefx;
      requires java.desktop;
      requires annotations;
      opens application.gymmanagementsystem to javafx.fxml;
    exports application.gymmanagementsystem;
}