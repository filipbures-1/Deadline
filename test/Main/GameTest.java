package Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void inicialization() {
        game.inicialization();
        assertNotNull(game);
    }

    @Test
    void startingText() {
        String text = game.StartingText();
        assertNotNull(text);
        assertFalse(text.isEmpty());
    }
}