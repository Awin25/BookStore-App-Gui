package bookstore.app;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
public class LoginSystem
{
    public static void readInfo()
    {
        Customers tempCustomers = Customers.getInstance();
        ArrayList<Customer> tempc = tempCustomers.getCustomers();
        
        Inventory inv = Inventory.getInstance();
        ArrayList<Book> tempb = inv.getBooks();
        try{
            BufferedReader customerReader = new BufferedReader(new FileReader("customers.txt"));
            String str;
            int i = 0;
            while((str = customerReader.readLine())!=null){
                String[] temp = str.split(",");
                if((temp[0] != null) && (temp[1] != null) && (temp[2] != null)){
                    tempCustomers.addCustomer(temp[0], temp[1]);
                    tempCustomers.getCustomers().get(i).setPoints(Integer.parseInt(temp[2]));
                    i++;
                }
            }
            
            BufferedReader bookReader = new BufferedReader(new FileReader("books.txt"));
            while((str = bookReader.readLine())!=null){
                String[] temp = str.split(",");
                if((temp[0] != null) && (temp[1] != null)){
                    inv.addBook(temp[0], Double.parseDouble(temp[1]));
                }
            }
           
            
            
            customerReader.close();
            bookReader.close();
        }
        catch(IOException e){};
    }
    
    public static User Login(String usernameAttempt, String passwordAttempt)
    {
        Customers tempCustomers = Customers.getInstance();
        if(usernameAttempt.equals("admin") && passwordAttempt.equals("admin")){
            return Owner.getInstance();
        }
        for(int i = 0; i<tempCustomers.getCustomers().size(); i++){
            if(tempCustomers.getCustomers().get(i).getUsername().equals(usernameAttempt)){
                if(tempCustomers.getCustomers().get(i).getPassword().equals(passwordAttempt)){
                    return tempCustomers.getCustomers().get(i);
                }
            }
        }
        return null;
    }
    public static void Exit()
    {
        Customers tempCustomers = Customers.getInstance();
        ArrayList<Customer> tempc = tempCustomers.getCustomers();
        
        Inventory inv = Inventory.getInstance();
        ArrayList<Book> tempb = inv.getBooks();
        
        try{
            BufferedWriter customerWriter = new BufferedWriter(new FileWriter("customers.txt"));
            for(int i = 0; i < tempc.size(); i++){
                Customer c = tempc.get(i);
                customerWriter.write(c.getUsername() + "," + c.getPassword() + "," + c.getPoints()+"\n");
            }
            
            BufferedWriter bookWriter = new BufferedWriter(new FileWriter("books.txt"));
            for(int i = 0; i < tempb.size(); i++){
                Book b = tempb.get(i);
                bookWriter.write(b.getName() + "," + b.getPrice() + "\n");
            }
            
            customerWriter.close();
            bookWriter.close();
        }
        catch(IOException e){};
        
        
    }
}
