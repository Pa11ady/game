package ru.practicum.game.core.action;

import ru.practicum.game.core.player.Player;

public class AttackAction extends AbstractAction {
    private final int damage;
    public AttackAction(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void execute(Player from, Player to) {
        System.out.println(from.getName() + " атакует " + to.getName());
        to.takeDamage(damage);
        System.out.println(to.getName() + " здоровье после атаки = " +to.getHealth());
        if (!to.isAlive()) {
            System.out.println(to.getName() + " убит");
        }
    }
}
