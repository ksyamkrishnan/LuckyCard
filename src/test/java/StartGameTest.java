import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartGameTest {


    @Test
    public void printWelcomeMessage() {
        StartGame.printWelcomeMessage();
        Assert.assertTrue(true);
    }
}