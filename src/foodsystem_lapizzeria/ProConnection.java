package foodsystem_lapizzeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ak2049l
 */
public class ProConnection {
   Connection conn;
   ResultSet res;
  // prepareStatement pst;
   
   public static void main(String args[]) {
       ProConnection.ConnectDB();
   }
   
    public static Connection ConnectDB(){
     
        try{ //org.apache.derby.jdbc.ClientDriver
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/FoodSystem_Lapizzeria","root","root");
            return conn;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
        
    }
    
}
