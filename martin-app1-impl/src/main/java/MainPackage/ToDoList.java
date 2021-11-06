/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    String title;
    List<Item> itemList = new ArrayList<>();
    boolean selected = false;

    public String getTitle() {
        //gets todolist title from the user
        //validates data to ensure it is at least 3 characters long
        return title;
    }

    public void clearList() {
        //replaces the current list with an empty one, similar to loading to do list but an empty one
    }
    public void removeItem(Item item) {
        //gets the item selected in the GUI and ensures that it exists in the list
        //using its index it is removed from the list
    }

    public String addItem(Item newItem) {
        //adds a new item to the list at the end
        return null;
    }

    public Item createItem() {
        //sets the name, description, and due date for a new item
        //completion is set to false by default

        return null;
    }

    public void displayWholeList() {
        //loops through the itemList to show all the items
    }

    public void displayCompletedItems() {
        //loops through the itemList to show only completed items
    }

    public void displayIncompleteItems() {
        //loops through the itemList to show only incomplete items
    }

}
