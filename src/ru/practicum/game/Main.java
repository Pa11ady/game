package ru.practicum.game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> commandA = new ArrayList<>();
        List<Player> commandB = new ArrayList<>();
        GameApp app = new GameApp(commandA, commandB);
        app.start();
    }
}