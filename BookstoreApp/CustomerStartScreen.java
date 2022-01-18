package bookstore.app;

import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.application.*;
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


public class CustomerStartScreen extends Application {
    
    //creating book table object
    private TableView<Book> CustomerBookTable = new TableView<Book>();
    private final ObservableList<Book> data =
            //get book data here
            FXCollections.observableArrayList(
                    //sample books
            new Book("The Hobbit", "25.00"),
            new Book("Harry Potter and the Philosopher's Stone", "36.00"),
            new Book("The Da Vinci Code", "17.00"),
            new Book("Fifty Shades of Grey", "45.00"),
            new Book("Brave New World", "16.00"));
    
    final HBox bb = new HBox();//h box for buttons
    
    @Override
    public void start(Stage primaryStage) {
        //Creating GridPane
        GridPane CustomerStartScreenGrid = new GridPane();
        CustomerStartScreenGrid.setPadding(new Insets(10,10,10,10));
        CustomerStartScreenGrid.setVgap(10);
        CustomerStartScreenGrid.setHgap(10);
        
        //setting tabel to editable for the checkboxes
        //I would like tro figure out how to make only one
        //section editable though, because you can edit the 
        //whole table with this set to true.
        CustomerBookTable.setEditable(true);
        
        //Book Name Column
        TableColumn CustomerBookNameCol = new TableColumn("Book Name");
        CustomerBookNameCol.setMinWidth(250);
        CustomerBookNameCol.setCellValueFactory(
            new PropertyValueFactory<Book, String>("bookName"));
        CustomerBookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //Book Price Column
        TableColumn CustomerBookPriceCol = new TableColumn("Book Price");
        CustomerBookPriceCol.setMinWidth(50);
        
        CustomerBookPriceCol.setCellValueFactory(
            new PropertyValueFactory<Book, String>("bookPrice"));
        
            //centering
        CustomerBookPriceCol.setCellFactory(new Callback<TableColumn<Book, String>, TableCell<Book, String>>(){
            public TableCell<Book, String> call(TableColumn<Book, String> p) {
                TextFieldTableCell<Book, String> cell = new TextFieldTableCell<Book, String>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        
        //Select Column
        TableColumn<Book, Boolean> SelectCol = new TableColumn<Book, Boolean>("Select");
        SelectCol.setMinWidth(25);
        
        //Setting the value of the book from false to true if selected
        SelectCol.setCellValueFactory(new Callback<CellDataFeatures<Book, Boolean>, ObservableValue<Boolean>>(){
 
            public ObservableValue<Boolean> call(CellDataFeatures<Book, Boolean> param) {
                Book book = param.getValue();
 
                SimpleBooleanProperty booleanProp = 
                        new SimpleBooleanProperty(book.isBookState());
                booleanProp.addListener(new ChangeListener<Boolean>(){
 
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                            Boolean newValue) {
                        book.setBookState(newValue);
                    }
                });
                return booleanProp;
            }
        });
        //centering
        SelectCol.setCellFactory(new Callback<TableColumn<Book, Boolean>, TableCell<Book, Boolean>>(){
            public TableCell<Book, Boolean> call(TableColumn<Book, Boolean> p) {
                CheckBoxTableCell<Book, Boolean> cell = new CheckBoxTableCell<Book, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });    
        
        //setting up the table
        CustomerBookTable.setItems(data);    
        CustomerBookTable.getColumns().addAll(CustomerBookNameCol, CustomerBookPriceCol, SelectCol);
        CustomerBookTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        GridPane.setConstraints(CustomerBookTable, 8, 1);
        CustomerStartScreenGrid.getChildren().add(CustomerBookTable);
        
        //WelcomeLabel
        Label CustomerWelcomeLabel = new Label ("Welcome {USER}. You have {POINTS} points. Your status is {STATUS}.");
        //Get CustomerName, CustomerPoints, and CustomerStatus
        GridPane.setConstraints(CustomerWelcomeLabel, 8, 0);
        CustomerStartScreenGrid.getChildren().add(CustomerWelcomeLabel);   
        GridPane.setHalignment(CustomerWelcomeLabel, HPos.CENTER);
        
        //Buy Button
        Button buyButton = new Button();
        buyButton.setText("Buy");
        buyButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.out.println("Buying Book");
                //calulate total cost and send to CustomerCostScreen
            }
        });
        
        //Buy with Points Button
        Button pointsBuyButton = new Button();
        pointsBuyButton.setText("Redeem points & buy");
        pointsBuyButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.out.println("Buying Book with Points");
                //calulate total cost (0) deduct points and send to CustomerCostScreen
            }
        });
        
        //Logout Button
        Button CustomerlogoutButton = new Button();
        CustomerlogoutButton.setText("Logout");
        CustomerlogoutButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.out.println("Logging Out");
                //logout and send to LoginScreen
            }
        });
        
        //setting the hbox
        bb.getChildren().addAll(buyButton, pointsBuyButton, CustomerlogoutButton);
        bb.setSpacing(20);
        bb.setAlignment(Pos.CENTER);
        
        GridPane.setConstraints(bb, 8, 2);
        CustomerStartScreenGrid.getChildren().add(bb);
                  
        //Setting the scene
        Scene scene = new Scene(CustomerStartScreenGrid, 600, 300);
        
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
        private String BookPrice;
        private boolean BookState;

        public Book(String BookName, String BookPrice) {
            this.BookName = BookName;
            this.BookPrice = BookPrice;
            this.BookState = false;
        }

        public String getBookName() {
            return BookName;
        }

        public void setBookName(String BookName) {
            this.BookName = BookName;
        }

        public String getBookPrice() {
            return BookPrice;
        }

        public void setBookPrice(String BookPrice) {
            this.BookPrice = BookPrice;
        }

        public boolean isBookState() {
            return BookState;
        }

        public void setBookState(boolean BookState) {
            this.BookState = BookState;
        }
                
    }
    
}
