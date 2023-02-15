
package booklist.booksDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConn {
    
    public static final String url = "jdbc:mysql://localhost:3306/db_booklist";
    public static final String user = "pma";
    public static final String password = "pma74";
    
    
    Connection conn = null;
    
    public DBConn(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connected!");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
       
    }
    
    public int executeSQLSentence(String strSQLSentence){
        
        try{
            PreparedStatement pstm = conn.prepareStatement(strSQLSentence);
            pstm.execute();
            return 1;
        }catch(SQLException e){
            System.out.print(e);
            return 0;
        }
        
    }
    
    
    public ResultSet showResults(String strSQLSentence){
         
        try{
            PreparedStatement pstm = conn.prepareStatement(strSQLSentence);
            ResultSet result = pstm.executeQuery();
            return result;
        }catch(SQLException e){
            System.out.print(e);
            return null;
        }
        
    }
    


    
 
}
