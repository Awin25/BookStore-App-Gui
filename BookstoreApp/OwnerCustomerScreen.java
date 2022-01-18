/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

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


public class OwnerCustomerScreen extends Application {
    
    //creating user table object
    private TableView<User> table = new TableView<User>();
      Stage window;
    Scene scene1, scene2;
    private final ObservableList<User> data =
            //get user data here
            FXCollections.observableArrayList(
                    //sample users, passwords ,points get from.txt file
            new User("john", "admin",70.0),
            new User("b", "admin",1.0),
            new User("j", "jhbkjb",7.0),
            new User("Fi", "bbkj",5.0),
            new User("B", "nnklnlkn",4.0));
    
     HBox hb = new HBox();//h box for buttons
      HBox aa = new HBox();//h box for buttons
    
    @Override
    public void start(Stage primaryStage) {
        //Creating GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        //text can't be editable
        table.setEditable(false);
        
        //User Name Column
  
        TableColumn UserNameCol = new TableColumn("Username");
        UserNameCol.setMinWidth(200);
        UserNameCol.setCellValueFactory(
            new PropertyValueFactory<User, String>("userName"));
       UserNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //User Price Column
        TableColumn UserPriceCol = new TableColumn("Password");
        UserPriceCol.setMinWidth(200); 
       UserPriceCol.setCellValueFactory(
            new PropertyValueFactory<User, String>("password"));
       
       TableColumn PointsCol = new TableColumn("Points");
        PointsCol.setMinWidth(100);     
       PointsCol.setCellValueFactory(
           new PropertyValueFactory<User, Double>("points"));
             PointsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
            //centering
        UserPriceCol.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>(){
            public TableCell<User, String> call(TableColumn<User, String> p) {
             TextFieldTableCell<User, String> cell = new TextFieldTableCell<User, String>();
               cell.setAlignment(Pos.CENTER);
               return cell;
            }
       });
        


  
        
        //setting up the table
        table.setItems(data);    
        table.getColumns().addAll(UserNameCol, UserPriceCol,PointsCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        GridPane.setConstraints(table, 8, 1);
        grid.getChildren().add(table);
        
 
        
        
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
        grid.getChildren().add(button1);
        
                Button button2 = new Button("Customers");
        button2.setOnAction(e -> window.setScene(scene1));
                button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Customers");
                //send to customers page
            }
        });
          GridPane.setConstraints( button2,10, 6);
        grid.getChildren().add(button2);
        
                        Button button3 = new Button("Logout");
        button3.setOnAction(e -> window.setScene(scene1));
                button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logout.Done ");
                //send to logout page
            }
        });
          GridPane.setConstraints( button3,10, 6);
        grid.getChildren().add(button3);
        

      
        VBox grid1 = new VBox(20);
        grid1.getChildren().addAll(button1,button2,button3);
        grid1.setAlignment(Pos.CENTER);
 Scene scene1 = new Scene(grid1, 600, 350);
 
 window.setScene(scene1);
        window.setTitle("BookStore App");
        window.show();        
                       




            }
        });
        
        
        
        
        //Delete Button , sets up the button
        Button DeleteButton = new Button();
                DeleteButton.setMinHeight(20);
        DeleteButton.setMaxHeight(50);
       DeleteButton.setMinWidth(80);
        DeleteButton.setMaxWidth(100);
        DeleteButton.setText("Delete");
        DeleteButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
// delete button, action deletes the rows
            public void handle(ActionEvent event){
               ObservableList<User> userselected, allusers;
        allusers = table.getItems();
        userselected = table.getSelectionModel().getSelectedItems();

        userselected.forEach(allusers::remove);
            }
        });
    
         aa.getChildren().addAll(DeleteButton, BackButton);
       aa.setSpacing(75);
        aa.setAlignment(Pos.CENTER);
        
      GridPane.setConstraints(aa, 8, 8);
        grid.getChildren().add(aa);
 
        // creating label and textboxes
           Label usernameLabel = new Label ("Username:");
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
        Label passwordLabel = new Label ("Password: ");
      passwordLabel.setMinHeight(20);
  passwordLabel.setMaxHeight(50);
  passwordLabel.setMinWidth(80);
 passwordLabel.setMaxWidth(100);

                 final TextField PasswordBox = new TextField();
        PasswordBox.setPrefColumnCount(15);
        PasswordBox.getText();
                 PasswordBox.setMinHeight(20);
  PasswordBox.setMaxHeight(50);
  PasswordBox.setMinWidth(100);
 PasswordBox.setMaxWidth(120);
   hb.getChildren().addAll(usernameLabel, usernameBox,passwordLabel,PasswordBox);
       hb.setSpacing(4);
        hb.setAlignment(Pos.CENTER);
        
      GridPane.setConstraints(hb, 8, 6);
        grid.getChildren().add(hb);
 

      

        //Add Button
        
        Button AddButton = new Button();
        AddButton.setText("Add");
        AddButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
          
                public void handle(ActionEvent event){
                System.out.println("Add");
                //logout and send to LoginScreen
                   User user = new User();
        user.setUserName(usernameBox.getText());
        user.setPassword(PasswordBox.getText());
        table.getItems().add(user);
        usernameBox.clear();
        PasswordBox.clear();
            }
        });
               GridPane.setConstraints( AddButton,10, 6);
        grid.getChildren().add(AddButton);
      
        //Setting the scene
        Scene scene = new Scene(grid, 700, 600);
        
        //State Information
        primaryStage.setTitle("Bookstore App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //TEMPORARY USER OBJECT
    
        public static class User{
        
        private String UserName;
        private String Password;
        private double BookPoints;
           
        public User(){
        this.UserName = "";
        this.Password = "";
        this.BookPoints = 0.00;

    }

        public User(String UserName, String Password,Double BookPoints) {
            this.UserName = UserName;
            this.Password = Password;
            this.BookPoints = BookPoints; 
      
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getPassword() {
            return Password;
            
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }
        
          public Double getBookPoints() {
            return BookPoints;
            
        }

        public void setBookPoints(Double BookPoints) {
            this.BookPoints = BookPoints;
        }         
    }
}