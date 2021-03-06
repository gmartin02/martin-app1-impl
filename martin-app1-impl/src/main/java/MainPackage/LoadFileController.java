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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadFileController {
    ToDoListManager tdm = new ToDoListManager();

    @FXML
    private TextField filePath;
    @FXML
    private Label label;

    //when confirm is clicked the window closes and the file path given will load a todolist in the main window
    //also doesn't allow an empty text field to be returned
    @FXML
    public void getFilePath(MouseEvent event) throws IOException {
        if(!filePath.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDoListGUI.fxml"));
            Parent root = loader.load();
            ToDoListGUIController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            controller.tdm = tdm.loadToDoList(filePath.getText());
            controller.loadTable(tdm.loadToDoList(filePath.getText()));


            stage.show();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            label.setText("Please enter a valid file path");
        }
    }
}
