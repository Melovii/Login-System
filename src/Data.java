import java.util.HashMap;

// note: x.containsKey("username") if false then there's no key and you must ask for password!
// note: x.containsValue(password) if false then there's no value and you must ask for username!
// if username already exists and you do .put it'll update the key!
// .put, .get, .replace, .putIfAbsent, .remove

public class Data
{
    HashMap<String, String> userData = new HashMap<>();

    public void Data()
    {
        // check parameter to save data here?
    }

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
