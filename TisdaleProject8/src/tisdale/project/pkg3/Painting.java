package tisdale.project.pkg3;

import java.util.Date;

/******************************************************
***  Class Name: Painting
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides StoreItem with a child class Painting. It holds the private field variables,
*** method functionality and constructor for Painting items.
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
public class Painting extends StoreItem{
    private static int paintingCount = 0;
    private int height;
    private int width;
    private String painter;
    private String media;    
 
/*****************************************************
*** Painting Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of painting by calling StoreItem constructor, use setters for height, width, painter, media,
***             then increments paintingCount by 1.
******************************************************
*** Date: September 20
******************************************************/
    Painting(String title, String painter, Date dateAcquired, int purchasePrice, int askingPrice, 
            int height, int width, String media) {       
        super(title, dateAcquired, purchasePrice, askingPrice);
        setHeight(height);
        setWidth(width);
        setPainter(painter);
        setMedia(media);
        paintingCount++;
    }
    
/*****************************************************
*** Method Name: incrementPaintingCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: increment paintingCount
*** Method parameters: none
*** Return value: void
******************************************************
*** Date: November 6
******************************************************/   
    static public void incrementPaintingCount(){
        paintingCount++;
    }

/*****************************************************
*** Method Name: getCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns paintingCount
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/    
    public static int getCount() {
        return paintingCount;
    }
    
/*****************************************************
*** Method Name: getPainter
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns painter
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/ 
    public String getPainter() {
        return painter;
    }
    
/*****************************************************
*** Method Name: setPainter
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets painter if String is 2 characters or longer
***                             else throws exception
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    public void setPainter(String painter) {
        if (painter.length() > 1) {
            this.painter = painter;
        } else {
            throw new IllegalArgumentException("Painter must be a string of at least two characters .");
        }
    }

/*****************************************************
*** Method Name: setHeight
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets height if passed positive whole number
***                             else throws exception
*** Method parameters: int
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    private void setHeight(int height) {
        if (height > 0) {
            this.height = height;;
        } else {
            throw new IllegalArgumentException("Height must be a positive whole number.");
        }
    }
    
/*****************************************************
*** Method Name: getHeight
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns height
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/     
    public int getHeight() {
        return height;
    }
    
/*****************************************************
*** Method Name: setWidth
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets width if passed positive whole number
***                             else throws exception
*** Method parameters: int
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    private void setWidth(int width) {
        if (width > 0) {
            this.width = width;;
        } else {
            throw new IllegalArgumentException("Width must be a positive whole number.");
        }
    }
    
/*****************************************************
*** Method Name: getWidth
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns width
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/     
    public int getWidth() {
        return width;
    }
/*****************************************************
*** Method Name: setMedia
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets media if valid choice
***                             else throws exception
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    private void setMedia(String media) {
        if (media.equals("oil") || media.equals("acrylic") || media.equals("watercolor") || media.equals("ink") || 
                media.equals("charcoal") || media.equals("airbrush")) {
            this.media = media;
        } else {
            throw new IllegalArgumentException("Please make a selection for media.");
        }
    }
    
/*****************************************************
*** Method Name: getMedia
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns media
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/     
    public String getMedia(){
        return media;
    }
    
/*****************************************************
*** Method Name: remove
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: reduces paintingCount by 1 and calls
***                         StoreItem remove method
*** Method parameters: none
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    @Override
    public void remove() {
        paintingCount--;
        super.remove();
    }

/*****************************************************
*** Method Name: printableString
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns paintingInfo string that displays
***                         all of the information about the painting.
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/    
    public String printableString(){
        String paintingInfo = "Title: " + this.getTitle() + "\nDate Acquired: " + this.getDateAcquired() + "\nPurchase Price: " + this.getPurchasePrice() + 
                "\nAsking Price: " + this.getAskingPrice()+ "\nHeight: " + this.getHeight() + 
                "\nWidth: " + this.getWidth()+ "\nMedia: " + this.getMedia();
        
        return paintingInfo;
    }
}
