package MainPackage;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoadFileController {
    ToDoListManager tdm = new ToDoListManager();
    @FXML
    private Button confirmButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField filePath;
    @FXML
    private Label label;

    @FXML
    public String getFilePath(MouseEvent event) {
        if(!filePath.getText().equals("")) {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            label.setText("Please enter a valid file path");
        }
        tdm.loadToDoList(filePath.getText());
        return filePath.getText();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
