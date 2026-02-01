package Commands;

import Characters.Player;

public class Help implements Commands{
    @Override
    public String execute(String commands) {
        return "Available commands: " +
                "\nhelp - Show this help message" +
                "\nmove <Room> - Move to a specified room" +
                "\npick <Item> - Pick up an item" +
                "\ndrop <Item> - Drop an item from your inventory" +
                "\ninventory - Show your current inventory" +
                "\ntalk <Character> - Talk to a character" +
                "\ngive <Item> to <Character> - Give an item to a character" +
                "\nsteal <Item> from <Character> - Steal an item from a character" +
                "\nfight - Fight to start doing your homework" +
                "\nuse <Item> - Use an item from your inventory" +
                "\nhint - Get a hint for your current situation" +
                "\nexit - Exit the game";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
