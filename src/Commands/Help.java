package Commands;
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Help implements Commands{
    /**
     * Executes the help command, reading the help file.
     * @param commands command in the format "help".
     * @return help file.
     */
    @Override
    public String execute(String commands) {
        String text = "";
        try { BufferedReader helpreader = new BufferedReader(new FileReader("Resources/help"));
            String line;
            while ((line = helpreader.readLine()) != null) {
                text += line + "\n";
            }
        } catch (IIOException e){
            System.out.println("Unable to help tab.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
