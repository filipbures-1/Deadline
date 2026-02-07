package Commands;
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Hint implements Commands{
    @Override
    public String execute(String commands) {
        String text = "";
        try { BufferedReader hintreader = new BufferedReader(new FileReader("Resources/hint"));
            String line;
            while ((line = hintreader.readLine()) != null) {
                text += line + "\n";
            }
        } catch (IIOException e){
            System.out.println("Unable to load map");
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
