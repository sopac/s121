package sopac;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tool.fxml"));
        primaryStage.setTitle("S121 Attribution Tool - Geoscience Division, SPC");
        primaryStage.setScene(new Scene(root, 800, 345));
        primaryStage.setResizable(false);
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
