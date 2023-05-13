/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class openFile {
    public static void open(String path){
try{
    System.out.println(path);
if(new File(path).exists())
{
Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+path);
}
else{
  JOptionPane.showMessageDialog(null,"file dosn't exist !!!");
}
    
    }
catch(IOException e){
  JOptionPane.showMessageDialog(null,e);
}

} 
    
}
