package ru.practicum.game.core;

import ru.practicum.game.core.action.GameAction;
import ru.practicum.game.core.io.Output;
import ru.practicum.game.core.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameApp {
    private final List<Player> aliveCommandA;
    private final List<Player> aliveCommandB;
    private final Output output;

    public GameApp(List<Player> commandA, List<Player> commandB, Output output) {
        aliveCommandA = new ArrayList<>(commandA);
        aliveCommandB = new ArrayList<>(commandB);
        this.output = output;
    }

    public void start() {
        output.println("Запуск");
        while (!aliveCommandA.isEmpty() && !aliveCommandB.isEmpty()) {
            playCommand(aliveCommandA, aliveCommandB);
            output.println("\n=====");
            playCommand(aliveCommandB, aliveCommandA);
        }
        gameOver();
    }

    private void gameOver() {
        output.println("\nКонец игры");
        output.println("*************************");
        output.println("Победил(и)");
        output.println("Игрок\tЗдоровье");
        print(aliveCommandA);
        print(aliveCommandB);
    }

    void playCommand(List<Player> command, List<Player> enemies) {
        for (Player player : command) {
            GameAction action = player.chooseAction();
            Player enemy = getEnemy(enemies);
            if (enemy == null) {
                break;
            }
            action.execute(player, enemy);
        }
        enemies.removeIf(p -> !p.isAlive());
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
            output.println(p.getName() + "\t" + p.getHealth());
        }
    }
}
