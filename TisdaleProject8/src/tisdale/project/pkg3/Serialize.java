package tisdale.project.pkg3;

import java.io.*;
import java.util.ArrayList;

/******************************************************
***  Class Name: Serialize
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides InventoryGUI with a the method to serialize objects
*** to a file for future use with the program.
****************************************************** 
*** October 30, 2017
*******************************************************/
public class Serialize {

/*****************************************************
*** Method Name: serialize
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: serialize ArrayList of objects to a .ser file for later use
*** Method parameters: ArrayList<StoreItem> items, File outputFile
*** Return value: void
******************************************************
*** Date: October 30
     * @param items
     * @param outputFile
******************************************************/
    static public void serialize(ArrayList<StoreItem> items, File outputFile) {
        try {
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (int i = 0; i < items.size(); i++) {
                StoreItem item = items.get(i);
                out.writeObject(item);
            }

            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
