package ru.practicum.game.core.action;

import ru.practicum.game.core.player.Player;

public interface GameAction {
    String name();

    void execute(Player from, Player to);
}
