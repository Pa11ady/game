package ru.practicum.game.core.player;

import ru.practicum.game.core.action.GameAction;
import ru.practicum.game.core.io.Input;

import java.util.List;

public class HumanPlayer extends Player {
    private final Input input;

    public HumanPlayer(int health, int maxHealth, String name, List<GameAction> actions, Input input) {
        super(health, maxHealth, name, actions);
        this.input = input;
    }

    @Override
    public GameAction chooseAction() {
        int index = input.askInt(buildMenuMessage(), 0, actions.size() - 1);
        return actions.get(index);
    }

    private String buildMenuMessage() {
        StringBuilder message = new StringBuilder();
        message.append(getName()).append(", выберите действия\n");
        for (int i = 0; i < actions.size(); i++) {
            message.append("\t")
                    .append(i)
                    .append(" ")
                    .append(actions.get(i).name())
                    .append("\n");
        }
        return message.toString();
    }
}
