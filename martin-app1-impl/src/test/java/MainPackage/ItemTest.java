package MainPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void changeCompletion() {
        Item item = new Item();
        item.name = "homework";
        item.completion = "false";
        item.dueDate = "";
        item.description = "math";

        item.changeCompletion();

        assertEquals("true", item.completion);
    }
}