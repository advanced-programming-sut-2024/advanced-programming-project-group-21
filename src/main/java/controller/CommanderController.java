package controller;

import enums.Card.CommandersEnum;

public class CommanderController {
    public CommandersEnum getCommander(String id) {
        for (CommandersEnum commander : CommandersEnum.values()) {
            if (commander.getName().equals(id)) {
                return commander;
            }
        }
        return null;
    }
}
