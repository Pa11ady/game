package ru.practicum.game;

import ru.practicum.game.core.GameApp;
import ru.practicum.game.core.action.AttackAction;
import ru.practicum.game.core.action.GameAction;
import ru.practicum.game.core.action.HealAction;
import ru.practicum.game.core.action.SkipAction;
import ru.practicum.game.core.io.ConsoleInput;
import ru.practicum.game.core.io.ConsoleOutput;
import ru.practicum.game.core.io.Input;
import ru.practicum.game.core.io.Output;
import ru.practicum.game.core.player.BotPlayer;
import ru.practicum.game.core.player.HumanPlayer;
import ru.practicum.game.core.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new ConsoleInput(scanner);
        Output output = new ConsoleOutput();
        getGameApp(input, output).start();
        scanner.close();
    }

    private static GameApp getGameApp(Input input, Output output) {
        AttackAction attackAction = new AttackAction("Атака", 40, output);
        HealAction healAction = new HealAction("Лечение", 25, output);
        SkipAction skipAction = new SkipAction("Пропуск хода", output);
        List<GameAction> actions = List.of(attackAction, healAction, skipAction);

        HumanPlayer humanPlayer1 = new HumanPlayer(100, 100, "Игрок1", actions, input);
        HumanPlayer humanPlayer2 = new HumanPlayer(100, 100, "Игрок2", actions, input);

        BotPlayer botPlayer1 = new BotPlayer(100, 100, "Бот1", actions);
        BotPlayer botPlayer2 = new BotPlayer(100, 100, "Бот2", actions);

        List<Player> commandA = new ArrayList<>();
        commandA.add(humanPlayer1);
        commandA.add(botPlayer1);
        List<Player> commandB = new ArrayList<>();
        commandB.add(humanPlayer2);
        commandB.add(botPlayer2);
        return new GameApp(commandA, commandB, output);
    }
}
