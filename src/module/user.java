/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

/**
 *
 * @author User
 */
public class user extends person {
    private String password;
    private int id;

    public user(String password, int id, String nom, String prenom, String email, String mobile, String add) {
        super(id, nom, prenom, email, mobile, add);
        this.password = password;
        this.id=id;
    }
        public user(String password, int id, person p) {
        super(p.getId(), p.getNom(), p.getPrenom(), p.getEmail(), p.getMobile(), p.getAddress());
        this.password = password;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
