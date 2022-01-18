package bookstore.app;
import java.util.ArrayList;
public class Customer extends User
{
    private int Points;
    private String Status;
    private ArrayList<Book> ShoppingCart;
    Purchase PurchaseType;
    public Customer(String username, String password)
    {
        super(username, password);
        Points = 0;
        Status = "Silver";
        ShoppingCart = new ArrayList<Book>();
    }
    public String getUsername(){
        return super.getUsername();
    }
    public String getPassword(){
        return super.getPassword();
    }
    public void setPoints(int p){
        this.Points = p;
    }
    public int getPoints()
    {
        return Points;
    }
    public void setStatus(String s){
        this.Status = s;
    }
    public String getStatus()
    {
        return Status;
    }
    public void setPurchaseType(String type)
    {
        if(type.equals("cash")){
            PurchaseType = new CashPurchase(this);
        }
        if(type.equals("point")){
            PurchaseType = new PointPurchase(this);
        }
    }
    public Purchase getPurchase()
    {
        return PurchaseType;
    }
    public ArrayList<Book> getShoppingCart()
    {
        ArrayList<Book> tempCart = new ArrayList<Book>();
        for(int i = 0; i < ShoppingCart.size(); i++){
            tempCart.add(ShoppingCart.get(i));
        }
        return tempCart;
    }
    public void AddtoCart(Book b)
    {
        ShoppingCart.add(b);
    }
    public void RemovefromCart(Book b){
        for(int i = 0; i<ShoppingCart.size(); i++){
            if(ShoppingCart.get(i).getName().equals(b.getName())){
                ShoppingCart.remove(i);
            }
        }
    }
    public static void main(String[] args)
    {
        Customer c = new Customer("hi", "hi");
        c.AddtoCart(new Book("title", 6.0));
        System.out.println(c.getShoppingCart().get(0).getName());
        c.RemovefromCart(new Book("title", 6.0));
        System.out.println(c.getShoppingCart());
    }
}
