package MainPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ToDoListGUIController {
    @FXML
    public void changeToLoadFileSceneOnButtonPress() throws IOException {
        Parent loadFileParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadFile.fxml")));
        Scene loadFileScene = new Scene(loadFileParent);

        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.setTitle("Load File");
        window.setScene(loadFileScene);
        window.show();
    }

    @FXML
    public void changeToMakeNewFileSceneOnButtonPress() throws IOException {
        Parent loadFileParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateList.fxml")));
        Scene loadFileScene = new Scene(loadFileParent);

        Stage window = new Stage();
        window.setAlwaysOnTop(true);
        window.setTitle("Create New List");
        window.setScene(loadFileScene);
        window.show();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

}
