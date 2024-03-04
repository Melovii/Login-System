import java.util.HashMap;

public class Data
{
    HashMap<String, String> userData = new HashMap<>();

    public void save(String username, String password)
    {
        userData.put(username, password);
    }

    public String getKey(String username)
    {
        String key = userData.get(username);
        return key;
    }

    public void display()
    {
        System.out.println(userData);
    }
}
