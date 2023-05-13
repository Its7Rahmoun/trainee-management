/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class inputstreamtofile {

    public static OutputStream input_to_file(InputStream in, String pathh) {
        String path = pathh;
        File file = new File(path);
        if (!file.exists()) {
            try (
                     InputStream inputStream = in; 
                    OutputStream outputStream = new FileOutputStream(file)) {
                int length;
                byte[] bytes = new byte[10024];
                // copy data from input stream to output stream
                while ((length = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }
                return  outputStream;

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else
        {
         //JOptionPane.showMessageDialog(null, "file already exist");
                 return null;
        }    
   return null;
    }

}
