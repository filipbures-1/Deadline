package Commands;

import Characters.Player;

public class Exit implements Commands{
    @Override
    public String execute(String commands) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
