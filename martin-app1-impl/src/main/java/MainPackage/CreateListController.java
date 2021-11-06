package MainPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateListController implements Initializable {
    ToDoListManager tdm = new ToDoListManager();

    @FXML
    private TextField title;
    @FXML
    private Label label;

    @FXML
    public void getListTitle(MouseEvent event) throws IOException {
        if(!title.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDoListGUI.fxml"));
            Parent root = loader.load();
            ToDoListGUIController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            controller.tdm.tdl.title = tdm.createList(title.getText());
            controller.loadTable(controller.tdm);

            stage.show();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            label.setText("Please enter a valid title.");
        }
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
