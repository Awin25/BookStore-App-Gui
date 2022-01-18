/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.app;

import java.text.DecimalFormat;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.TableColumn.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.util.*;


public class OwnerBookScreen extends Application  {
    
    //creating book table object
    private TableView<Book> OwnerTable = new TableView<Book>();
    Stage window;
    Scene scene1, scene2;
    private final ObservableList<Book> data =
            //get book data here
            FXCollections.observableArrayList(
                    //sample books
            new Book("The Hobbit", 25.00),
            new Book("Harry Potter and the Philosopher's Stone", 36.00),
            new Book("The Da Vinci Code", 17.00),
            new Book("Fifty Shades of Grey", 45.00),
            new Book("Brave New World", 16.00));
    
     HBox hb = new HBox();//h box for buttons
      HBox aa = new HBox();//h box for buttons
    
    @Override
    public void start(Stage primaryStage) {
        //Creating GridPane
        GridPane OwnerBookScreenGrid = new GridPane();
        OwnerBookScreenGrid.setPadding(new Insets(10,10,10,10));
        OwnerBookScreenGrid.setVgap(10);
        OwnerBookScreenGrid.setHgap(10);
        
        //setting tabel to false non editable
        OwnerTable.setEditable(false);
        
        //Book Name Column
        TableColumn OwnerBookNameCol = new TableColumn("Book Name");
        OwnerBookNameCol.setMinWidth(200);
        OwnerBookNameCol.setCellValueFactory(
            new PropertyValueFactory<Book, String>("bookName"));
        OwnerBookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //Book Price Column
        TableColumn OwnerBookPriceCol = new TableColumn("Book Price");
        OwnerBookPriceCol.setMinWidth(200);
        
        OwnerBookPriceCol.setCellValueFactory(
            new PropertyValueFactory<Book, Double>("bookPrice"));
        
    
        
            //centering
        OwnerBookPriceCol.setCellFactory(new Callback<TableColumn<Book, String>, TableCell<Book, String>>(){
            public TableCell<Book, String> call(TableColumn<Book, String> p) {
                TextFieldTableCell<Book, String> cell = new TextFieldTableCell<Book, String>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        
        //setting up the table
        OwnerTable.setItems(data);    
        OwnerTable.getColumns().addAll(OwnerBookNameCol, OwnerBookPriceCol);
        OwnerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        GridPane.setConstraints(OwnerTable, 8, 1);
        OwnerBookScreenGrid.getChildren().add(OwnerTable);
        
        
        //Back Button
         window = primaryStage;
        Button BackButton = new Button();
        BackButton.setText("Back");
                    BackButton.setMinHeight(20);
        BackButton.setMaxHeight(50);
       BackButton.setMinWidth(80);
        BackButton.setMaxWidth(120);
        BackButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            
            // back button creates new window
            public void handle(ActionEvent event){
                          System.out.println("back");
                                   

        //Button 1
   
        Button button1 = new Button("Book");
        button1.setOnAction(e -> window.setScene(scene1));
                button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sending to Books Page");
                //send to books page
            }
        });
          GridPane.setConstraints( button1,10, 6);
        OwnerBookScreenGrid.getChildren().add(button1);
        
                Button button2 = new Button("Customers");
        button2.setOnAction(e -> window.setScene(scene1));
                button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Customers");
                //send to books page
            }
        });
          GridPane.setConstraints( button2,10, 6);
        OwnerBookScreenGrid.getChildren().add(button2);
        
                        Button button3 = new Button("Logout");
        button3.setOnAction(e -> window.setScene(scene1));
                button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logout");
                //send to books page
            }
        });
          GridPane.setConstraints( button3,10, 6);
        OwnerBookScreenGrid.getChildren().add(button3);
        

      
        VBox grid1 = new VBox(20);
        grid1.getChildren().addAll(button1,button2,button3);
        grid1.setAlignment(Pos.CENTER);
 Scene scene1 = new Scene(grid1, 600, 350);
 
 window.setScene(scene1);
        window.setTitle("BookStore App");
        window.show();        
                       


            }
        });
        
        
        
        

        //Delete Button
        Button pointsBuyButton = new Button();
                pointsBuyButton.setMinHeight(20);
        pointsBuyButton.setMaxHeight(50);
       pointsBuyButton.setMinWidth(80);
        pointsBuyButton.setMaxWidth(100);
        pointsBuyButton.setText("Delete");
        pointsBuyButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               ObservableList<Book> bookselected, allbooks;
        allbooks = OwnerTable.getItems();
        bookselected = OwnerTable.getSelectionModel().getSelectedItems();

        bookselected.forEach(allbooks::remove);
            }
        });
  
        
         aa.getChildren().addAll(pointsBuyButton, BackButton);
       aa.setSpacing(75);
        aa.setAlignment(Pos.CENTER);
        
      GridPane.setConstraints(aa, 8, 8);
        OwnerBookScreenGrid.getChildren().add(aa);
 
           Label usernameLabel = new Label ("Name:");
  usernameLabel.setMinHeight(20);
  usernameLabel.setMaxHeight(50);
  usernameLabel.setMinWidth(80);
  usernameLabel.setMaxWidth(100);
    
        
                final TextField usernameBox = new TextField();
        usernameBox.setPrefColumnCount(15);
        usernameBox.getText();
                 usernameBox.setMinHeight(20);
  usernameBox.setMaxHeight(50);
  usernameBox.setMinWidth(100);
 usernameBox.setMaxWidth(120);
        
      //  PasswordLabel
        Label passwordLabel = new Label ("Price: ");
      passwordLabel.setMinHeight(20);
  passwordLabel.setMaxHeight(50);
  passwordLabel.setMinWidth(80);
 passwordLabel.setMaxWidth(100);

                 final TextField usenameBox = new TextField();
        usenameBox.setPrefColumnCount(15);
        usenameBox.getText();
                 usenameBox.setMinHeight(20);
  usenameBox.setMaxHeight(50);
  usenameBox.setMinWidth(100);
 usenameBox.setMaxWidth(120);
   hb.getChildren().addAll(usernameLabel, usernameBox,passwordLabel,usenameBox);
       hb.setSpacing(4);
        hb.setAlignment(Pos.CENTER);
        
      GridPane.setConstraints(hb, 8, 6);
        OwnerBookScreenGrid.getChildren().add(hb);

        //Logout Button
        
        Button logoutButton = new Button();
        logoutButton.setText("Add");
        logoutButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.out.println("Add");
                //logout and send to LoginScreen
                   Book book = new Book();
        book.setBookName(usernameBox.getText());
        book.setBookPrice(Double.parseDouble(usenameBox.getText()));
        OwnerTable.getItems().add(book);
        usernameBox.clear();
        usenameBox.clear();
     
    
            }
        });
               GridPane.setConstraints( logoutButton,10, 6);
        OwnerBookScreenGrid.getChildren().add(logoutButton);
        

        //Setting the scene
        Scene scene = new Scene(OwnerBookScreenGrid, 700, 600);
        
        //State Information
        primaryStage.setTitle("Bookstore App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    


    public static void main(String[] args) {
        launch(args);
    }
    
    //TEMPORARY BOOK OBJECT
    
    public static class Book{
        
        private String BookName;
        private double BookPrice;
           
        public Book(){
        this.BookName = "";

    }

        public Book(String BookName, Double BookPrice) {
            this.BookName = BookName;
            this.BookPrice = BookPrice;

        }

        public String getBookName() {
            return BookName;
        }

        public void setBookName(String BookName) {
            this.BookName = BookName;
        }

        public Double getBookPrice() {
            return BookPrice;
  
        }

        public void setBookPrice(Double BookPrice) {
            this.BookPrice = BookPrice;
        }
    }
}