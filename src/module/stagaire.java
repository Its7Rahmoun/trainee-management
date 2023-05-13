/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

import java.io.OutputStream;

/**
 *
 * @author User
 */
public class stagaire extends candidat {
    private int id;
    private String  datedepart;
    private String datefin;
    private int cnj ;
    private convantion cnv;
    private stage s;

    public stagaire(int id, String datedepart, String datefin, int cnj, boolean etat, String datedubet, OutputStream cv, int id_candidat, int id_person, String nom, String prenom, String email, String mobile, String add) {
        super(etat, datedubet, cv, id_candidat, id_person, nom, prenom, email, mobile, add);
        this.id = id;
        this.datedepart = datedepart;
        this.datefin = datefin;
        this.cnj = cnj;
    }

    public stagaire(int id,int id_candidat, int id_person, String nom, String prenom,stage s) {
        super( id_candidat, id_person, nom, prenom);
        this.id = id;
        this.s=s;
    }

    public stage getS() {
        return s;
    }

    public void setS(stage s) {
        this.s = s;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(String datedepart) {
        this.datedepart = datedepart;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public int getCnj() {
        return cnj;
    }

    public void setCnj(int cnj) {
        this.cnj = cnj;
    }

    public convantion getCnv() {
        return cnv;
    }

    public void setCnv(convantion cnv) {
        this.cnv = cnv;
    }
    
    
    



    
    
    
    
    
}
