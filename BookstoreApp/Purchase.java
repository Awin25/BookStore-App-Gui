package bookstore.app;
public abstract class Purchase {
    public abstract void UpdatePoints();
    public abstract void UpdateStatus();
    public abstract void UpdateInventory();
    public abstract void UpdateCart();
    public double ChargeCustomer(){return 0;}
}
