package tisdale.project.pkg3;

import java.util.Date;

/******************************************************
***  Class Name: Book
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class provides StoreItem with a child class Book. It holds the private field variables,
*** method functionality and constructor for Book items.
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
public class Book extends StoreItem {

    private static int bookCount = 0;
    private String author;
    private String genre;

/*****************************************************
*** Book Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of book by calling StoreItem constructor, use setters for author and genre,
***             then increments bookCount by 1.
******************************************************
*** Date: September 20
******************************************************/
    Book(String title, String author, Date dateAcquired, int purchasePrice, int askingPrice, String genre) {
        super(title, dateAcquired, purchasePrice, askingPrice);
        setAuthor(author);
        setGenre(genre);
        bookCount++;
    }

/*****************************************************
*** Method Name: incrementBookCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: increment bookCount
*** Method parameters: none
*** Return value: void
******************************************************
*** Date: November 6
******************************************************/    
    static public void incrementBookCount(){
        bookCount++;
    }

/*****************************************************
*** Method Name: getCount
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns bookCount
*** Method parameters: none
*** Return value: int
******************************************************
*** Date: September 20
******************************************************/
    public static int getCount() {
        return bookCount;
    }

/*****************************************************
*** Method Name: getAuthor
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns author
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/
    public String getAuthor() {
        return author;
    }


/*****************************************************
*** Method Name: setAuthor
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets author if String is 2 characters or longer
***                             else throws exception
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setAuthor(String author) {
        if (author.length() > 1) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Author must be a string of at least two characters.");
        }
    }


/*****************************************************
*** Method Name: setGenre
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: sets genre if String is 2 characters or longer
***                             else throws exception
*** Method parameters: String 
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    public void setGenre(String genre) {
        if (genre.length() > 1) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Genre must be a string of at least two characters.");
        }
        
    }
    
/*****************************************************
*** Method Name: getGenre
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns genre
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/
    public String getGenre() {
        return genre;
    }

/*****************************************************
*** Method Name: remove
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: reduces bookCount by 1 and calls
***                         StoreItem remove method
*** Method parameters: none
*** Return value: none
******************************************************
*** Date: September 20
******************************************************/
    @Override
    public void remove() {
        bookCount--;
        super.remove();
    }

/*****************************************************
*** Method Name: printableString
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: returns bookInfo string that displays
***                         all of the information about the book.
*** Method parameters: none
*** Return value: String
******************************************************
*** Date: September 20
******************************************************/
    public String printableString() {
        String bookInfo = "Title: " + this.getTitle() + "\nDate Acquired: "
                + this.getDateAcquired() + "\nPurchase Price: " + this.getPurchasePrice()
                + "\nAsking Price: " + this.getAskingPrice() + "\nAuthor: " + this.getAuthor()
                + "\nGenre: " + this.getGenre();

        return bookInfo;
    }
}
