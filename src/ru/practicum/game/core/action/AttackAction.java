package ru.practicum.game.core.action;

import ru.practicum.game.core.io.Output;
import ru.practicum.game.core.player.Player;

public class AttackAction extends AbstractAction {
    private final int damage;
    public AttackAction(String name, int damage, Output output) {
        super(name, output);
        this.damage = damage;
    }

    @Override
    public void execute(Player from, Player to) {
        output.println(from.getName() + " атакует " + to.getName());
        to.takeDamage(damage);
        output.println(to.getName() + " здоровье после атаки = " +to.getHealth());
        if (!to.isAlive()) {
            output.println(to.getName() + " убит");
        }
    }
}
