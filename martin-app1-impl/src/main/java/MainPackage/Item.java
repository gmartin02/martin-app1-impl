/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;


public class Item {
    String completion;
    String name;
    String description;
    String dueDate;

    public Item () {
    }

    public Item(String name, String description, String dueDate, String completion) {
        this.completion = completion;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getName() {
        //gets item name from the user
        return name;
    }

    public String getDescription() {
        //gets item description from the user
        //validates that it is between 1 and 256 characters
        return description;
    }

    public String getDueDate() {
        //gets item due date from the user if they want to
        // ensure the date is on the Gregorian Calendar
        //validates the input to match 'YYYY-MM-DD'
        return dueDate;
    }

    public String getCompletion() {
        return completion;
    }

    public void changeCompletion() {
        if(completion.equals("no")) {
            completion = "yes";
        } else if(completion.equals("yes")) {
            completion = "no";
        }
        //when activated changes completion from false to true or vice versa
        //will be a checkbox in the GUI so a check = true, empty = false
    }
}
