package tisdale.project.pkg3;

import java.io.*;
import java.util.ArrayList;

/******************************************************
***  Class Name: Deserialize
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides InventoryGUI with a the method to deserialize objects
*** from a file for use with the program.
****************************************************** 
*** November 7, 2017
*******************************************************/
public class Deserialize {

    static final int MAX_SIZE = 100; //maximum number of possible objects to serialize, can be increased
    static ArrayList<StoreItem> items = new ArrayList<>();

/*****************************************************
*** Method Name: deserialize
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: deserialize from a .ser file and return ArrayList of objects
*** Method parameters: File inputFile
*** Return value: void
******************************************************
*** Date: November 7
     * @param inputFile
     * @return 
******************************************************/
    static public ArrayList deserialize(File inputFile) {
        try {
            try (FileInputStream fileIn = new FileInputStream(inputFile)) {
                ObjectInputStream in = new ObjectInputStream(fileIn);
                for (int i = 0; i < MAX_SIZE; i++) {
                    StoreItem item = (StoreItem) in.readObject();
                    items.add(item);
                }
                in.close();
            }

        } catch (EOFException e) {
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("StoreItem class not found");
            c.printStackTrace();
        }
        return items;
    }
}
