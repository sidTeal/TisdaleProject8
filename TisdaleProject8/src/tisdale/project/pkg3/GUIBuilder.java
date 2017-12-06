package tisdale.project.pkg3;

import java.awt.*;
import javax.swing.*;

/******************************************************
***  Class Name: GUIBuilder
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class holds methods for use when adding components to a JFrame
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
public class GUIBuilder {
    
/*****************************************************
*** Method Name: addComponent
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: adds JPanel component to panel using GridBagConstraints
***                         with all of the passed values
*** Method parameters: JPanel panel, JComponent comp, int xPos, int yPos,
                        int compWidth, int compHeight, int place, int stretch
*** Return value: void
******************************************************
*** Date: September 27
******************************************************/
    public static void addComponent(JPanel panel, JComponent comp, int xPos, int yPos,
            int compWidth, int compHeight, int place, int stretch) {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        panel.add(comp, gridConstraints);
    }
    
/*****************************************************
*** Method Name: addComponent
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: adds JDialog component to panel using GridBagConstraints
***                         with all of the passed values
*** Method parameters: JDialog dialog, JComponent comp, int xPos, int yPos,
                        int compWidth, int compHeight, int place, int stretch
*** Return value: void
******************************************************
*** Date: September 27
******************************************************/    
    public static void addComponent(JDialog dialog, JComponent comp, int xPos, int yPos,
            int compWidth, int compHeight, int place, int stretch) {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        dialog.add(comp, gridConstraints);
    }
}
