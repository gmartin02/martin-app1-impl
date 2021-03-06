/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
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


public class AddItemController {
    ToDoListManager tdm = new ToDoListManager();
    Item newItem = new Item();

    @FXML
    private Label errorLabel;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescription;
    @FXML
    private DatePicker itemDueDate;

    @FXML
    //takes the info from the two text boxes and date picker and adds that to the current list and displays it to the table
    public void getItemInfo(MouseEvent event) throws IOException {
        //ensures the description is between 1 and 256 characters long (inclusive)
        if(!itemDescription.getText().equals("") && (itemDescription.getText().length() < 257)) {
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
            newItem.completion = "no";

            //adds the item to the GUI display and the programs todolist
            tdm.tdl.addItem(newItem);
            controller.todoList.add(newItem);
            controller.tdm = tdm;
            controller.loadTable(tdm);

            stage.show();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            //gives the user an error message if the description requirements are not met
            errorLabel.setText("Please enter a valid description");
        }
    }
}
