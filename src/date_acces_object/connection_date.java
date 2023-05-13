/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class connection_date {
    public static Connection getcon(){

    try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            Connection cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Gestion_stagaires","root","");
            return cnx;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"no connection to server0");
            System.out.println(e);
            return null;
        }      
        
    }
    catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null,"no connection to server1");
                      return null;
    }
    
       
    }
}
