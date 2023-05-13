    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import module.stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import tools.file_to_bytes;

/**
 *
 * @author User
 */
public class hira_date_acces {

    public static ArrayList<stage> getcatalogue(String dept) {
        String query0 = "SELECT stage.* from stage,stagechief f where stage.id_stageChief=f.id and f.dept='"+dept+"'";

        ArrayList<stage> stages = new ArrayList<>();
        boolean createPdf = false;

        try {
            ResultSet rs = operation.getdate(query0);

                    

                


                while (rs.next()) {
                    createPdf=true;
                    stages.add(new stage(rs.getInt("id"), rs.getString("titre"), rs.getString("suject"), rs.getString("duree"), rs.getInt("id_stageChief")));
                }


               if(createPdf)
                return stages;

            

        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        JOptionPane.showMessageDialog(null, "this department doesn't exist");
        return null;
    }

    public static void save(String nom, String prenom, String email, String mobile, String doc, String date, String add, ArrayList<Integer> stagepostuler) throws FileNotFoundException, IOException {

        try {

            //check if ids of stage exists in stage table  
            boolean allstageexist = false;
            for (int i : stagepostuler) {
                ResultSet rs1 = operation.getdate("select * from stage where id=" + i + "");
                if (!rs1.next()) {
                    JOptionPane.showMessageDialog(null, "this id of stage  " + i + " dosen't exiset  ");
                    allstageexist = false;
                    break;
                }
                allstageexist = true;
            }

            if (allstageexist) {
                //insert persone 
                String query = "INSERT INTO `person`( `nom`, `prenom`, `mobile`, `address`, `email`) VALUES ('" + nom + "','" + prenom + "','" + mobile + "','" + add + "','" + email + "')";
                operation.execute_date(query, "");
                operation.execute_date("commit", "");
                ResultSet rs = operation.getdate("select * from person where email='" + email + "' and nom='" + nom + "'");

                //insert data into candidat table
                System.out.println("11");
                if (rs.next()) {
                    System.out.println("22");

                    String query1 = "INSERT INTO `candidat`(`etat`, `dateDubet`, `cv`, `id_person`) VALUES (0,'" + date + "',?," + rs.getInt("id") + ")";
                    FileInputStream in = file_to_bytes.file_to_byte(new File(doc));
                    operation.prepare(query1, in);
                    System.out.println("33");

                    //insert data in stagepostulet table
                    String getid = "SELECT * FROM `candidat` WHERE id_person=" + rs.getInt("id") + " AND etat=false";
                    ResultSet idcan = operation.getdate(getid);
                    if (idcan.next()) {
                        System.out.println(idcan.getInt("id"));
                        int id_candidat = idcan.getInt("id");

                        for (int i : stagepostuler) {
                            String query2 = "INSERT INTO `stagepostuler`( `id_stage`, `id_candidat`) VALUES (" + i + "," + id_candidat + ")";
                            operation.execute_date(query2, "");
                        }

                        JOptionPane.showMessageDialog(null, "trainer has been inserter to datebase successfully");

                    }

                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public static void candidat_to_potensielCandidat(String nom, String email, String hiramail, String respansablemail, int id_stage) {
        String query = "select * from person where email='" + email + "' and nom = '" + nom + "'";
        try {
            ResultSet rs = operation.getdate(query);
            if (rs.next()) {
                ResultSet rs1 = operation.getdate("select * from candidat where id_person=" + rs.getInt("id"));
                if (rs1.next()) {
                    if (!rs1.getBoolean("etat")) {
                        operation.execute_date("update candidat set etat= true where id=" + rs1.getInt("id"), "this candidat became a potencoel trainer");
                        operation.execute_date("delete from  stagepostuler where id_candidat = " + rs1.getInt("id") + " and id_stage !=" + id_stage, "");
                    } else {
                        JOptionPane.showMessageDialog(null, "this candidate already admitted to another internship");
                        ResultSet rs2 = operation.getdate("select * from person where email='" + hiramail + "'");
                        if (rs2.next()) {
                            ResultSet rs3 = operation.getdate("select * from user where id_person=" + rs2.getInt("id"));
                            if (rs3.next()) {
                                tools.sendEmail.send(respansablemail, hiramail, rs3.getString("password"), "cancel trainer", "candidat " + rs.getString("nom") + "__" + rs.getString("prenom") + " already admited to another intership");
                            }

                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "candidat doesn't exist");
                }
            } else {
                JOptionPane.showMessageDialog(null, "this email address is not assigned to any user on this platform");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void cancelregestiration(String nom, String email, String hiramail, String respansablemail, int id_stage) {
        String query = "select * from person where email='" + email + "' and nom = '" + nom + "'";

        try {

            ResultSet rs = operation.getdate(query);
            if (rs.next()) {
                ResultSet rs1 = operation.getdate("select * from candidat where id_person=" + rs.getInt("id"));
                if (rs1.next()) {
                    ResultSet rs2 = operation.getdate("select * from person where email='" + hiramail + "'");
                    if (rs2.next()) {
                        ResultSet rs3 = operation.getdate("select * from user where id_person=" + rs2.getInt("id"));
                        if (rs3.next()) {
                            tools.sendEmail.send(respansablemail, hiramail, rs3.getString("password"), "cancel trainer", "candidat " + rs.getString("nom") + "__" + rs.getString("prenom") + " refuse this training with id_training is :  " + id_stage);
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "candidat doesn't exist");
                }
            } else {
                JOptionPane.showMessageDialog(null, "this email address is not assigned to any user on this platform");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public static void saveIntern(String candidatmail, String nom, String convention, String datesend, String datedepart, int daysoff, String dateend) {
        String query0 = "select * from person where email='" + candidatmail + "' and nom='" + nom + "'";
        try {
            ResultSet rs0 = operation.getdate(query0);
            if (rs0.next()) {
                System.out.println("1");
                String query1 = "select * from candidat where id_person=" + rs0.getInt("id");
                ResultSet rs1 = operation.getdate(query1);
                System.out.println("2");

                if (rs1.next()) {
                    System.out.println("3");

                    if (rs1.getBoolean("etat")) {

                        //insert convention first 
                        FileInputStream fis = tools.file_to_bytes.file_to_byte(new File(convention));
                        String query2 = "INSERT INTO `convention`( `dateEenvoie`, `convention`, `id_candidat`) VALUES ('" + datesend + "',?," + rs1.getInt("id") + ")";
                        operation.prepare(query2, fis);
                        System.out.println("    4");

                        //get id of convention
                        ResultSet rs2 = operation.getdate("select * from convention where id_candidat =" + rs1.getInt("id"));
                        System.out.println("    4");
                        if (rs2.next()) {

                            //get id of stage 
                            ResultSet rs3 = operation.getdate("select * from stagepostuler where id_candidat=" + rs1.getInt("id"));
                            System.out.println("    4");

                            //insert stagaire 
                            if (rs3.next()) {
                                String query4 = "INSERT INTO `stagaire`(`dateDepart`, `dateFin`, `nbr_jour_cng`, `id_convention`, `id_candidat`, `id_stage`) VALUES ('" + datedepart + "','" + dateend + "'," + daysoff + "," + rs2.getInt("id") + "," + rs1.getInt("id") + "," + rs3.getInt("id_stage") + ")";
                                operation.execute_date(query4, "intern was inserted with successfully");
                                System.out.println("    4");
                            }   

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "this candidat is not admited yet");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "this date is not assigned to any candidate ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "email or first name of user incorrect");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

}
