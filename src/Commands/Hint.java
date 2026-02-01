package Commands;

import Characters.Player;

public class Hint implements Commands{
    @Override
    public String execute(String commands) {
        return "Go around and the school and try to interact with different characters, they will help you find the items you need to finish your homework.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
