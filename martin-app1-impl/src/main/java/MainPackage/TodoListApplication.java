/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class TodoListApplication extends javafx.application.Application {
    @Override

    public void start(Stage stage) throws Exception {

        Parent root =
                FXMLLoader.load((Objects.requireNonNull(getClass().getResource("ToDoListGUI.fxml"))));
        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("OhWhatToDo!"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

