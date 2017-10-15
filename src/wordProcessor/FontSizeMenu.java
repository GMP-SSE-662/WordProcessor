package wordProcessor;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class FontSizeMenu {
    int[] sizes = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
    ArrayList<JCheckBoxMenuItem> menuItemArrayList = new ArrayList<>();
    private javax.swing.JMenu changeFontSizeMenu = new javax.swing.JMenu();

    public javax.swing.JMenu getMenu(){
        changeFontSizeMenu.setText("Change Font Size");
        for (int i = 0; i < sizes.length; i++){
            menuItemArrayList.add(new javax.swing.JCheckBoxMenuItem());
            addFontSizeToMenu(menuItemArrayList.get(i), Integer.toString(sizes[i]), changeFontSizeMenu);
            createFontSizeHandler(menuItemArrayList.get(i), sizes[i]);
        }

        return changeFontSizeMenu;
    }

    private void addFontSizeToMenu(javax.swing.JMenuItem menuItem, String ItemText, javax.swing.JMenu menu) {
        menuItem.setText(ItemText);
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (menuItem instanceof javax.swing.JCheckBoxMenuItem) uncheckAll();
                if (menuItem instanceof javax.swing.JCheckBoxMenuItem) menuItem.setSelected(true);
            }
        });
        menu.add(menuItem);
    }

    private void createFontSizeHandler(javax.swing.JMenuItem menuItem, int size){
        Action sizeAction = new StyledEditorKit.FontSizeAction("", size);
        sizeAction.putValue(Action.NAME, Integer.toString(size));
        menuItem.setAction(sizeAction); //setting font size change to 11 action to corresponding menu item
    }

    void uncheckAll() { //function unchecking all the font size check box
        for(int i = 0; i < menuItemArrayList.size(); i++){
            menuItemArrayList.get(i).setSelected(false);
        }
    }
}
