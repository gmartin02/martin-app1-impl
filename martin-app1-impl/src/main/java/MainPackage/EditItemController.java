package MainPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class EditItemController {
    Item newItem = new Item();
    ToDoListManager tdm = new ToDoListManager();

    @FXML
    private Label errorLabel;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescription;
    @FXML
    private DatePicker itemDueDate;

    //takes the info from the two text boxes and date picker and changes the current item
    @FXML
    public void editItemInfo(MouseEvent event) throws IOException {
        //ensures the description is between 1 and 256 characters long (inclusive)
        if(!itemDescription.getText().equals("")) {
            //opens the main controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDoListGUI.fxml"));
            Parent root = loader.load();
            ToDoListGUIController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //gets the correct information from the GUI elements and assigns it to an empty Item
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
        } else {
            errorLabel.setText("Please enter a description");
        }
    }

    //shows the selectedItem's info when this scene is loaded in
    @FXML
    public void showItemInfo(Item selectedItem) {
        itemName.setText(selectedItem.name);
        itemDescription.setText(selectedItem.description);
    }
}
