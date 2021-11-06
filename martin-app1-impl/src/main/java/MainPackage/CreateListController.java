package MainPackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateListController implements Initializable {
    ToDoListGUIController controller = new ToDoListGUIController();

    @FXML
    private TextField title;
    @FXML
    private Label label;

    @FXML
    public String getListTitle(MouseEvent event) {
        if(!title.getText().equals("")) {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            label.setText("Please enter a valid title.");
        }

        controller.tdm.createList(title.getText());
        return title.getText();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
