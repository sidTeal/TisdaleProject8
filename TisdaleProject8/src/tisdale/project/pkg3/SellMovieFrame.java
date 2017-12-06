package tisdale.project.pkg3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import static tisdale.project.pkg3.TisdaleProject8.DATABASE_URL;

/******************************************************
***  Class Name: SellMovieFrame
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class builds the SellMovieFrame.
****************************************************** 
*** October 3, 2017
******************************************************
*** September 20:   Created classes:    StoreItem, Book, Movie, Painting.
*** September 26:   Created classes:    TisdaleProject3 and tested class functionality.
*** September 27:   Created classes:    InventoryGUI, GUIBuilder, GUIComboBoxActionHandler,
***                                     AddBookFrame, AddMovieFrame, AddPaintingFrame.
*** September 28:   Created classes:    SellBookFrame, SellMovieFrame, SellPaintingFrame,
***                                     DisplayBookFrame, DisplayMovieFrame, DisplayPaitingFrame.
*** October 2, 3:      Final comments and testing.
*** December 6:     Added connection and ability to remove movies from database.
******************************************************
***  
*******************************************************/
public class SellMovieFrame extends JFrame {

    JLabel sellLabel;
    static JComboBox movieList;

/*****************************************************
*** SellMovieFrame Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of SellMovieFrame. Adds labels and combo box, as well as button action listener to the combobox.
******************************************************
*** Date: September 28
******************************************************/
    public SellMovieFrame(ArrayList<Movie> movies) {
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Sell Movie");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        ArrayList<Movie> currentMovies = movies;
        String[] movieTitles = new String[currentMovies.size() + 1];
        movieTitles[0] = "";

        for (int i = 0; i < currentMovies.size(); i++) {
            movieTitles[i + 1] = currentMovies.get(i).getTitle();
        }

        sellLabel = new JLabel("   Sell: ");
        movieList = new JComboBox(movieTitles);
        ComboBoxActionHandler lForComboBox = new ComboBoxActionHandler();
        movieList.addActionListener(lForComboBox);

        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, movieList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 400);
        this.setResizable(true);
    }
    
/******************************************************
***  Class Name: ComboBoxActionHandler
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class serves as an action handler for the combo box
****************************************************** 
*** October 3, 2017
******************************************************
*** September 20:   Created classes:    StoreItem, Book, Movie, Painting.
*** September 26:   Created classes:    TisdaleProject3 and tested class functionality.
*** September 27:   Created classes:    InventoryGUI, GUIBuilder, GUIComboBoxActionHandler,
***                                     AddBookFrame, AddMovieFrame, AddPaitingFrame.
*** September 28:   Created classes:    SellBookFrame, SellMovieFrame, SellPaintingFrame,
***                                     DisplayBookFrame, DisplayMovieFrame, DisplayPaitingFrame.
*** October 2:      Final comments and testing.
*** December 6:     Added connection and ability to remove movies from database.
******************************************************
***  
*******************************************************/
    public class ComboBoxActionHandler implements ActionListener {
        
/*****************************************************
*** Method Name: actionPerformed
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: removes chosen movie from inventory and shows dialog pop up confirming sale
***              Added connection and ability to remove movies from database.
*** Method parameters: ActionEvent
*** Return value: void
******************************************************
*** Date: September 28
******************************************************/
        @Override
        public void actionPerformed(ActionEvent e) {

            String item = movieList.getSelectedItem().toString();
            if (item == "") {
                return;
            } else {
                for (int i = 0; i < InventoryGUI.movies.size(); i++) {
                    if (InventoryGUI.movies.get(i).getTitle() == item) {
                        InventoryGUI.movies.get(i).remove();
                        InventoryGUI.movies.remove(i);
                        movieList.setSelectedItem("");

                        // remove item from db
                        try{
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            Connection con = DriverManager.getConnection(DATABASE_URL);
                            Statement statement = con.createStatement();
                            // System.out.println("connected");
                        
                            String query = "DELETE FROM db_owner.Movies WHERE Title='" + item +"';";
                        
                            // System.out.println(query);
                            statement.execute(query);
                        
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nPlease correct this problem and try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        JFrame frame;
                        frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Movie sold.");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        dispose();
                    }
                }
            }

        }
    }
}
