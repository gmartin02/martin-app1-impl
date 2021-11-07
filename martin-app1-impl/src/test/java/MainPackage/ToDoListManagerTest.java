/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListManagerTest {

    @Test
    void writeToFile() {
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

        ToDoListManager test = new ToDoListManager();
        test.tdl.itemList.add(itemOne);
        test.tdl.itemList.add(itemTwo);

        test.writeToFile("input/testWriteToFile.txt", test);

        assertEquals(2, test.tdl.itemList.size());
    }

    @Test
    void loadToDoListTest() {
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

        ToDoListManager expected = new ToDoListManager();
        expected.tdl.itemList.add(itemOne);
        expected.tdl.itemList.add(itemTwo);

        ToDoListManager test = new ToDoListManager();
        test = test.loadToDoList("input/loadToDoListTest.txt");



        assertEquals(expected.tdl.itemList.get(0).name, test.tdl.itemList.get(0).name);
        assertEquals(expected.tdl.itemList.get(1).description, test.tdl.itemList.get(1).description);
    }

    @Test
    void getFileLocation() {
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

        ToDoListManager test = new ToDoListManager();
        test.tdl.itemList.add(itemOne);
        test.tdl.itemList.add(itemTwo);
        test.fileLocation = "input";

        assertEquals("input", test.getFileLocation());
    }

    @Test
    void getFileName() {
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

        ToDoListManager test = new ToDoListManager();
        test.tdl.itemList.add(itemOne);
        test.tdl.itemList.add(itemTwo);
        test.tdl.title = "itemListOne";

        assertEquals("itemListOne", test.getFileName());
    }

    @Test
    void createList() {
        ToDoListManager test = new ToDoListManager();
        test.createList("itemListOne");

        assertEquals("itemListOne", test.getFileName());
    }
}