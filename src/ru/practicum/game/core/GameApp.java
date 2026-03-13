package ru.practicum.game;

import java.util.ArrayList;
import java.util.List;

public class GameApp {
    private final List<Player> commandA;
    private final List<Player> commandB;
    private final List<Player> aliveCommandA;
    private final List<Player> aliveCommandB;

    public GameApp(List<Player> commandA, List<Player> commandB) {
        this.commandA = commandA;
        this.commandB = commandB;
        aliveCommandA = new ArrayList<>(commandA);
        aliveCommandB = new ArrayList<>(commandB);
    }

    public void start() {
        System.out.println("Start");
        while (!aliveCommandA.isEmpty() && !aliveCommandB.isEmpty()) {
            playCommand(aliveCommandA);
            removeDead(aliveCommandB);
            playCommand(aliveCommandB);
            removeDead(aliveCommandA);
        }
    }

    private void playCommand(List<Player> command) {
        for (Player player : command) {
            player.act();
        }
    }

    private void removeDead(List<Player> command) {
        command.removeIf(p -> !p.isAlive());
    }
}
