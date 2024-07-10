package controller;

import enums.Card.CommandersEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommanderControllerTest {

    private CommanderController commanderController;

    @BeforeEach
    public void setUp() {
        commanderController = new CommanderController();
    }

    @Test
    public void testGetCommander_ValidId() {
        for (CommandersEnum commander : CommandersEnum.values()) {
            CommandersEnum result = commanderController.getCommander(commander.getName());
            assertNotNull(result);
            assertEquals(commander, result);
        }
    }

    @Test
    public void testGetCommander_InvalidId() {
        String invalidId = "invalid_commander_id";
        CommandersEnum result = commanderController.getCommander(invalidId);
        assertNull(result);
    }

    @Test
    public void testGetCommander_EmptyId() {
        String emptyId = "";
        CommandersEnum result = commanderController.getCommander(emptyId);
        assertNull(result);
    }

    @Test
    public void testGetCommander_NullId() {
        CommandersEnum result = commanderController.getCommander(null);
        assertNull(result);
    }
}
