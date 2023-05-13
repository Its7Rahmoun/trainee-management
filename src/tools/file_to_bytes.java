/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author User
 */
public class file_to_bytes {
    
    
            public static FileInputStream file_to_byte(File file)
        throws IOException
    {

        FileInputStream fl = new FileInputStream(file);
        return fl;
    }
    
}
