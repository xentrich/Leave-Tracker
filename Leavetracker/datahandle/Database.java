/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datahandle;

/**
 *
 * @author Shiro
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Objects.isNull;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Database {
     public Connection conn;
    //public Statement stmt;
    //public ResultSet rs;
    
    public Database(){
        try {
            String url = "jdbc:mysql://localhost:3306/cd_hrsample";
            String username = "root";
            String password = "";
            conn = (Connection) DriverManager.getConnection(url, username, password);
            
//            dataSource = new MysqlDataSource();
//            dataSource.setServerName("localhost");
//            dataSource.setPortNumber(3306);
//            dataSource.setDatabaseName("cdu_fos");
//            dataSource.setUser("root");
//            dataSource.setPassword("");
//            
//            conn = (Connection) dataSource.getConnection();
//            stmt = (Statement) conn.createStatement();
            
//        if(conn.isValid(0)){
//            System.out.println("Connected");
//        }else{
//            System.out.println("Dead");
//        }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);

            JOptionPane.showMessageDialog(null, "SQLState: " + ((SQLException)ex).getSQLState()+ "\nError Code: " 
                    + ((SQLException)ex).getErrorCode() + "\nMessage: " + ex.getMessage());
        }

    }
    
    public Statement newStatement(){
        Statement stmt = null;
        try {
             stmt = (Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);

            JOptionPane.showMessageDialog(null, "SQLState: " + ((SQLException)ex).getSQLState()+ "\nError Code: " 
                    + ((SQLException)ex).getErrorCode() + "\nMessage: " + ex.getMessage());
        }
        
        return stmt;
    }
    
//    public void query(String query){
//        try {      
//            rs = stmt.executeQuery(query);
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace(System.err);
//
//            JOptionPane.showMessageDialog(null, "SQLState: " + ((SQLException)ex).getSQLState()+ "\nError Code: " 
//                    + ((SQLException)ex).getErrorCode() + "\nMessage: " + ex.getMessage());
//        }
//    }
    
    public int getCount(String query){
        return 1;
    }
    
    public void closeConn(){
        try {
            if(!isNull(conn))
                conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.err);

            JOptionPane.showMessageDialog(null, "SQLState: " + ((SQLException)ex).getSQLState()+ "\nError Code: " 
                    + ((SQLException)ex).getErrorCode() + "\nMessage: " + ex.getMessage());
        }
    }  

    
    
}
