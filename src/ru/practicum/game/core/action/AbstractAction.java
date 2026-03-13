package ru.practicum.game.core.action;

import ru.practicum.game.core.player.Player;

public abstract class AbstractAction implements GameAction {
    private final String name;

    public AbstractAction(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
