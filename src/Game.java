import Characters.Player;
import Commands.Commands;
import Commands.Move;
import Items.Inventory;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameData world;
    private Player player;
    private HashMap<String, Commands> commands;

    public void inicialization() {
        commands = new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        world.RoomConnection();
        System.out.println(world.characters);
        System.out.println(world.items);
        System.out.println(world.rooms);
        //TODO pridat commands
        Inventory inventory = new Inventory();
        player = new Player("Adam","Main player", inventory, world.findLocation("loc_adamshouse"), null);
        commands.put("move", new Move(player));
        }

    public void start() {
        inicialization();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning == true) {
            System.out.println(">> ");
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String commandName = parts[0].toLowerCase();
            Commands command = commands.get(commandName);
            if (command != null) {
                String result = command.execute(line);
                System.out.println(result);
            } else {
                System.out.println("Unknown command: " + commandName);
            }

        }
    }
}