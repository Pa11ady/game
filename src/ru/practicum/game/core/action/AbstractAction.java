package ru.practicum.game.core.action;

import ru.practicum.game.core.io.Output;

public abstract class AbstractAction implements GameAction {
    private final String name;
    protected final Output output;

    public AbstractAction(String name, Output output) {
        this.name = name;
        this.output = output;
    }

    @Override
    public String name() {
        return name;
    }
}
