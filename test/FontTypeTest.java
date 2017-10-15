import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordProcessor.FontTypeMenu;

import java.util.Arrays;

public class FontTypeTest {
    @Test
    void fontTypeTest(){
        FontTypeMenu menu = new FontTypeMenu();
        Assertions.assertTrue(Arrays.asList(menu.getMenu().getMenuComponents()).size() > 8);
    }
}
