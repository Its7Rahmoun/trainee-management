/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

/**
 *
 * @author User
 */
public class stage {
    private int id;
    private String title;
    private String sujet;
    private String duree;
    private int id_responsable_satge;

    public stage(int id, String title, String sujet, String duree,  int id_responsable_satge) {
        this.id = id;
        this.title = title;
        this.sujet = sujet;
        this.duree = duree;
        this.id_responsable_satge = id_responsable_satge;
    }
        public stage(String title) {
        this.title = title;
    }
    
        public stage( String title, String sujet, String duree,  int id_responsable_satge) {

        this.title = title;
        this.sujet = sujet;
        this.duree = duree;
        this.id_responsable_satge = id_responsable_satge;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }



    public int getId_responsable_satge() {
        return id_responsable_satge;
    }

    public void setId_responsable_satge(int id_responsable_satge) {
        this.id_responsable_satge = id_responsable_satge;
    }
    
    
    
}
