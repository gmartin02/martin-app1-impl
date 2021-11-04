/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ToDoListManager {
    List<ToDoList> manager = new ArrayList<>();
    String fileLocation;
    String fileName;
    File file = new File(fileLocation + "/" + fileName);

    public String getFileLocation() {
        //returns file location provided by user
        return null;
    }

    public String getFileLName() {
        //returns file name provided by user
        return null;
    }

    public void deleteList(ToDoList tdl) {
        //gets the list selected in the GUI and ensures that it exists in the manager
        //using its index it is removed from the list
    }

    public ToDoList createList() {
        ToDoList tdl = new ToDoList();
        //gets the title, description, and dueDate from the GUI
        return tdl;
    }

    public void ediTitle(ToDoList tdl) {
        //changes the title of the list by prompting for a new name and reassigning title
    }




}
