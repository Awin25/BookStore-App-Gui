package bookstore.app;
import java.util.ArrayList;

public class CashPurchase extends Purchase{
    private Customer c;
    private Inventory inv;
    private String status;
    private double points;
    private double price;
    private ArrayList<Book> ShoppingCart;
    
    CashPurchase(Customer c){
        this.c = c;
        this.inv = Inventory.getInstance();
    }
    
    @Override
    public double ChargeCustomer() {
        ShoppingCart = c.getShoppingCart();
        
        for(Book cust: c.getShoppingCart()){
            price = price + cust.getPrice();
        }
        UpdatePoints();
        UpdateStatus();
        UpdateInventory();
        UpdateCart();
        return price;
    }
    
    @Override
    public void UpdatePoints() {
        points = c.getPoints();
        
        points = points + ((int)price*10);
        c.setPoints((int)points);
    }

    @Override
    public void UpdateStatus() {
        points = c.getPoints();

        if(points < 1000){
            status = "S";
            c.setStatus(status);
        }
        else{
            status = "G";
            c.setStatus(status);
        }
    }

    @Override
    public void UpdateInventory() {
        ShoppingCart = c.getShoppingCart();
        
        for(Book cust: ShoppingCart){
            inv.deleteBook(cust);
        }
    }

    @Override
    public void UpdateCart() {
        ShoppingCart = c.getShoppingCart();
        
        for(Book cust: ShoppingCart){
            c.RemovefromCart(cust);
        }
    }
}
