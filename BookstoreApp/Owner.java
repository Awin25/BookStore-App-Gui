package bookstore.app;
public class Owner extends User
{
    private static Owner instance;
    
    public Owner()
    {
        super("admin", "admin");
    }

    public static Owner getInstance()
    {
        if(instance == null){
            instance = new Owner();
        }
        return instance;
    }
}
