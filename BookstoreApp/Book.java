package bookstore.app;
public class Book
{
    private String Name;
    private double Price;
    private boolean Selected;

    /**
     * Constructor for objects of class Book
     */
    public Book(String Name, double Price)
    {
        this.Name = Name;
        this.Price = Price;
        this.Selected = false;
    }
    public String getName()
    {
        return Name;
    }
    public double getPrice()
    {
        return Price;
    }
    public boolean isBookSelected() {
        return Selected;
    }
    public void setBookSelected(boolean Selected) {
        this.Selected = Selected;
    }
}
