package ru.practicum.game.core.action;

import ru.practicum.game.core.io.Output;
import ru.practicum.game.core.player.Player;

public class SkipAction extends AbstractAction {
    public SkipAction(String name, Output output) {
        super(name, output);
    }

    @Override
    public void execute(Player from, Player to) {
        output.println(from.getName() + " Пропускает ход");
    }
}
