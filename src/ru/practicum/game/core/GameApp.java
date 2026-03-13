package ru.practicum.game.core;

import ru.practicum.game.core.action.GameAction;
import ru.practicum.game.core.player.Player;

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
        System.out.println("Запуск");
        while (!aliveCommandA.isEmpty() && !aliveCommandB.isEmpty()) {
            playCommand(aliveCommandA, commandB);
            removeDead(aliveCommandB);
            System.out.println("\n=====");
            playCommand(aliveCommandB, commandA);
            removeDead(aliveCommandA);
        }
        System.out.println("\nКонец игры");
        System.out.println("*************************");
        System.out.println("Победил(и)");
        System.out.println("Игрок\tЗдоровье");
        print(aliveCommandA);
        print(aliveCommandB);

    }

    void playCommand(List<Player> command, List<Player> enemies) {
        for (Player player : command) {
            GameAction action = player.chooseAction();
            Player enemy = getEnemy(enemies);
            if (enemy == null) {
                return;
            }
            action.execute(player,enemy);
        }
    }

    private void removeDead(List<Player> command) {
        command.removeIf(p -> !p.isAlive());
    }
    private Player getEnemy(List<Player> command) {
        for (Player player : command) {
            if (player.isAlive()) {
                return player;
            }
        }
        return null;
    }

    private void print(List<Player> command) {
        for (Player p : command) {
            System.out.println(p.getName() + "\t" +p.getHealth());
        }
    }
}
