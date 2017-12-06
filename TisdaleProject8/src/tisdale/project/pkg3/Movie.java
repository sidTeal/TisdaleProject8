package tisdale.project.pkg3;

import java.util.Arrays;
import java.util.Date;

/******************************************************
***  Class Name: Movie
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides StoreItem with a child class Movie. It holds the private field variables,
*** method functionality and constructor for Movie items.
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
public class Movie extends StoreItem{
    private static int movieCount = 0;
    private String director;
    private String[] actors;
    private String[] actresses;
    
/*****************************************************
*** Movie Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of movie by calling StoreItem constructor, use setters for director, actors, and actresses,
***             then increments movieCount by 1.
******************************************************
*** Date: September 20
******************************************************/    
    Movie(String title, String director, Date dateAcquired, int purchasePrice, int askingPrice, 
             String[] actors, String[] actresses) {       
        super(title, dateAcquired, purchasePrice, askingPrice);
        setDirector(director);
        setActors(actors);
        setActresses(actresses);
        movieCount++;
    }

/*****************************************************
*** Method Name: incrementMovieCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: increment movieCount
*** Method parameters: none
*** Return value: void
******************************************************
*** Date: November 6
******************************************************/   
    static public void incrementMovieCount(){
        movieCount++;
    }

/*****************************************************
*** Method Name: getCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns movieCount
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/        
    public static int getCount() {
        return movieCount;
    }
 
/*****************************************************
*** Method Name: setDirector
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets director if String is 2 characters or longer
***                             else throws exception
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setDirector(String director) {
        if (director.length() > 1) {
            this.director = director;
        } else {
            throw new IllegalArgumentException("Author must be a string of at least two characters .");
        }
    }

/*****************************************************
*** Method Name: getDirector
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns director
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/     
    public String getDirector() {
        return director;
    }

/*****************************************************
*** Method Name: setActors
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets actors to String array it is passed
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/    
    public void setActors(String[] actors) {
        this.actors = actors;
    }

/*****************************************************
*** Method Name: getActors
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns actors array
*** Method parameters: none
*** Return value: String[]
******************************************************
*** Date: September 20
******************************************************/     
    public String[] getActors() {
        return actors;
    }

/*****************************************************
*** Method Name: setActresses
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets actresses to String array it is passed
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/        
    public void setActresses(String[] actresses) {
        this.actresses = actresses;
    }

/*****************************************************
*** Method Name: getActresses
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns actresses array
*** Method parameters: none
*** Return value: String[]
******************************************************
*** Date: September 20
******************************************************/
    public String[] getActresses() {
        return actresses;
    }
    
/*****************************************************
*** Method Name: remove
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: reduces movieCount by 1 and calls
***                         StoreItem remove method
*** Method parameters: none
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/        
    @Override
    public void remove() {
        movieCount--;
        super.remove();
    }

/*****************************************************
*** Method Name: printableString
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns movieInfo string that displays
***                         all of the information about the movie.
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/        
    public String printableString(){
        String movieInfo = "Title: " + this.getTitle() + "\nDate Acquired: " + this.getDateAcquired() + 
                "\nPurchase Price: " + this.getPurchasePrice() + "\nAsking Price: " + this.getAskingPrice() + 
                "\nDirector: " + this.getDirector() + "\nActors: " + Arrays.toString(this.getActors()) + 
                "\nActresses: " + Arrays.toString(this.getActresses());
        
        return movieInfo;
    }
}
