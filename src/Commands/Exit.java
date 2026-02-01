package Commands;

import Characters.Player;

public class Exit implements Commands{
    @Override
    public String execute(String commands) {
        System.out.println("Exiting the game. Goodbye!");
        System.exit(0);
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
