/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

import java.io.File;

/**
 *
 * @author User
 */
public class convantion {
    
    private int id;
    private String dateenvoie;
    private File cv;
    private int id_candidat;

    public convantion(int id, String dateenvoie, File cv, int id_candidat) {
        this.id = id;
        this.dateenvoie = dateenvoie;
        this.cv = cv;
        this.id_candidat = id_candidat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateenvoie() {
        return dateenvoie;
    }

    public void setDateenvoie(String dateenvoie) {
        this.dateenvoie = dateenvoie;
    }

    public File getCv() {
        return cv;
    }

    public void setCv(File cv) {
        this.cv = cv;
    }

    public int getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }
    
    
    
    
}
