/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ToDoListManager {
    ToDoList tdl = new ToDoList();
    String fileLocation;
    File file = new File(getFileLocation()+ "/" + getFileName());

    public void writeToFile(String file, ToDoListManager manager) {
        //writes the manager created in the function above and loops through
        // its to do lists and each of the items and writes it down in each down on a separate line
        try {
            //create a buffered reader insider a try/catch block
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                //for loop through the size of the todolist
                bw.write(manager.tdl.title + "\n");
                bw.write(manager.tdl.itemList.size() + "\n");
                for(int i = 0;i < manager.tdl.itemList.size(); i++) {
                    bw.write(manager.tdl.itemList.get(i).name + "\n");
                    bw.write(manager.tdl.itemList.get(i).description + "\n");
                    bw.write(manager.tdl.itemList.get(i).dueDate + "\n");

                    if(manager.tdl.itemList.get(i).completion.equals("yes")) {
                        bw.write("complete" + "\n");
                    } else {
                        bw.write("incomplete" + "\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //for example:
        //groceries
        //get apple
        //granny smith
        //2021-10-31
        //incomplete
        //get chicken
        //tender
        //2021-10-31
        //complete
        //the integer after the list name represents the number of items in the list
    }

    public ToDoListManager loadToDoList(String location) {
        ToDoListManager loadedList = new ToDoListManager();
        //loads the file that contains a ToDoListManager
        file = new File(location);
        //reads the txt file in the same way described above to populate a new ToDoListManager
        try {
            //create a buffered reader insider a try/catch block
            try (Scanner sc = new Scanner(file)) {
                //while the next line is not null

                    loadedList.tdl.title = sc.nextLine();

                    String listSize = sc.nextLine();
                    for(int i = 0;i < Integer.parseInt(listSize); i++) {
                        Item item = new Item();
                        item.name = sc.nextLine();
                        item.description = sc.nextLine();
                        item.dueDate = sc.nextLine();

                        String completionStatus = sc.nextLine();

                        if(completionStatus.equals("complete")) {
                            item.completion = "yes";
                        } else if(completionStatus.equals("incomplete")) {
                            item.completion = "no";
                        }

                        loadedList.tdl.itemList.add(item);
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //returns newly made manager
        return loadedList;
    }

    public String getFileLocation() {
        //returns file location provided by user
        return fileLocation;
    }

    public String getFileName() {
        //returns file name provided by user
        return tdl.title;
    }
}
