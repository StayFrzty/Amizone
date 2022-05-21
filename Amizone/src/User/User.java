
package User;


public class User {
    String name;
    String pass;
    
    public User(String n,String p){
        name = n;
        pass = p;
    }
    
    public String GetName(){
        return name;
    }
    
    public String GetPass(){
        return pass;
    }
}
