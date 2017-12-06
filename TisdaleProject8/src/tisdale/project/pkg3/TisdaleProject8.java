package tisdale.project.pkg3;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class TisdaleProject8 {

/******************************************************
***  Class Name: TisdaleProject8
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class simply initializes a StoreItem of each type and creates a new instance of 
*** the InventoryGUI, passing it the initial items.
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
*** December 4:     Added connection and retrieval of inventory from database.
*** December 5:     Added connection and ability to add inventory to database within AddBookFrame, AddPaintingFrame,
***                 and AddMovieFrame.
*** December 6:     Added connection and ability to remove inventory when an item is sold.
***                 Final Testing and comments.
******************************************************
***  
*******************************************************/
static final String DATABASE_URL = "jdbc:sqlserver://CTASV20R2DRW.tamuct.edu;databaseName=Tis_Dale_JavaAssigmt_8;user=Chris;password=Tisdale016;";


    public static void main(String[] args) {

        ArrayList<Book> initBooks = new ArrayList<>();
        ArrayList<Movie> initMovies = new ArrayList<>();
        ArrayList<Painting> initPaintings = new ArrayList<>();
        
//        initBooks.add(new Book("The Hobbit", "Tolkien", new Date(116, 3, 11), 3, 7, "Fantasy"));
//        
//        String actors[] = {"Schwarzenegger", "Biehn"};
//        String actresses[] = {"Hamilton", "Motta"};
//        initMovies.add(new Movie("The Terminator", "Cameron", new Date(115, 9, 22), 4, 8, actors, actresses));
//
//        initPaintings.add(new Painting("Mountainscape", "Ross", new Date(116, 4, 5), 33, 66, 24, 12, "oil"));
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(DATABASE_URL);
            Statement statement = con.createStatement();
            //System.out.println("connected");
            
            //********ADD BOOKS FROM DB
            String query = "SELECT Title, Author, Date, PurchasePrice, AskingPrice, Genre FROM Books";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfCol = metaData.getColumnCount();
            //System.out.println(metaData.getColumnName(1).toString().trim());
            while(resultSet.next()){
                String tempTitle = null;
                String tempAuthor = null;
                String tempGenre = null;
                int tempPurchasePrice = 0;
                int tempAskingPrice = 0;
                java.util.Date tempDate = null;
                
               for(int i=1; i<=numberOfCol; i++)
               {                   
                    //System.out.println(resultSet.getObject(i).toString().trim());

                    switch (i){
                       
                        case 1: tempTitle = resultSet.getObject(i).toString().trim();
                            break;
                        case 2: tempAuthor = resultSet.getObject(i).toString().trim();
                            break;
                        case 3: tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse(resultSet.getObject(i).toString().trim());
//                                System.out.println(tempDate);
//                                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//                                String dateText = df.format(tempDate);
//                                System.out.println(dateText);
                            break;
                        case 4: tempPurchasePrice = (int) resultSet.getObject(i);
                            break;
                        case 5: tempAskingPrice = (int) resultSet.getObject(i);
                            break;
                        case 6: tempGenre = resultSet.getObject(i).toString().trim();
                            break;                       
                   }
               }
               initBooks.add(new Book(tempTitle, tempAuthor, tempDate, tempPurchasePrice, tempAskingPrice, tempGenre));
            }

            //********ADD MOVIES FROM DB
            query = "SELECT Title, Director, Date, PurchasePrice, AskingPrice, Actors, Actresses FROM Movies";
            resultSet = statement.executeQuery(query);
            metaData = resultSet.getMetaData();
            numberOfCol = metaData.getColumnCount();
            //System.out.println(metaData.getColumnName(1).toString().trim());
            while(resultSet.next()){
                String tempTitle = null;
                String tempDirector = null;
                java.util.Date tempDate = null;                
                int tempPurchasePrice = 0;
                int tempAskingPrice = 0;
                String tempActors = null;
                String tempActresses = null;
                String[] tempActorsA = null;
                String[] tempActressesA = null;
                
                
               for(int i=1; i<=numberOfCol; i++)
               {                   
//                    System.out.println(resultSet.getObject(i).toString().trim());

                    switch (i){
                       
                        case 1: tempTitle = resultSet.getObject(i).toString().trim();
                            break;
                        case 2: tempDirector = resultSet.getObject(i).toString().trim();
                            break;
                        case 3: tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse(resultSet.getObject(i).toString().trim());
                            break;
                        case 4: tempPurchasePrice = (int) resultSet.getObject(i);
                            break;
                        case 5: tempAskingPrice = (int) resultSet.getObject(i);
                            break;
                        case 6: tempActors = resultSet.getObject(i).toString().trim();
                            break;
                        case 7: tempActresses = resultSet.getObject(i).toString().trim();
                            break;
                   }
               }
               tempActorsA = tempActors.split(",");
               tempActressesA = tempActresses.split(",");
               initMovies.add(new Movie(tempTitle, tempDirector, tempDate, tempPurchasePrice, tempAskingPrice, tempActorsA, tempActressesA));
            }
            
            //********ADD PAINTING FROM DB
            query = "SELECT Title, Painter, Date, PurchasePrice, AskingPrice, Height, Width, Media FROM Paintings";
            resultSet = statement.executeQuery(query);
            metaData = resultSet.getMetaData();
            numberOfCol = metaData.getColumnCount();
            //System.out.println(metaData.getColumnName(1).toString().trim());
            while(resultSet.next()){
                String tempTitle = null;
                String tempPainter = null;
                java.util.Date tempDate = null;                
                int tempPurchasePrice = 0;
                int tempAskingPrice = 0;
                int tempHeight = 0;
                int tempWidth = 0;
                String tempMedia = null;
                
                
               for(int i=1; i<=numberOfCol; i++)
               {                   
                    //System.out.println(resultSet.getObject(i).toString().trim());

                    switch (i){
                       
                        case 1: tempTitle = resultSet.getObject(i).toString().trim();
                            break;
                        case 2: tempPainter = resultSet.getObject(i).toString().trim();
                            break;
                        case 3: tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse(resultSet.getObject(i).toString().trim());
                            break;
                        case 4: tempPurchasePrice = (int) resultSet.getObject(i);
                            break;
                        case 5: tempAskingPrice = (int) resultSet.getObject(i);
                            break;
                        case 6: tempHeight = (int) resultSet.getObject(i);
                            break;
                        case 7: tempWidth = (int) resultSet.getObject(i);
                            break;
                        case 8: tempMedia = resultSet.getObject(i).toString().trim();
                            break;
                   }
               }
               initPaintings.add(new Painting(tempTitle, tempPainter, tempDate, tempPurchasePrice, tempAskingPrice, tempHeight, tempWidth, tempMedia));
            }
        }
        catch(Exception e) {
            System.out.println("Exception :"+e.getMessage());
        }
        
        InventoryGUI GUI = new InventoryGUI(initBooks, initMovies, initPaintings);
        
        }
    
}
