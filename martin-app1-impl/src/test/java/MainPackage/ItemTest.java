/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void changeCompletionTest() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        item.changeCompletion();

        assertEquals("true", item.completion);
    }

    @Test
    void getNameTest() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        assertEquals("homework", item.getName());
    }

    @Test
    void getCompletionTest() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        assertEquals("false", item.getCompletion());
    }

    @Test
    void getDescriptionTest() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        assertEquals("math", item.getDescription());
    }

    @Test
    void getDueDateTest() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        assertEquals("", item.getDueDate());
    }
}