/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void clearList() {
        Item itemOne = new Item();
        itemOne.name = "homework";
        itemOne.completion = "false";
        itemOne.dueDate = "";
        itemOne.description = "math";

        Item itemTwo = new Item();
        itemTwo.name = "homework";
        itemTwo.completion = "false";
        itemTwo.dueDate = "";
        itemTwo.description = "math";

        ToDoList test = new ToDoList();
        test.itemList.add(itemOne);
        test.itemList.add(itemTwo);

        ToDoList empty = new ToDoList();

        test.itemList = test.clearList();

        assertEquals(empty.itemList.size(), test.itemList.size());

    }

    @Test
    void addItem() {
        Item itemOne = new Item();
        itemOne.name = "homework";
        itemOne.completion = "false";
        itemOne.dueDate = "";
        itemOne.description = "math";

        ToDoList test = new ToDoList();
        test.addItem(itemOne);

        ToDoList expected = new ToDoList();
        expected.itemList.add(itemOne);

        assertEquals(expected.itemList.get(0), test.itemList.get(0));
    }

    @Test
    void displayCompletedItems() {
        ToDoList empty = new ToDoList();

        Item itemOne = new Item();
        itemOne.name = "homework";
        itemOne.completion = "false";
        itemOne.dueDate = "";
        itemOne.description = "math";

        Item itemTwo = new Item();
        itemTwo.name = "test";
        itemTwo.completion = "true";
        itemTwo.dueDate = "2021-12-02";
        itemTwo.description = "math";

        ToDoList test = new ToDoList();
        test.itemList.add(itemOne);
        test.itemList.add(itemTwo);

        ToDoList expected = new ToDoList();
        expected.itemList.add(itemTwo);

        test.displayCompletedItems(empty.itemList);

        assertEquals(expected.itemList, empty.itemList);
    }

    @Test
    void displayIncompleteItems() {
        ToDoList empty = new ToDoList();

        Item itemOne = new Item();
        itemOne.name = "homework";
        itemOne.completion = "false";
        itemOne.dueDate = "";
        itemOne.description = "math";

        Item itemTwo = new Item();
        itemTwo.name = "test";
        itemTwo.completion = "true";
        itemTwo.dueDate = "2021-12-02";
        itemTwo.description = "math";

        ToDoList test = new ToDoList();
        test.itemList.add(itemOne);
        test.itemList.add(itemTwo);

        ToDoList expected = new ToDoList();
        expected.itemList.add(itemOne);

        test.displayIncompleteItems(empty.itemList);

        assertEquals(expected.itemList, empty.itemList);
    }
}