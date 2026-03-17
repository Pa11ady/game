package ru.practicum.game.core.action;

import ru.practicum.game.core.io.Output;
import ru.practicum.game.core.player.Player;

public class HealAction extends AbstractAction {
    private final int heal;
    public HealAction(String name, int heal, Output output) {
        super(name, output);
        this.heal = heal;
    }

    @Override
    public void execute(Player from, Player to) {
        output.println(from.getName() + " лечит себя");
        from.heal(heal);
        output.println(from.getName() + " здоровье лечение = " + from.getHealth());
    }
}
