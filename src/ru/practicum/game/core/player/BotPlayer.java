package ru.practicum.game.core.player;

import ru.practicum.game.core.action.GameAction;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BotPlayer extends  Player {
    public BotPlayer(int health, int maxHealth, String name, List<GameAction> actions) {
        super(health, maxHealth, name, actions);
    }

    @Override
    public GameAction chooseAction() {
        int index = ThreadLocalRandom.current().nextInt(actions.size());
        return actions.get(index);
    }
}
