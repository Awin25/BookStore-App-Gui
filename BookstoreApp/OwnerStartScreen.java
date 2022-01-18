package bookstore.app;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class OwnerStartScreen extends Application {      
    
    @Override
    public void start(Stage primaryStage) {
       
        
        //Creating GridPane
        GridPane OwnerStartScreenGrid = new GridPane();
        OwnerStartScreenGrid.setPadding(new Insets(10,10,10,10));
        OwnerStartScreenGrid.setVgap(10);
        OwnerStartScreenGrid.setHgap(10);        
        
        //Books Button
        Button booksButton = new Button();
        booksButton.setText("Books");
        booksButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sending to Books Page");
            }
        });
        GridPane.setConstraints(booksButton, 26, 9);
        GridPane.setHalignment(booksButton, HPos.CENTER);
        
        //Customers Button
        Button customersButton = new Button();
        customersButton.setText("Customers");
        customersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sending to Customers Page");
                //send to OwnersCustomerScreen
            }
        });
        GridPane.setConstraints(customersButton, 26, 11);
        GridPane.setHalignment(customersButton, HPos.CENTER);
        
        //Logout Button
        Button logoutButton = new Button();
        logoutButton.setText("Logout");
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logging Out");
                //logout and send to LoginScreen
            }
        });
        GridPane.setConstraints(logoutButton, 26, 13);
        GridPane.setHalignment(logoutButton, HPos.CENTER);
        
        OwnerStartScreenGrid.getChildren().addAll(logoutButton, customersButton, booksButton);
                     
        //Setting the scene
        Scene scene = new Scene(OwnerStartScreenGrid, 600, 300);
        
        //State Information
        primaryStage.setTitle("Bookstore App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
