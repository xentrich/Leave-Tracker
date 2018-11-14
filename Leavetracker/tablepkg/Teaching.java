/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepkg;

import datahandle.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shiro
 */
public class Teaching {
    
    private int id;
    private String f_name;
    private String g_name;
    private String mi;
    private String position;
    private String status;
    private String college;
    private Date date_employment;
    private int vl;
    private int sil;
    private Database db;

    Teaching(int Id, String F_name,String G_name,String Mi, String Position, String Status, 
                                            String College,Date Date_employment,int Vl,int Sil) {
        this.id =Id;
        this.f_name =F_name;
        this.g_name =G_name;
        this.mi = Mi;
        this.position = Position;
        this.status = Status;
        this.college = College;
        this.date_employment = Date_employment;
        this.vl = Vl;
        this.sil = Sil;
        
        
    }
    
    public ArrayList<Teaching> getUsersList()
   {
        ArrayList<Teaching> teachinglist = new ArrayList<Teaching>();
 
            String query = "SELECT * FROM teachingdata_table";
       try {
            db = new Database();
            
        
            Statement stmt = db.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
    
           Teaching teaching;
           while(rs.next())
           {
               teaching = new Teaching(rs.getInt("id"),rs.getString("f_name"),rs.getString("g_name"),rs.getString("mi"),rs.getString("position"),
               rs.getString("status"),rs.getString("college"),rs.getDate("date_employment"),rs.getInt("vl"),rs.getInt("sil"));
               teachinglist.add(teaching);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return teachinglist;
   }
   /*
    String f_name,String g_name,String mi, String position,String status,String college,Date date_employment,int vl,int sil,
    */
}
