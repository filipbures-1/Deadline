package Commands;

import Characters.Player;

public class Exit implements Commands{
    @Override
    public String execute(String commands) {
        return "Exiting the game. Goodbye!";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
