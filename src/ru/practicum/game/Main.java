package ru.practicum.game;

import ru.practicum.game.core.GameApp;
import ru.practicum.game.core.action.AttackAction;
import ru.practicum.game.core.action.GameAction;
import ru.practicum.game.core.action.HealAction;
import ru.practicum.game.core.action.SkipAction;
import ru.practicum.game.core.player.BotPlayer;
import ru.practicum.game.core.player.HumanPlayer;
import ru.practicum.game.core.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttackAction attackAction = new AttackAction("Атака", 40);
        HealAction healAction = new HealAction("Лечение", 25);
        SkipAction skipAction = new SkipAction("Пропуск хода");
        List<GameAction> actions = List.of(attackAction, healAction, skipAction);

        Scanner scanner = new Scanner(System.in);
        HumanPlayer humanPlayer1 = new HumanPlayer(100, 100, "Игрок1", actions, scanner);
        HumanPlayer humanPlayer2 = new HumanPlayer(100, 100, "Игрок2", actions, scanner);

        BotPlayer botPlayer1 = new BotPlayer(100, 100, "Бот1", actions);
        BotPlayer botPlayer2 = new BotPlayer(100, 100, "Бот2", actions);

        List<Player> commandA = new ArrayList<>();
        commandA.add(humanPlayer1);
        commandA.add(botPlayer1);
        List<Player> commandB = new ArrayList<>();
        commandB.add(humanPlayer2);
        commandB.add(botPlayer2);
        GameApp app = new GameApp(commandA, commandB);
        app.start();
        scanner.close();
    }
}
