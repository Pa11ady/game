package ru.practicum.game;

public class Player {
    private int health;
    private int maxHealth;
    private String name;

    public Player(int health, int maxHealth, String name) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.name = name;
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

    public void act() {

    }

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
