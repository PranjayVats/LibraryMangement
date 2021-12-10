import java.sql.*;
import java.sql.DriverManager;

public class connect {
    Connection c;
    Statement s;
    public connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?"+"user=root&password=root");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        
        new connect();
    }
}
