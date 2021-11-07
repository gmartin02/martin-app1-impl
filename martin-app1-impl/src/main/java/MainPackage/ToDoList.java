/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    String title;
    List<Item> itemList = new ArrayList<>();

    public List<Item> clearList() {
        //replaces the current list with an empty one, similar to loading to do list but an empty one
        return new ArrayList<>();
    }

    public void addItem(Item newItem) {
        //adds a new item to the list at the end
        itemList.add(newItem);
    }

    public void displayCompletedItems(List<Item> displayList) {
        for (Item item : itemList) {
            if (item.completion.equals("true")) {
                displayList.add(item);
            }
        }
        //loops through the itemList to show only completed items
    }

    public void displayIncompleteItems(List<Item> displayList) {
        for (Item item : itemList) {
            if (item.completion.equals("false")) {
                displayList.add(item);
            }
        }
        //loops through the itemList to show only incomplete items
    }

}
