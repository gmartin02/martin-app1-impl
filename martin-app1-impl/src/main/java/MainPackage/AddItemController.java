package MainPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class AddItemController {
    ToDoListManager tdm = new ToDoListManager();
    Item newItem = new Item();
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescription;
    @FXML
    private DatePicker itemDueDate;

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    public void getItemInfo(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDoListGUI.fxml"));
        Parent root = loader.load();
        ToDoListGUIController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        newItem.name = itemName.getText();
        newItem.description = itemDescription.getText();
        if(itemDueDate.getValue() == null) {
            newItem.dueDate = "";
        } else {
            newItem.dueDate = itemDueDate.getValue().toString();
        }
        newItem.completion = "false";

        tdm.tdl.addItem(newItem);
        controller.todoList.add(newItem);
        controller.tdm = tdm;
        controller.loadTable(tdm);

        stage.show();

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
