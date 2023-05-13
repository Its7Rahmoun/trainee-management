/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class responsable_stage extends user {
    
    private String departement;
    private ArrayList<stage> stages_proposer;
    private int id;

    public responsable_stage(String departement, String password, int id, String nom, String prenom, String email, String mobile, String add) {
        super(password, id, nom, prenom, email, mobile, add);
        this.departement = departement;
        this.id=id;
    }
        public responsable_stage(String departement, int id , user u) {
        super(u.getPassword(), u.getId(), u.getNom(), u.getPrenom(), u.getEmail(), u.getMobile(), u.getAddress());
        this.departement = departement;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

 
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public ArrayList<stage> getStages_proposer() {
        return stages_proposer;
    }

    public void setStages_proposer(ArrayList<stage> stages_proposer) {
        this.stages_proposer = stages_proposer;
    }
    
    
    
}
