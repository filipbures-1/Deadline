package Commands;

import Characters.Player;

public class Fight implements Commands{
    @Override
    public String execute(String commands) {
        return "I have no idea how to do this right now. i might need help.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
