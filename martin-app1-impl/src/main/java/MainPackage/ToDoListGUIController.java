package MainPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ToDoListGUIController implements Initializable {
    ObservableList<Item> todoList = FXCollections.observableArrayList();

    ToDoListManager tdm = new ToDoListManager();

    @FXML
    private TextField fileLocationAndName;
    @FXML
    public TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> completionColumn;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, String> dueDateColumn;
    @FXML
    private RadioButton showAllItems;
    @FXML
    private RadioButton showIncompletedItems;
    @FXML
    private RadioButton showCompletedItems;

    //changes to various views in the table view
    @FXML
    public void changeItemViewOnRadioToggle() {
        ToDoListManager currentDisplay = new ToDoListManager();
        if(showAllItems.isSelected()) {
            showCompletedItems.selectedProperty().set(false);
            showIncompletedItems.selectedProperty().set(false);
            loadTable(tdm);
        }
        if(showCompletedItems.isSelected()) {
            showAllItems.selectedProperty().set(false);
            showIncompletedItems.selectedProperty().set(false);
            tdm.tdl.displayCompletedItems(currentDisplay.tdl.itemList);
            loadTable(currentDisplay);
        }
        if(showIncompletedItems.isSelected()) {
            showCompletedItems.selectedProperty().set(false);
            showAllItems.selectedProperty().set(false);
            tdm.tdl.displayIncompleteItems(currentDisplay.tdl.itemList);
            loadTable(currentDisplay);
        }
    }

    //toggles the item selected's completion value in table view ONLY IF RADIO BUTTON IS SELECTED
    @FXML
    public void toggleCompletionOnButtonPress() {
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(tdm.tdl.itemList.contains(selectedItem)) {
            int indexOfItem = tdm.tdl.itemList.indexOf(selectedItem);
            tdm.tdl.itemList.get(indexOfItem).changeCompletion();
            loadTable(tdm);
        }
    }

    //removes the item selected in table view ONLY IF RADIO BUTTON IS SELECTED
    @FXML
    public void removeItemFromTable() {
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(tdm.tdl.itemList.contains(selectedItem)) {
            todoList.remove(selectedItem);
            tdm.tdl.itemList.remove(selectedItem);
            loadTable(tdm);
            System.out.println(tdm.tdl.itemList.get(0).name);
        }
    }

    //clears everything from the table view and within the program
    @FXML
    public void clearAllItemsFromTable() {
        tableView.getItems().removeAll(todoList);
        todoList.removeAll();
        tdm.tdl.itemList = tdm.tdl.clearList();
        loadTable(tdm);
    }

    //button to save the file as a txt file
    @FXML
    public void saveListToTextFile() {
        tdm.writeToFile("output/" + fileLocationAndName.getText() + ".txt", tdm);
        fileLocationAndName.clear();
        fileLocationAndName.setPromptText("Enter file location followed by file name      Ex. Documents/COP3330/myList.txt");
    }

    //creates popup to add item into the list
    @FXML
    public void popupAddItemSceneOnButtonPress() throws IOException{
        List<Item> currentItems = tableView.getItems();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItem.fxml"));
        Parent addItemParent = loader.load();
        Scene addItemScene = new Scene(addItemParent);
        AddItemController adder = loader.getController();

        adder.tdm.tdl.itemList = currentItems;
        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Add item");
        stage.setScene(addItemScene);
        stage.show();
    }

    //creates popup to edit item in the list
    @FXML
    public void popupEditItemSceneOnButtonPress() throws IOException {
        List<Item> currentItems = tableView.getItems();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        Parent editItemParent = loader.load();
        Scene editItemScene = new Scene(editItemParent);
        EditItemController editItemController = loader.getController();

        Item selectedItem = tableView.getSelectionModel().getSelectedItem();

        editItemController.showItemInfo(selectedItem);
        currentItems.remove(selectedItem);
        editItemController.tdm.tdl.itemList = currentItems;

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Edit item");
        stage.setScene(editItemScene);
        stage.show();
    }

    //opens up a load scene window where you type in the location of your file to have it displayed
    @FXML
    public void changeToLoadFileSceneOnButtonPress() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoadFile.fxml"));
        Parent loadFileParent = loader.load();
        Scene loadFileScene = new Scene(loadFileParent);

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Load File");
        stage.setScene(loadFileScene);
        stage.show();
    }

    //exits the program when exit is pressed
    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    //loads the table when the scene starts
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        completionColumn.setCellValueFactory(new PropertyValueFactory<>("completion"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        tableView.setItems(todoList);
    }

    //loads the table with new todolist manager when called
    @FXML
    public void loadTable(ToDoListManager tdm) {
        tableView.getItems().clear();
        todoList.addAll(tdm.tdl.itemList);
        tableView.setItems(todoList);
    }
}
