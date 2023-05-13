/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

/**
 *
 * @author User
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class operation {
    
    public static void execute_date(String query,String msg){
    
        try{
        Connection cnx = connection_date.getcon();
        Statement stm = cnx.createStatement(); 
        stm.executeUpdate(query);
        if(!msg.equals("")){
        JOptionPane.showMessageDialog(null,msg);
        }
        
        
        }
        catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    public static ResultSet getdate(String query ){
    try{
    Connection cnx = connection_date.getcon();
    Statement st = cnx.createStatement();
    ResultSet rs = st.executeQuery(query); 
    return rs;
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
    }
    
    
        public static void prepare(String query , FileInputStream in ){
    
        try{
        Connection cnx = connection_date.getcon();
        PreparedStatement ps =  cnx.prepareStatement(query);

        ps.setBinaryStream(1, in,in.available());
         ps.executeUpdate();
         cnx.close();
        
        
        }
        catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
        } catch (IOException ex) {
            Logger.getLogger(operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
        

    
}
