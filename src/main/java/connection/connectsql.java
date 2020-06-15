package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectsql {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dev_SRD;user=sa;password=Admin2020");
            System.out.println("connected.");
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("connect fail.");
        }
        return con;
    }
}
