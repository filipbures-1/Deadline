package Main;
import Characters.Player;
import Commands.Commands;
import Commands.*;
import Items.Inventory;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameData world;
    private Player player;
    private HashMap<String, Commands> commands;

    /**
     * Initializes the game, loading game data and setting up commands.
     * Creates the player and connects rooms, NPCs, and items.
     */
    public void inicialization() {
        commands = new HashMap<>();
        world = GameData.loadGameDataFromResources("/gamedata.json");
        world.RoomConnection();
        world.NPCConnection();
        world.ItemConnection();
        Inventory inventory = new Inventory();
        player = new Player("Adam","Main.Main player", inventory, world.findLocation("loc_adamshouse"), null, world);
        commands.put("talk", new Dialog(player, world));
        commands.put("drop", new Drop(player));
        commands.put("exit", new Exit());
        commands.put("fight", new Fight(player));
        commands.put("give", new Give(player));
        commands.put("help", new Help());
        commands.put("hint", new Hint());
        commands.put("inventory", new InventoryCommand(player));
        commands.put("move", new Move(player));
        commands.put("pick", new PickUp(player, world));
        commands.put("steal", new Steal(player, world));
        commands.put("use", new Use(player));
        commands.put("map", new Map(player));
    }
    /**
     * Reads and returns the starting text from the resources file.
     * @return starting text.
     */
    public String StartingText(){
        String helpLine = "";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("startingtext");
        if (inputStream == null) {
            return "Unable to load starting text.";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                helpLine += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return helpLine;
    }
    /**
     * Starts the game loop, processing user commands until exit.
     * Displays starting text and initializes the game before entering the loop.
     * Displayed to the player.
     */
    public void start() {
        System.out.println(StartingText());
        inicialization();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(">> ");
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String commandName = parts[0].toLowerCase();
            Commands command = commands.get(commandName);
            if (command != null) {
                String result = command.execute(line);
                System.out.println(result);
                if (command.exit()==true) {
                    isRunning = false;
                }
            } else {
                System.out.println("Unknown command: " + commandName + " try 'help' to see the list of available commands.");
            }
        }
    }
}