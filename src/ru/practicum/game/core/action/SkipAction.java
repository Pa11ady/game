package ru.practicum.game.core.action;

import ru.practicum.game.core.player.Player;

public class SkipAction extends AbstractAction {
    public SkipAction(String name) {
        super(name);
    }

    @Override
    public void execute(Player from, Player to) {
        System.out.println(from.getName() + " Пропускает ход");
    }
}
