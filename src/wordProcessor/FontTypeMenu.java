package wordProcessor;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class FontTypeMenu {
    String[] styles = {"Arial", "Bradley Hand ITC", "Calibri", "Chiller", "Comic Sans MS", "Courier New",
    "Old English Text MT", "Palace Script MT", "Ravie", "Times New Roman", "Verdana"};
    ArrayList<JMenuItem> stylesArrayList = new ArrayList<>();
    private javax.swing.JMenu changeFontTypeMenu = new javax.swing.JMenu();

    public javax.swing.JMenu getMenu(){
        changeFontTypeMenu.setText("Change Font Type");
        for (int i = 0; i < styles.length; i++){
            stylesArrayList.add(new javax.swing.JMenuItem());
            addFontTypeToMenu(stylesArrayList.get(i), styles[i], changeFontTypeMenu);
            createFontTypeHandler(stylesArrayList.get(i));
        }

        return changeFontTypeMenu;
    }

    private void addFontTypeToMenu(javax.swing.JMenuItem menuItem, String ItemText, javax.swing.JMenu menu){
        menuItem.setFont(new java.awt.Font(ItemText, 0, 11)); // NOI18N
        menuItem.setText(ItemText);
        menu.add(menuItem);
    }

    private void createFontTypeHandler(javax.swing.JMenuItem menuItem){
        String font = menuItem.getFont().getName();
        Action fontAction = new StyledEditorKit.FontFamilyAction(font, font);
        fontAction.putValue(Action.NAME, font);
        menuItem.setAction(fontAction);
    }
}
