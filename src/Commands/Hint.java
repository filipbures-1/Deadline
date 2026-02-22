package Commands;
import javax.imageio.IIOException;
import java.io.*;

public class Hint implements Commands{
    /**
     * Executes the hint command, reading the hint file.
     * @param commands command in the format "hint".
     * @return hint file.
     */
    @Override
    public String execute(String commands) {
        String helpLine = "";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("hint");
        if (inputStream == null) {
            return "Unable to load hint file.";
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

    @Override
    public boolean exit() {
        return false;
    }
}
