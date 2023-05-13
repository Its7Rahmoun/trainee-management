/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.text.Document;

/**
 *
 * @author User
 */
public class candidat extends person {
    private boolean etat;
    private String datedubet;
    private OutputStream cv;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private ArrayList<stage> stages_postuler ;

    public ArrayList<stage> getStages_postuler() {
        return stages_postuler;
    }

    public void setStages_postuler(ArrayList<stage> stages_postuler) {
        this.stages_postuler = stages_postuler;
    }

    public candidat(boolean etat, String datedubet, OutputStream cv,int id , int id_person, String nom, String prenom, String email, String mobile, String add) {
        super(id_person, nom, prenom, email, mobile, add);
        this.etat = etat;
        this.datedubet = datedubet;
        this.cv = cv;
        this.id=id;
    }

    public candidat(int id, int id_person, String nom, String prenom) {
        super(id_person, nom, prenom);
        this.id = id;
    }

 

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getDatedubet() {
        return datedubet;
    }

    public void setDatedubet(String datedubet) {
        this.datedubet = datedubet;
    }

    public OutputStream getCv() {
        return cv;
    }

    public void setCv(OutputStream cv) {
        this.cv = cv;
    }


    
}
