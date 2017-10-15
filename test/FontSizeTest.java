import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import wordProcessor.FontSizeMenu;

import java.awt.*;
import java.util.Arrays;

public class FontSizeTest {
    private javax.swing.JCheckBoxMenuItem changeFontSize10 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize11 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize12 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize14 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize16 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize18 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize20 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize22 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize24 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize26 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize28 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize36 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize48 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize72 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize8 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JCheckBoxMenuItem changeFontSize9 = new javax.swing.JCheckBoxMenuItem();
    private javax.swing.JMenu changeFontSizeMenu = new javax.swing.JMenu();

    public FontSizeTest(){
        super();
    }

    @Test
    void fontMenuSetupTest(){
        FontSizeMenu fontMenu = new FontSizeMenu();
        Component[] menuItems = fontMenu.getMenu().getMenuComponents();
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize8));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize9));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize10));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize11));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize12));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize14));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize16));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize18));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize20));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize22));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize24));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize26));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize28));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize36));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize48));
        Assertions.assertTrue(Arrays.asList(menuItems).contains(changeFontSize72));
    }
}
