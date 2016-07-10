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
import javafx.scene.layout.Region;
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

    public void help(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Profile Information");
        String profile = comboProfile.getSelectionModel().getSelectedItem().toString();
        alert.setHeaderText(profile);
        int index = comboProfile.getSelectionModel().getSelectedIndex();
        String text = "";
        if (index == 0)
            text = "The specification includes the baseline types described under UNCLOS; normal, straight and archipelagic. These categories were chosen to support different legal regimes surrounding each baseline type. For instance, the legal status of the waters landward of an archipelagic baseline differs from those of a normal or straight baseline. \n" +
                    "\n" +
                    "Points, curve and surfaces can be used to describe baselines. Points are used for those States that proclaim maritime jurisdiction in legislation as a series of points or the origin of an arc. Straight baselines may be densified as geodesics or loxodromes depending on the State’s choice.\n";
        if (index == 1)
            text = "Points are included for those States that proclaim maritime jurisdiction by a series of connected points. \n" +
                    "\n" +
                    "Similarly to the baseline feature code; the categories of maritime limits or zones were chosen to reflect the change in legal regime the feature represents, rather than all possible limit forms.\n" +
                    "\n" +
                    "In deference to State prerogatives relating to maritime limits and zones, no reference to the breadth of the various zones is made in the specification.\n";
        if (index == 2)
            text = "Points are included for those States that proclaim maritime jurisdiction by a series of connected points. \n" +
                    "\n" +
                    "No special provision is made for the separate capture of bi or tri points for boundary treaty purposes, shared or joint zones or areas under dispute as this is not a requirement under UNCLOS.\n";

        alert.setContentText(text);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();

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
