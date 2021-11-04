/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;

public class Item {
    String name;
    String description;
    String dueDate;
    boolean completion = false;

    public String getName() {
        //gets item name from the user
        return null;
    }

    public String getDescription() {
        //gets item description from the user
        //validates that it is between 1 and 256 characters
        return null;
    }

    public String getDueDate() {
        //gets item due date from the user if they want to
        // ensure the date is on the Gregorian Calendar
        //validates the input to match 'YYYY-MM-DD'
        return null;
    }

    public void editDescription() {
        //takes in a new description from the GUI and replaces the old one
    }

    public void editDueDate() {
        //takes in a new due date from the GUI and replaces the old one
    }

    public void changeCompletion() {
        //when activated changes completion from false to true or vice versa
        //will be a checkbox in the GUI so a check = true, empty = false
    }
}
