/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ToDoListManager {
    String fileLocation;
    String fileName;
    File file = new File(fileLocation + "/" + fileName);
    ToDoList tdl = new ToDoList();

    public void writeToFile() {
        ToDoListManager manager = new ToDoListManager();
        //writes the manager created in the function above and loops through
        // its to do lists and each of the items and writes it down in each down on a separate line

        try {
            //create a buffered reader insider a try/catch block
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(manager.file))) {
                //for loop through the size of the todolist
                bw.write(manager.tdl.title);
                bw.write(manager.tdl.itemList.size());
                for(int i = 0;i < manager.tdl.itemList.size(); i++) {
                    bw.write(manager.tdl.itemList.get(i).name);
                    bw.write(manager.tdl.itemList.get(i).description);
                    bw.write(manager.tdl.itemList.get(i).dueDate);

                    if(manager.tdl.itemList.get(i).completion.equals("true")) {
                        bw.write("complete");
                    } else {
                        bw.write("incomplete");
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
                while (sc.hasNextLine()) {
                    loadedList.tdl.title = sc.nextLine();

                    String listSize = sc.nextLine();
                    for(int i = 0;i < Integer.parseInt(listSize); i++) {
                        Item item = new Item();
                        item.name = sc.nextLine();
                        item.description = sc.nextLine();
                        item.dueDate = sc.nextLine();

                        String completionStatus = sc.nextLine();

                        if(completionStatus.equals("complete")) {
                            item.completion = "true";
                        } else if(completionStatus.equals("incomplete")) {
                            item.completion = "false";
                        }

                        loadedList.tdl.itemList.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //returns newly made manager
        return loadedList;
    }

    public String getFileLocation() {
        //returns file location provided by user
        return null;
    }

    public String getFileLName() {
        //returns file name provided by user
        return null;
    }

    public void createList(String title) {
        tdl.title = title;
        System.out.println("Title: " + tdl.title);
        //gets the title
    }

    public void ediTitle(String newTitle) {
        tdl.title = newTitle;
        //changes the title of the list by prompting for a new name and reassigning title
    }
}
