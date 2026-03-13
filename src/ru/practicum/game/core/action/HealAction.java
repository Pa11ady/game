package ru.practicum.game.core.action;

import ru.practicum.game.core.player.Player;

public class HealAction extends AbstractAction {
    private final int heal;
    public HealAction(String name, int heal) {
        super(name);
        this.heal = heal;
    }

    @Override
    public void execute(Player from, Player to) {
        System.out.println(from.getName() + " лечит себя");
        from.heal(heal);
        System.out.println(from.getName() + " здоровье лечение = " +from.getHealth());
    }
}
