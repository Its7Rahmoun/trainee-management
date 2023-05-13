/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import module.stage;

/**
 *
 * @author User
 */
public class tables {
    

 
    
    public static void main (String[] args){
    
        try{
            String persontable="create table person(id int AUTO_INCREMENT primary key,nom text,prenom text,mobile text,address text, email text ,UNIQUE(email))";
            String usertable="create table user (id int AUTO_INCREMENT  primary key,password text,id_person int , FOREIGN KEY (id_person) REFERENCES Person(id))";
            String hierarchy="create table hierarchy (id int AUTO_INCREMENT  primary key,id_user int , FOREIGN KEY (id_user) REFERENCES user (id) ON DELETE CASCADE )";
            String stage_chief_table="create table stageChief(id int AUTO_INCREMENT  primary key ,dept varchar(30),id_user int , FOREIGN KEY (id_user) REFERENCES user(id) )";
            String candidateTable="create table candidat(id int AUTO_INCREMENT primary key,etat boolean,dateDubet text,cv text,id_person int , FOREIGN KEY (id_person) REFERENCES person (id) ON DELETE CASCADE)";
            //String ecoletable="create table university (id int AUTO_INCREMENT  primary key , nom varchar(30),address text)";
            String conventiontable="create table convention(id int AUTO_INCREMENT  primary key ,dateEenvoie text,convention text,id_candidat int, foreign key (id_candidat) references candidat(id) on delete cascade )";             
            String stagairetable="create table stagaire (id int  AUTO_INCREMENT  primary key ,dateDepart text,dateFin text,nbr_jour_cng int,id_convention int,id_candidat int , foreign key (id_candidat) references candidat(id) on delete cascade,foreign key (id_convention) references convention(id) on delete cascade )";
            String stagetable="create table stage(id int AUTO_INCREMENT  primary key,titre text,suject text,duree text,id_candidat int,id_stageChief int, foreign key (id_candidat) references candidat(id) on delete cascade, foreign key (id_stageChief) references stageChief(id) on delete cascade )";   
            String notetable="create table note (id int AUTO_INCREMENT  primary key,noteTravail float,noteCompoetement float,noteRapport float ,id_stagaire int,id_stage int, foreign key (id_stagaire) references stagaire(id) on delete cascade,foreign key (id_stage) references stage(id) on delete cascade  )";
            String g ="alter table person drop column password";

            //operation.execute_date(g, "operation has benn executed susccessfly/§§§§");




            

        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
    
    
    }
    
}
