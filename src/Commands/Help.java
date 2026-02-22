package Commands;
import java.io.*;

public class Help implements Commands{
    /**
     * Executes the help command, reading the help file.
     * @param commands command in the format "help".
     * @return help file.
     */
    @Override
    public String execute(String commands) {
        String helpLine = "";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("help");
        if (inputStream == null) {
            return "Unable to load help file.";
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
