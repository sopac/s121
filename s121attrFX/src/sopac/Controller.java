package sopac;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.annotation.Resources;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ComboBox comboProfile;

    @FXML
    TextField textPath;

    //custom
    public void close(ActionEvent ae) {
        System.exit(0);
    }

    public void browse(ActionEvent ae) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Open Shapefile Folder");
        File f = dc.showDialog(null);
        if (f != null) {
            textPath.setText(f.getPath());
        }

    }


    public void process(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Processing Error");
        alert.setContentText("Zero or Malformed Shapefiles Found in Folder!");
        alert.showAndWait();
    }

    public void initialize(URL location, ResourceBundle rb) {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Baseline",
                        "Maritime Limits",
                        "Maritime Boundaries"
                );
        comboProfile.setItems(options);
        comboProfile.getSelectionModel().clearAndSelect(0);
    }
}
