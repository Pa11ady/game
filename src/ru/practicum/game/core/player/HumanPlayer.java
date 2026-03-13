package ru.practicum.game.core.player;

import ru.practicum.game.core.action.GameAction;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;
    public HumanPlayer(int health, int maxHealth, String name, List<GameAction> actions, Scanner scanner) {
        super(health, maxHealth, name, actions);
        this.scanner = scanner;
    }

    @Override
    public GameAction chooseAction() {
        int index;
        do {
            printMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите число.");
                scanner.next();
            }
            index = scanner.nextInt();
        } while (index < 0 || index >= actions.size());
        return actions.get(index);
    }

    private void printMenu() {
        System.out.println("Игрок, " + getName() + ", выберите действия" ) ;
        for (int i = 0; i < actions.size(); i++) {
            System.out.println("\t" + i + actions.get(i).name());
        }
    }
}
