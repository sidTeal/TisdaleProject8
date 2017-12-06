package tisdale.project.pkg3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import static tisdale.project.pkg3.TisdaleProject8.DATABASE_URL;

/******************************************************
***  Class Name: AddMovieFrame
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class builds the AddMovieFrame.
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
*** December 5:     Added connection and ability to add movies to database.
******************************************************
***  
*******************************************************/
public class AddMovieFrame extends JFrame{
    JLabel titleLabel, dateAcquiredLabel, purchasePriceLabel, askingPriceLabel, directorLabel, instructionLabel, actorsLabel, actressesLabel;
    JTextField titleTextField, purchasePriceTextField, askingPriceTextField, directorTextField, 
            actorsTextField, actorsTextField1, actorsTextField2, actorsTextField3, actorsTextField4,
            actressesTextField, actressesTextField1, actressesTextField2, actressesTextField3, actressesTextField4;
    
    JSpinner dateAcquiredSpin;
    JButton addButton;

/*****************************************************
*** AddMovieFrame Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of AddMovieFrame. Adds labels and button, as well as button action listener to the JFrame.
******************************************************
*** Date: September 27
******************************************************/    
    public AddMovieFrame(){
        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Add Movie");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());
        
        Date todaysDate = new Date(); // get todays date
        
        titleLabel = new JLabel("   Title: ");
        dateAcquiredLabel = new JLabel("   Date Acquired: ");
        purchasePriceLabel = new JLabel("   Purchase Price: ");
        askingPriceLabel = new JLabel("   Asking Price: ");
        directorLabel = new JLabel("   Director: ");
        instructionLabel = new JLabel("Enter one cast member per box below.");
        actorsLabel = new JLabel("   Actors: ");
        actressesLabel = new JLabel("   Actresses: ");
        
        titleTextField = new JTextField(10);
        dateAcquiredSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateAcquiredSpin, "dd/MM/yy"); // set date editor format
        dateAcquiredSpin.setEditor(dateEditor); // set editor to chosen format
        purchasePriceTextField = new JTextField(10);
        askingPriceTextField = new JTextField(10);
        directorTextField = new JTextField(10);
        actorsTextField = new JTextField(10);
        actorsTextField1 = new JTextField(10);
        actorsTextField2 = new JTextField(10);
        actorsTextField3 = new JTextField(10);
        actorsTextField4 = new JTextField(10);
        actressesTextField = new JTextField(10);
        actressesTextField1 = new JTextField(10);
        actressesTextField2 = new JTextField(10);
        actressesTextField3 = new JTextField(10);
        actressesTextField4 = new JTextField(10);
        
        addButton = new JButton("Add");
        
        // create new movie populated from fields on frame, error dialog pop up if invalid entry
        addButton.addActionListener(new ActionListener() {
            
/*****************************************************
*** Method Name: actionPerformed
*** Author: Chris Tisdale
******************************************************
*** Purpose of the Method: handles logic for adding movie when clicked.
***     Added connection and ability to add movies to database.
*** Method parameters: none
*** Return value: void
******************************************************
*** Date: September 27
******************************************************/
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = false;
                
                // used for changing actor and actress arrays to String for db
                String tempActors = "";
                String tempActresses = "";
                
                
                try {
                    ArrayList<String> actorList = new ArrayList<>();
                    String actor = actorsTextField.getText();
                    String actor1 = actorsTextField1.getText();
                    String actor2 = actorsTextField2.getText();
                    String actor3 = actorsTextField3.getText();
                    String actor4 = actorsTextField4.getText();
                    
                    ArrayList<String> actressList = new ArrayList<>();
                    String actress = actressesTextField.getText();
                    String actress1 = actressesTextField1.getText();
                    String actress2 = actressesTextField2.getText();
                    String actress3 = actressesTextField3.getText();
                    String actress4 = actressesTextField4.getText();
                    
                    if (!actor.isEmpty()) {
                        actorList.add(actor);
                    }
                    if (!actor1.isEmpty()) {
                        actorList.add(actor1);
                    }
                    if (!actor2.isEmpty()) {
                        actorList.add(actor2);
                    }
                    if (!actor3.isEmpty()) {
                        actorList.add(actor3);
                    }
                    if (!actor4.isEmpty()) {
                        actorList.add(actor4);
                    }
                    
                    if (!actress.isEmpty()) {
                        actressList.add(actress);
                    }
                    if (!actress1.isEmpty()) {
                        actressList.add(actress1);
                    }
                    if (!actress2.isEmpty()) {
                        actressList.add(actress2);
                    }
                    if (!actress3.isEmpty()) {
                        actressList.add(actress3);
                    }
                    if (!actress4.isEmpty()) {
                        actressList.add(actress4);
                    }
                    
                    String[] actors = actorList.toArray(new String[actorList.size()]);
                    String[] actresses = actressList.toArray(new String[actressList.size()]);
                    
                    // store actors and actresses as String
                    StringBuilder sb = new StringBuilder();
                    for (String a : actors){
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(a);
                    }
                    tempActors = sb.toString();
                    
                    StringBuilder sb1 = new StringBuilder();
                    for (String a : actresses){
                        if (sb1.length() > 0) {
                            sb1.append(",");
                        }
                        sb1.append(a);
                    }
                    tempActresses = sb1.toString();
                    
                    
                    Movie movie = new Movie(titleTextField.getText(), directorTextField.getText(), (Date)dateAcquiredSpin.getValue(),
                            Integer.parseInt(purchasePriceTextField.getText()), Integer.parseInt(askingPriceTextField.getText()),
                            actors, actresses);
                    InventoryGUI.movies.add(movie);

                    JFrame frame;
                    frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Movie added.");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                    success = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nMissing or invalid entry.\nPlease correct this problem and try again.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nPlease correct this problem and try again.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                
                // if movie is successfully added to inventory, write to database
                if (success){
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection con = DriverManager.getConnection(DATABASE_URL);
                        Statement statement = con.createStatement();
                        // System.out.println("connected");
                        
                        String tempTitle = InventoryGUI.movies.get(InventoryGUI.movies.size()-1).getTitle();
                        String tempDirector = InventoryGUI.movies.get(InventoryGUI.movies.size()-1).getDirector();
                        int tempPurchasePrice = InventoryGUI.movies.get(InventoryGUI.movies.size()-1).getPurchasePrice();
                        int tempAskingPrice = InventoryGUI.movies.get(InventoryGUI.movies.size()-1).getAskingPrice();
                        
                        // format date string
                        Date unformattedDate = InventoryGUI.paintings.get(InventoryGUI.paintings.size()-1).getDateAcquired();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");
                        String tempDate = formatter.format(unformattedDate);
                        
                        String query = "INSERT db_owner.Movies VALUES ('" + tempTitle + "', '" + tempDate + "', " + 
                                tempPurchasePrice + ", " + tempAskingPrice + ", '" + tempActors + "', '" +
                                tempActresses + "', '" + tempDirector + "')";
                        
                        // System.out.println(query);
                        statement.execute(query);    
                                                
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: \n" + ex + "\nPlease correct this problem and try again.",
                                "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // END if success
            } // END action performed
        });
        
        GUIBuilder.addComponent(mainPanel, titleLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, dateAcquiredLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, purchasePriceLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, askingPriceLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, directorLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, instructionLabel, 1, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsLabel, 0, 6, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actressesLabel, 0, 11, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        
        GUIBuilder.addComponent(mainPanel, titleTextField, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, dateAcquiredSpin, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, purchasePriceTextField, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, askingPriceTextField, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, directorTextField, 1, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsTextField, 1, 6, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsTextField1, 1, 7, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsTextField2, 1, 8, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsTextField3, 1, 9, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actorsTextField4, 1, 10, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        
        GUIBuilder.addComponent(mainPanel, actressesTextField, 1, 11, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actressesTextField1, 1, 12, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actressesTextField2, 1, 13, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actressesTextField3, 1, 14, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, actressesTextField4, 1, 15, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        
        GUIBuilder.addComponent(mainPanel, addButton, 1, 16, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(450, 700);
        this.setResizable(true);
    }
}
