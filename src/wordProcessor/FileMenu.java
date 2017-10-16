package wordProcessor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;

public class FileMenu {
    JFileChooser fileDialog;
    File editFile;
    private final RTFEditorKit rtfKit = new RTFEditorKit();
    private javax.swing.JFrame parentWindow;
    private javax.swing.JTextPane textArea;
    private javax.swing.JMenu fileMenu = new javax.swing.JMenu();
    private javax.swing.JMenuItem saveFile = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem openFile = new javax.swing.JMenuItem();

    public FileMenu(javax.swing.JFrame window, javax.swing.JTextPane textArea){
        this.parentWindow = window;
        this.textArea = textArea;
    }

    public javax.swing.JMenu getMenu(){
        fileMenu.setText("File");

        saveFile.setText("Save Document");
        saveFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        fileMenu.add(saveFile);

        openFile.setText("Open a Document");
        openFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        fileMenu.add(openFile);

        return fileMenu;
    }

    private void doSave() {
        if (fileDialog == null) { //if JFileChooser dialog does not exist
            fileDialog = new JFileChooser(); //create a new one
            fileDialog.setFileFilter(new FileNameExtensionFilter("RTF text File", ".rtf")); //set the file extension to .rtf
        }
        File selectedFile;
        if (editFile == null) { //if new file is trying to be saved
            selectedFile = new File("filename.rtf"); //set intial file name in the dialog
        } else { //if file has been saved before
            selectedFile = new File(editFile.getName()); //get the name of this previously saved file
        }
        fileDialog.setSelectedFile(selectedFile); //set the file's name to the default or to the previously selected file
        fileDialog.setDialogTitle("Select File to be Saved"); //set the save dialog box title
        int option = fileDialog.showSaveDialog(parentWindow); //show the save dialog
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  //user canceled or clicked the dialog's close box, return to page
        }
        selectedFile = fileDialog.getSelectedFile();
        if (selectedFile.exists()) {  //if file with same name already exists
            int response = JOptionPane.showConfirmDialog(parentWindow, //ask the user whether to replace the file
                    "The file \"" + selectedFile.getName()
                            + "\" already exists.\nDo you want to replace it?",
                    "Confirm Save",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (response != JOptionPane.YES_OPTION) {
                return;  //user does not want to replace the file, return to page without saving
            }
        }
        OutputStream out;
        try {
            out = new FileOutputStream(selectedFile); //set FileOutputStream to the file user is trying to save
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parentWindow, ////if exception is caught tell user their file could not be saved
                    "Sorry, but an error occurred while trying to save the file:\n" + e);
            return; //return to page
        }
        try {
            rtfKit.write(out, textArea.getDocument(), 0, textArea.getDocument().getLength()); //write the text to the user saved file
            editFile = selectedFile; //set saved file to file being edited now
            parentWindow.setTitle("File Being Edited Right Now: " + editFile.getName()); //set title of window to say file just saved is being edited
        } catch (IOException | BadLocationException e) {
            JOptionPane.showMessageDialog(parentWindow, //if exception caught, tell user their file could not be written to
                    "Sorry, but an error occurred while trying to write the text:\n" + e);
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        // TODO add your handling code here:
        doSave(); //call the doSave function from below which will save the file
    }

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        doOpen(); //call the doOpen function to open the file
    }

    private void doOpen() {
        if (fileDialog == null) { //if JFileChooser does not exist
            fileDialog = new JFileChooser(); //create a new one
        }
        fileDialog.setDialogTitle("Select File to be Opened"); //set title of open dialog
        fileDialog.setSelectedFile(null);  //do not initially select any file
        int option = fileDialog.showOpenDialog(parentWindow); //show open dialog
        if (option != JFileChooser.APPROVE_OPTION) {
            return;  //user canceled or clicked the dialog's close box, so return the page without opening any file
        }
        File selectedFile = fileDialog.getSelectedFile(); //get file user has selected
        InputStream in;
        try {
            in = new FileInputStream(selectedFile); //set FileInputStream to file user is trying to open
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parentWindow, //if exception is caught, tell user their file could not be opened
                    "Sorry, but an error occurred while trying to open the file:\n" + e);
            return; //return to page without opening any file
        }
        try {
            StyledDocument doc = new DefaultStyledDocument();
            textArea.getEditorKit().read(in, doc, 0); //read in the text of the user selected file
            in.close();
            textArea.setStyledDocument(doc); //set text to page
            editFile = selectedFile; //set name of file being edited to the name of file just opened
            parentWindow.setTitle("File Being Edited Right Now: " + editFile.getName()); //set name of window to read file just opened as being edited
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parentWindow, //if exception is caught, tell user their file data could not be read
                    "Sorry, but an error occurred while trying to read the data:\n" + e);
        }
    }//GEN-LAST:event_openFileActionPerformed
}