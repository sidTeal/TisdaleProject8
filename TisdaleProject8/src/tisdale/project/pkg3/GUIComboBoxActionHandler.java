package tisdale.project.pkg3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/******************************************************
***  Class Name: GUIComboBoxActionHandler
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class serves as an action handler for the combo boxes on InventoryGUI
****************************************************** 
*** October 3, 2017
******************************************************
*** September 20:   Created classes:    StoreItem, Book, Movie, Painting.
*** September 26:   Created classes:    TisdaleProject3 and tested class functionality.
*** September 27:   Created classes:    InventoryGUI, GUIBuilder, GUIComboBoxActionHandler,
***                                     AddBookFrame, AddMovieFrame, AddPaintingFrame.
*** September 28:   Created classes:    SellBookFrame, SellMovieFrame, SellPaintingFrame,
***                                     DisplayBookFrame, DisplayMovieFrame, DisplayPaitingFrame.
*** October 2:      Final comments and testing.
******************************************************
***  
*******************************************************/
public class GUIComboBoxActionHandler implements ActionListener {

/*****************************************************
*** Method Name: actionPerformed
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: creates JFrame that handles action chosen in the combo boxes
*** Method parameters: ActionEvent
*** Return value: none
******************************************************
*** Date: September 27
******************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        // ADD ITEM COMBOBOX
        if (e.getSource() == InventoryGUI.addItemList) {

            String item = (String) InventoryGUI.addItemList.getSelectedItem();
            
            // determines selected item and creates corresponding add item frame, resets selection
            switch (item) {
                case "Book":
                    AddBookFrame addBookFrame = new AddBookFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                case "Movie":
                    AddMovieFrame addMovieFrame = new AddMovieFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                case "Painting":
                    AddPaintingFrame addPaintingFrame = new AddPaintingFrame();
                    InventoryGUI.addItemList.setSelectedItem("");
                    break;
                default:
                    break;
            }
        // SELL ITEM COMBOBOX
        } else if (e.getSource() == InventoryGUI.sellItemList) {

            String item = (String) InventoryGUI.sellItemList.getSelectedItem();
            
            // determines selected item and creates corresponding sell item frame, resets selection
            // if count of that item type is zero then shows error message dialog
            switch (item) {
                case "Book":
                    if (Book.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Books to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellBookFrame sellBookFrame = new SellBookFrame();
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                    break;
                case "Movie":
                    if (Movie.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Movies to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellMovieFrame sellMovieFrame = new SellMovieFrame(InventoryGUI.movies);
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                    break;
                case "Painting":
                    if (Painting.getCount() == 0) {
                        InventoryGUI.sellItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Paintings to sell.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SellPaintingFrame sellPaintingFrame = new SellPaintingFrame(InventoryGUI.paintings);
                        InventoryGUI.sellItemList.setSelectedItem("");
                    }
                default:
                    break;
            }
        // DISPLAY ITEM COMBOBOX
        } else if (e.getSource() == InventoryGUI.displayItemList) {

            String item = (String) InventoryGUI.displayItemList.getSelectedItem();

            // determines selected item and creates corresponding display item frame, resets selection
            // if count of that item type is zero then shows error message dialog
            switch (item) {
                case "Book":
                    if (Book.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Books to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayBookFrame displayBookFrame = new DisplayBookFrame(InventoryGUI.books);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                case "Movie":
                    if (Movie.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Movies to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayMovieFrame displayMovieFrame = new DisplayMovieFrame(InventoryGUI.movies);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                case "Painting":
                    if (Painting.getCount() == 0) {
                        InventoryGUI.displayItemList.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Error: \n" + "\nNo Paintings to Display.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        DisplayPaintingFrame displayPaintingFrame = new DisplayPaintingFrame(InventoryGUI.paintings);
                        InventoryGUI.displayItemList.setSelectedItem("");
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
