package ru.practicum.game.core.player;

import ru.practicum.game.core.action.GameAction;

import java.util.List;

abstract public class Player {
    private int health;
    private final int maxHealth;
    private final String name;

    protected final List<GameAction> actions;

    public Player(int health, int maxHealth, String name, List<GameAction> actions) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.name = name;
        this.actions = actions;
    }

    public void takeDamage(int damage) {
        if (health <= 0) {
            return;
        }
        if (damage < health) {
            health -= damage;
        } else {
            health = 0;
        }
    }

    abstract public GameAction chooseAction();

    public void heal(int heal) {
        if (health <= 0) {
            return;
        }
        health += heal;
        health = Math.min(maxHealth, health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
