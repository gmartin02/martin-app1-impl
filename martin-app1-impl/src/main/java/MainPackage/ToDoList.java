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

    public List<Item> clearList() {
        //replaces the current list with an empty one, similar to loading to do list but an empty one
        return new ArrayList<>();
    }
    public void removeItem(Item item) {
        //gets the item selected in the GUI and ensures that it exists in the list
        //using its index it is removed from the list
        itemList.remove(item);
    }

    public void addItem(Item newItem) {
        //adds a new item to the list at the end
        itemList.add(newItem);
    }

    public Item createItem() {
        //sets the name, description, and due date for a new item
        //completion is set to false by default

        return null;
    }

    public void displayWholeList() {
        //loops through the itemList to show all the items
    }

    public void displayCompletedItems(List<Item> displayList) {
        for(int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).completion.equals("true")) {
                displayList.add(itemList.get(i));
            }
        }
        //loops through the itemList to show only completed items
    }

    public void displayIncompleteItems(List<Item> displayList) {
        for(int i = 0; i < itemList.size(); i++) {
            if(itemList.get(i).completion.equals("false")) {
                displayList.add(itemList.get(i));
            }
        }
        //loops through the itemList to show only incomplete items
    }

}
