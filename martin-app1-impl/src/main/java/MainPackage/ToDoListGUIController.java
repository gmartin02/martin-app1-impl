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
    public void removeItemFromTable() {
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        todoList.remove(selectedItem);
        tdm.tdl.itemList = todoList;
        tableView.getItems().removeAll(selectedItem);
    }

    @FXML
    public void clearAllItemsFromTable() {
        tableView.getItems().removeAll(todoList);
        todoList.removeAll();
        tdm.tdl.itemList = tdm.tdl.clearList();
        loadTable(tdm);
    }
    @FXML
    public void saveListToTextFile() {
        tdm.writeToFile(fileLocationAndName.getText(), tdm);
        fileLocationAndName.clear();
        fileLocationAndName.setPromptText("Enter file location followed by file name      Ex. Documents/COP3330/myList.txt");
    }

    @FXML
    public void popupAddItemSceneOnButtonPress() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItem.fxml"));
        Parent addItemParent = loader.load();
        Scene addItemScene = new Scene(addItemParent);

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Add item");
        stage.setScene(addItemScene);
        stage.show();
    }

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


    @FXML
    public void changeToMakeNewFileSceneOnButtonPress() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateList.fxml"));
        Parent createFileParent = loader.load();
        Scene createFileScene = new Scene(createFileParent);

        Scene scene = tableView.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;

        stage.setTitle("Create File");
        stage.setScene(createFileScene);
        stage.show();
    }

    @FXML
    public void closeWindowOnExitButtonPress(MouseEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        completionColumn.setCellValueFactory(new PropertyValueFactory<>("completion"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        tableView.setItems(todoList);
    }

    @FXML
    public void loadTable(ToDoListManager tdm) {
        tableView.getItems().clear();
        todoList.addAll(tdm.tdl.itemList);
        tableView.setItems(todoList);
    }
}
