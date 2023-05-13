/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import module.hierarchy;
import module.person;
import module.responsable_stage;


/**
 *
 * @author User
 */
public class user_date_acces {
      
    
    public static person logIn(String mail,String password){
        final String query="select * from person where email='"+mail+"'";
        try{
                ResultSet rs=operation.getdate(query);
                if(rs.next()){
                  
                  try{
                      final String query1 ="select * from user where password='"+password+"'";
                      ResultSet rs1 = operation.getdate(query1);
                      if(rs1.next()){
                      final String query2 = "select * from hierarchy where id_user='"+rs1.getInt("id")+"'";
                      final String query3="select * from stagechief where id_user='"+rs1.getInt("id")+"'";
                      ResultSet rs2 = operation.getdate(query2);
                      ResultSet rs3=operation.getdate(query3);
                      if(rs2.next()){
                       hierarchy h = new hierarchy(rs1.getString("password"),rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("mobile"),rs.getString("address")) ;  
                      return h;
                      }
                      if (rs3.next()){
                        responsable_stage rstage= new responsable_stage(rs3.getString("dept"),rs1.getString("password"),rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("mobile"),rs.getString("address"));
                        return rstage;
                      }
                      
                      }
                      else{
                       JOptionPane.showMessageDialog(null,"Incorrect password or email");
                      }
                  }
                  catch(Exception e ){
                                   JOptionPane.showMessageDialog(null,e);
                  }
                  
                }
                else{
                 JOptionPane.showMessageDialog(null,"user doen't exist");
                }
        }
        catch(HeadlessException | SQLException e ){
        JOptionPane.showMessageDialog(null,e);
        }

    
        return null;
    
    } 
    
    public static String recoveryPass(String email){
        
        
                final String query="select * from person where email='"+email+"'";
        try{
                ResultSet rs=operation.getdate(query);
                if(rs.next()){
                  
                  try{
                      final String query1 ="select * from user where id_person='"+rs.getInt("id")+"'";
                      ResultSet rs1 = operation.getdate(query1);
                      if(rs1.next()){
                         return rs1.getString("password");
                      
                      }
                      else{
                       JOptionPane.showMessageDialog(null,"you are not a user system of the platform");
                      }
                  }
                  catch(HeadlessException | SQLException e ){
                                   JOptionPane.showMessageDialog(null,e);
                  }
                  
                }
                else{
                 JOptionPane.showMessageDialog(null,"user doen't exist");
                }
        }
        catch(HeadlessException | SQLException e ){
        JOptionPane.showMessageDialog(null,e);
        }
    return null;
    }

    
}
