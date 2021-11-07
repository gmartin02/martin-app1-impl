/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Gabriel Martin
 */
package MainPackage;


public class Item {
    String completion;
    String name;
    String description;
    String dueDate;

    public void changeCompletion() {
        if(completion.equals("false")) {
            completion = "true";
        } else if(completion.equals("true")) {
            completion = "false";
        }
        //when activated changes completion from false to true or vice versa
        //will be a checkbox in the GUI so a check = true, empty = false
    }
}
