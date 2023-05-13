/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package date_acces_object;

import java.awt.HeadlessException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import module.candidat;
import module.person;
import module.responsable_stage;
import module.stagaire;
import module.stage;
import module.user;

/**
 *
 * @author User
 */
public class chief_data_acces {

    public static void addStage(String title, String duree, String subjet, String chiefmail) {
        String query0 = "select * from person where email='" + chiefmail + "'";
        try {
            ResultSet rs0 = operation.getdate(query0);
            if (rs0.next()) {
                person chief_person = new person(rs0.getInt("id"), rs0.getString("nom"), rs0.getString("prenom"), rs0.getString("email"), rs0.getString("mobile"), rs0.getString("address"));
                String query1 = "select * from user where id_person=" + chief_person.getId();
                ResultSet rs1 = operation.getdate(query1);
                if (rs1.next()) {
                    user chief_user = new user(rs1.getString("password"), rs1.getInt("id"), chief_person);
                    String query2 = "select * from stagechief where id_user=" + chief_user.getId();
                    ResultSet rs2 = operation.getdate(query2);
                    if (rs2.next()) {
                        responsable_stage chief = new responsable_stage(rs2.getString("dept"), rs2.getInt("id"), chief_user);
                        String query4 = "select count(*)  from stage where id_stageChief=" + chief.getId();
                        ResultSet rs4 = operation.getdate(query4);
                        if (rs4.next()) {
                            int rows = rs4.getInt(1);
                            if (rows > 5) {
                                JOptionPane.showMessageDialog(null, "u can't add a new one cuz u are  already passed limit of subjets");
                            } else {
                                stage s = new stage(title, subjet, duree, chief.getId());
                                String query3 = "INSERT INTO `stage`( `titre`, `suject`, `duree`, `id_stageChief`) VALUES ('" + s.getTitle() + "','" + s.getSujet() + "','" + s.getDuree() + "'," + chief.getId() + ")";
                                operation.execute_date(query3, "traineeship has been inserted");
                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "this data not assigned for any chiefstage");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "user dosnt't exist");

                }
            } else {
                JOptionPane.showMessageDialog(null, "user doesn't exist");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ArrayList<candidat> getcandidat(String chiefmail,String stg,String nomcandidat) {
        String query_1 = "select * from person where email='" + chiefmail + "'";
        try {
            ResultSet rs_1 = operation.getdate(query_1);
            if (rs_1.next()) {
                System.out.println("111111");

                String query_2 = "select * from user where id_person=" + rs_1.getInt("id");
                ResultSet rs_2 = operation.getdate(query_2);
                if (rs_2.next()) {
                    System.out.println("111111");

                    String query_3 = "select * from stagechief where id_user=" + rs_2.getInt("id");
                    ResultSet rs_3 = operation.getdate(query_3);
                    if (rs_3.next()) {
                        System.out.println("111111");

                        String query_4 = "select * from stage where id_stageChief=" + rs_3.getInt("id")+" and titre like '%"+stg+"%'";
                        ResultSet rs_4 = operation.getdate(query_4);
                        boolean stageexist = false;
                        ArrayList<Integer> stage_ids = new ArrayList<>();
                        while (rs_4.next()) {
                            System.out.println("111111");
                            stage_ids.add(rs_4.getInt("id"));
                            stageexist = true;
                        }
                        if (stageexist) {
                            System.out.println(tools.needs.myfunction(stage_ids));

                            String query0 = "select c.* from candidat c,stagepostuler s  where c.etat=0 and c.id=s.id_candidat and s.id_stage in" + tools.needs.myfunction(stage_ids);
                            ArrayList<candidat> candidats = new ArrayList<>();

                            ResultSet rs0 = operation.getdate(query0);
                            System.out.println("1111222");

                            while (rs0.next()) {
                                System.out.println("1123451111");

                                String query1 = "select * from person where id=" + rs0.getInt("id_person")+" and nom like '%"+nomcandidat+"%'";
                                ResultSet rs1 = operation.getdate(query1);
                                if (rs1.next()) {
                                    OutputStream ot = tools.inputstreamtofile.input_to_file(rs0.getBinaryStream("cv"), "C:\\Users\\User\\Documents\\NetBeansProjects\\APPGestionStagaire\\cv_chief_view\\" + rs1.getString("nom") + "" + rs1.getString("prenom") + "_cv.txt");
                                    candidats.add(new candidat(rs0.getBoolean("etat"), rs0.getString("dateDubet"), ot, rs0.getInt("id"), rs0.getInt("id_person"), rs1.getString("nom"), rs1.getString("prenom"), rs1.getString("email"), rs1.getString("mobile"), rs1.getString("address")));
                                }

                            }

                            return candidats;

                        }

                    }

                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
        return null;

    }

    public static candidat getcandidat_to_send_on_email(String email, String chiefmail, String nom, String mailhira, String mailpass, int stageid) {
        String query0 = "select * from person where email='" + email + "' and nom='" + nom + "'";
        try {
            ResultSet rs0 = operation.getdate(query0);
            if (rs0.next()) {
                String query1 = "select * from candidat where id_person=" + rs0.getInt("id");
                ResultSet rs1 = operation.getdate(query1);
                if (rs1.next()) {
                    // String query3 = "select * from stagepostuler where id_candidat=" + rs1.getInt("id");
                    // ResultSet rs3 = operation.getdate(query3);
                    // if (rs3.next()) {
                    String query4 = "select * from stage where id=" + stageid;
                    ResultSet rs4 = operation.getdate(query4);
                    if (rs4.next()) {
                        tools.sendEmail.send(mailhira, chiefmail, mailpass, "candidat admited to my intreship", "candidat " + rs0.getString("nom") + " " + rs0.getString("prenom") + " has been accepted to intreship that has id : " + stageid + " and subjet is : " + rs4.getString("suject") + " and mailcandidat is : " + email);

                    }
                    //}
                } else {
                    JOptionPane.showMessageDialog(null, "candidat doesn't exist!!!!!!!!!!!!!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "this date not assigned for any user");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return null;
    }

    public static ArrayList<stage> get_all_intreship_of_candidat(String email, String nom, String cheifmail) {
        String query0 = "select * from person where email='" + email + "' and nom='" + nom + "'";
        try {

            ResultSet rs0 = operation.getdate(query0);
            if (rs0.next()) {
                String query1 = "select * from candidat where id_person=" + rs0.getInt("id");
                ResultSet rs1 = operation.getdate(query1);
                if (rs1.next()) {
                    String query2 = "select * from stagepostuler where id_candidat=" + rs1.getInt("id");
                    ArrayList<stage> stagepostuler = new ArrayList<>();
                    ResultSet rs2 = operation.getdate(query2);
                    while (rs2.next()) {
                        int idd = getid_chiefstage(cheifmail);
                        String query3 = "select * from stage where id=" + rs2.getInt("id_stage") + " and id_stageChief=" + idd;
                        ResultSet rs3 = operation.getdate(query3);
                        if (rs3.next()) {
                            stagepostuler.add(new stage(rs3.getInt("id"), rs3.getString("titre"), rs3.getString("suject"), rs3.getString("duree"), rs3.getInt("id_stageChief")));
                        }
                    }
                    return stagepostuler;
                }
            } else {
                JOptionPane.showMessageDialog(null, "this user doesn't exist!!!!");

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return null;
    }

    public static int getid_chiefstage(String email) {
        String query = "select * from person where email='" + email + "'";
        try {
            System.out.println("-1");
            ResultSet rs = operation.getdate(query);
            if (rs.next()) {
                System.out.println("-1");

                String query0 = "select * from user where id_person=" + rs.getInt("id");
                ResultSet rs0 = operation.getdate(query0);
                if (rs0.next()) {

                    String query1 = "select * from stagechief where id_user=" + rs0.getInt("id");
                    ResultSet rsget = operation.getdate(query1);
                    if (rsget.next()) {
                        return rsget.getInt("id");
                    }

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return -1;
    }

    public static ArrayList<stage> getIntreships(String mail) {
        try {
            int id = getid_chiefstage(mail);
            ArrayList<stage> intreships = new ArrayList<>();
            if (id > 0) {
                String query = "select * from stage where id_stageChief=" + id;
                ResultSet rs = operation.getdate(query);
                while (rs.next()) {
                    intreships.add(new stage(rs.getInt("id"), rs.getString("titre"), rs.getString("suject"), rs.getString("duree"), id));
                }
                return intreships;

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return null;
    }
    
    public static ArrayList<stagaire> getstagaires(String chefmail){
        try{
              int id = getid_chiefstage(chefmail);
              String query="select stage.titre,s.* from stagaire s , stage  where s.id_stage=stage.id and stage.id_stageChief="+id;
              ResultSet rs = operation.getdate(query);
              ArrayList<stagaire> stagaire= new ArrayList<>();
              while(rs.next()){
              String query1="select * from candidat where id="+rs.getInt("id_candidat");
              ResultSet rs1 = operation.getdate(query1);
              if(rs1.next()){
              String query2 ="select * from person where id="+rs1.getInt("id_person");
              ResultSet rs2 = operation.getdate(query2);
              if(rs2.next()){
                  stage s = new stage(rs.getString("titre"));
              stagaire.add(new stagaire(rs.getInt("id"),rs1.getInt("id"),rs2.getInt("id"),rs2.getString("nom"),rs2.getString("prenom"),s));
              }
              }  
              }
              
              return stagaire;
              
        
        }
        catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);

        }
    
    return null;
    }

}
