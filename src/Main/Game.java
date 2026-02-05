package Main;

import Characters.Player;
import Commands.Commands;
import Commands.*;
import Items.Inventory;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
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
    public void StartingText(){
        try { BufferedReader startingtextreader = new BufferedReader(new FileReader("Resources/startingtext"));
            String line;
            while ((line = startingtextreader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IIOException e){
            System.out.println("Unable to load the starting text.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void start() {
        StartingText();
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
                System.out.println("Unknown command: " + commandName + " try 'help' to see the list of available commands.");
            }
        }
    }
}