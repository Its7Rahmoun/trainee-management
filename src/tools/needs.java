/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class needs {
    
                            public static  String myfunction(ArrayList<Integer> a ){
                    
                    String r ="(";
                    int k=0;
                    for(int i=0 ;i<a.size();i++){
                        if(k+1<a.size()){
                                            r=r+a.get(i)+",";
                                            k++;

                        }
                        else
                                               r=r+a.get(i);
 
                    
                    }
            
                return r+")";
            }
    
}
