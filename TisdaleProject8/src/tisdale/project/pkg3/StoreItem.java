package tisdale.project.pkg3;

import java.io.Serializable;
import java.util.Date;

/******************************************************
***  Class Name: StoreItem
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides StoreItem class functionality. It holds the private field variables,
*** method functionality and constructor for store items.
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
public class StoreItem implements Serializable {

    private static int itemCount = 0;
    private String title;
    private Date dateAcquired;
    private int purchasePrice;
    private int askingPrice;
    
/*****************************************************
*** StoreItem Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of StoreItem using setters for title, dateAcquired, purchasePrice, askingPrice,
***             then increments itemCount by 1.
******************************************************
*** Date: September 20
******************************************************/
    StoreItem(String title, Date dateAcquired, int purchasePrice, int askingPrice) {
        setTitle(title);
        setDateAcquired(dateAcquired);
        setPurchasePrice(purchasePrice);
        setAskingPrice(askingPrice);
        itemCount++;
    }

/*****************************************************
*** Method Name: getCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns itemCount
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/
    public static int getCount() {
        return itemCount;
    }

/*****************************************************
*** Method Name: getTitle
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns title
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/
    public String getTitle() {
        return title;
    }

/*****************************************************
*** Method Name: setTitle
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets title if it is at least one char long
***                             else throws exception
*** Method parameters: String
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setTitle(String title) {
        if (title.length() >= 1) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title must be a string of at least one character.");
        }

    }

/*****************************************************
*** Method Name: getDateAcquired
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns dateAcquired
*** Method parameters: none
*** Return value: Date
******************************************************
*** Date: September 20
******************************************************/
    public Date getDateAcquired() {
        return dateAcquired;
    }

/*****************************************************
*** Method Name: setDateAcquired
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets dateAcquired
*** Method parameters: Date
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

/*****************************************************
*** Method Name: getPurchasePrice
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns purchasePrice
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/
    public int getPurchasePrice() {
        return purchasePrice;
    }

/*****************************************************
*** Method Name: setPurchasePrice
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets purchasePrice if it is a positive integer
***                             else throws exception
*** Method parameters: int
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setPurchasePrice(int purchasePrice) {
        if (purchasePrice >= 0) {
            this.purchasePrice = purchasePrice;;
        } else {
            throw new IllegalArgumentException("Purchase price must be a positive whole number.");
        }
    }

/*****************************************************
*** Method Name: getAskingPrice
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns askingPrice
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/
    public int getAskingPrice() {
        return askingPrice;
    }

/*****************************************************
*** Method Name: setAskingPrice
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets asking price if it is a positive integer
***                             else throws exception
*** Method parameters: int
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setAskingPrice(int askingPrice) {
        if (askingPrice > 0) {
            this.askingPrice = askingPrice;
        } else {
            throw new IllegalArgumentException("Asking price must be a positive whole number.");
        }
    }

/*****************************************************
*** Method Name: remove
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: reduces itemCount by 1
*** Method parameters: none
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void remove() {
        itemCount--;
    }

/*****************************************************
*** Method Name: calculateProfit
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns difference between purchasePrice and askingPrice
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/
    public int calculateProfit() {
        int profit = purchasePrice - askingPrice;
        return profit;
    }

}
