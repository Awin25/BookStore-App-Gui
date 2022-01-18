package bookstore.app;
public class User
{
    private String username;
    private String password;
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    protected String getUsername()
    {
        return username;
    }
    protected String getPassword()
    {
        return password;
    }
}
