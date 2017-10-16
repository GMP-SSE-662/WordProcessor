package wordProcessor;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class FormatMenu {
    private javax.swing.JMenuItem bold = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem italicize = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem underline = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem fontChangeColour = new javax.swing.JMenuItem();
    private javax.swing.JMenu formatMenu = new javax.swing.JMenu();
    private Color selectedColor = Color.BLACK; //setting default colour in colour chooser to black
    private javax.swing.JFrame parentWindow;

    public FormatMenu(javax.swing.JFrame parentWindow){
        this.parentWindow = parentWindow;
    }

    public javax.swing.JMenu getMenu(){
        formatMenu.setText("Format");

        Action boldAction = new StyledEditorKit.BoldAction();
        boldAction.putValue(Action.NAME, "Bold Text");
        bold.setAction(boldAction); //setting bold action to the bold menu item

        Action underlineAction = new StyledEditorKit.UnderlineAction();
        underlineAction.putValue(Action.NAME, "Underline Text");
        underline.setAction(underlineAction); //setting underline action to the underline menu item

        Action italicizeAction = new StyledEditorKit.ItalicAction();
        italicizeAction.putValue(Action.NAME, "Italicize Text");
        italicize.setAction(italicizeAction); //setting italic action to the italicize menu item

        addMenuItemToMenu(bold, "Bold Text", formatMenu);

        addMenuItemToMenu(italicize, "Italicize Text", formatMenu);

        addMenuItemToMenu(underline, "Underline Text", formatMenu);

        fontChangeColour.setText("Change Font Colour");
        fontChangeColour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fontChangeColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontChangeColourActionPerformed(evt);
            }
        });
        formatMenu.add(fontChangeColour);

        return null;
    }

    private void addMenuItemToMenu(javax.swing.JMenuItem menuItem, String ItemText, javax.swing.JMenu menu) {
        menuItem.setText(ItemText);
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        menu.add(menuItem);
    }

    private void fontChangeColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontChangeColourActionPerformed
        // TODO add your handling code here:
        selectedColor = JColorChooser.showDialog(parentWindow, "Pick a font color", selectedColor); //show JColorChooser and save colour user
        //selects
        Action changeFontColorAction = new StyledEditorKit.ForegroundAction("Pick a font color", selectedColor);  //set colour of selected
        //text to user selected
        //colour
        changeFontColorAction.putValue(Action.NAME, "Change font colour");
        changeFontColorAction.actionPerformed(evt); //set this action to be performed when user clicks the font colour change menu item
    }//GEN-LAST:event_fontChangeColourActionPerformed
}
