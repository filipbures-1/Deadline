package Commands;

import Characters.Player;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Help implements Commands{
    @Override
    public String execute(String commands) {
        String test = "";
        try { BufferedReader helpreader = new BufferedReader(new FileReader("Resources/help"));
            String line;
            while ((line = helpreader.readLine()) != null) {
                test += line + "\n";
            }
        } catch (IIOException e){
            System.out.println("Unable to load map");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return test;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
