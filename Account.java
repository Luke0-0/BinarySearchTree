import java.util.ArrayList;
import java.util.List;

public class Account implements Comparable <Account> {
    String name;
    String desc;
    List<Post> posts = new ArrayList<>();
    // list of posts

    public Account (String n, String d) {
        name = n;
        desc = d;
    }

    public int compareTo(Account a) {
        return name.compareTo (a.name);
    }
    
    public String toString() {
        return name + ' ' + desc;
    }
}
