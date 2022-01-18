package bookstore.app;
import java.util.ArrayList;

public class PointPurchase extends Purchase{
    private Customer c;
    private Inventory inv;
    private String status;
    private double points;
    private double price;
    private ArrayList<Book> ShoppingCart;
    
    PointPurchase(Customer c){
        this.c = c;
        this.inv = Inventory.getInstance();
    }
    
    @Override
    public double ChargeCustomer(){
        ShoppingCart = c.getShoppingCart();
        points = c.getPoints();
        
        for(Book cust: ShoppingCart){
            price = price + cust.getPrice();
        }
        
        double newprice = price - (points/100);
        if(newprice < 0){
            newprice = 0;
            
        }
        UpdatePoints();
        UpdateStatus();
        UpdateInventory();
        UpdateCart();
        return newprice;
    }
   
    @Override
    public void UpdatePoints() {
        points = c.getPoints();
        
        points = points - (100*price);
        if(points < 0){
            points = 0;
        }
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
