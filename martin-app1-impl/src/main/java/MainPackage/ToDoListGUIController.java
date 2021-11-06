package MainPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ToDoListGUIController implements Initializable {
    ObservableList<Item> todoList = FXCollections.observableArrayList();

    ToDoListManager tdm = new ToDoListManager();
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
