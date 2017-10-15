package wordProcessor;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class EditMenu {
    private javax.swing.JMenu editMenu = new javax.swing.JMenu();
    private javax.swing.JMenuItem copyOption = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem cutOption = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem pasteOption = new javax.swing.JMenuItem();

    public javax.swing.JMenu getMenu(){
        editMenu.setText("Edit");

        Action copyAction = new StyledEditorKit.CopyAction();
        copyAction.putValue(Action.NAME, "Copy");
        copyOption.setAction(copyAction); //setting copy action to the copy menu item

        Action pasteAction = new StyledEditorKit.PasteAction();
        pasteAction.putValue(Action.NAME, "Paste");
        pasteOption.setAction(pasteAction); //setting paste action to the paste menu item

        Action cutAction = new StyledEditorKit.CutAction();
        cutAction.putValue(Action.NAME, "Cut");
        cutOption.setAction(cutAction); //setting cut action to the cut menu item

        addMenuItemToMenu(cutOption, "Cut", editMenu);

        addMenuItemToMenu(copyOption, "Copy", editMenu);

        addMenuItemToMenu(pasteOption, "Paste", editMenu);

        return editMenu;
    }

    private void addMenuItemToMenu(javax.swing.JMenuItem menuItem, String ItemText, javax.swing.JMenu menu) {
        menuItem.setText(ItemText);
        menu.add(menuItem);
    }
}
