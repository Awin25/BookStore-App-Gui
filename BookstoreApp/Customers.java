package bookstore.app;
import java.util.ArrayList;
public class Customers
{
    private ArrayList<Customer> CustomerList;
    private static Customers instance;
    
    private Customers()
    {
        CustomerList = new ArrayList<Customer>();
    }

    public static Customers getInstance()
    {
        if(instance == null){
            instance = new Customers();
        }
        return instance;
    }
    public ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> tempCust = new ArrayList<Customer>();
        for(int i = 0; i < CustomerList.size(); i++){
            tempCust.add(CustomerList.get(i));
        }
        return tempCust;
    }
    public void addCustomer(String username, String password)
    {
        CustomerList.add(new Customer(username, password));
    }
    public void deleteCustomer(Customer c)
    {
        for(int i = 0; i < CustomerList.size(); i++){
              if(CustomerList.get(i).getUsername().equals(c.getUsername())){
                  CustomerList.remove(i);
                }
            }
    }
    
}
