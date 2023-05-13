/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appgestionstagaire;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import date_acces_object.hira_date_acces;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import module.stage;

/**
 *
 * @author User
 */
public class espace_hera extends javax.swing.JFrame {
    
    public String hiraemail;

    public espace_hera(String email) {
        initComponents();
        hiraemail = email;
    }

    public espace_hera() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtdept = new javax.swing.JTextField();
        btnprint = new javax.swing.JButton();
        btnmanagecandidat = new javax.swing.JButton();
        btnmanageinsc = new javax.swing.JButton();
        btnmanagestagaire = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("department");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        txtdept.setBackground(new java.awt.Color(255, 204, 255));
        txtdept.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtdept, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 142, 283, 34));

        btnprint.setBackground(new java.awt.Color(255, 204, 255));
        btnprint.setForeground(new java.awt.Color(0, 0, 0));
        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnprint.setText("print catalog by department");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        getContentPane().add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 188, -1, -1));

        btnmanagecandidat.setBackground(new java.awt.Color(255, 204, 255));
        btnmanagecandidat.setForeground(new java.awt.Color(0, 0, 0));
        btnmanagecandidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage.png"))); // NOI18N
        btnmanagecandidat.setText("manage candidate");
        btnmanagecandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmanagecandidatActionPerformed(evt);
            }
        });
        getContentPane().add(btnmanagecandidat, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 362, -1, -1));

        btnmanageinsc.setBackground(new java.awt.Color(255, 204, 255));
        btnmanageinsc.setForeground(new java.awt.Color(0, 0, 0));
        btnmanageinsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage.png"))); // NOI18N
        btnmanageinsc.setText("manage candidate registration");
        btnmanageinsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmanageinscActionPerformed(evt);
            }
        });
        getContentPane().add(btnmanageinsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 248, -1, -1));

        btnmanagestagaire.setBackground(new java.awt.Color(255, 204, 255));
        btnmanagestagaire.setForeground(new java.awt.Color(0, 0, 0));
        btnmanagestagaire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage.png"))); // NOI18N
        btnmanagestagaire.setText("manage the interns");
        btnmanagestagaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmanagestagaireActionPerformed(evt);
            }
        });
        getContentPane().add(btnmanagestagaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 302, -1, -1));

        logout.setBackground(new java.awt.Color(255, 204, 255));
        logout.setForeground(new java.awt.Color(0, 0, 0));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setText("log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espace hera1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        String dept = txtdept.getText();
        ArrayList<stage> stages;
        stages = hira_date_acces.getcatalogue(dept);
        if (stages != null) {
            String path = "C:\\Users\\User\\Documents\\NetBeansProjects\\APPGestionStagaire\\pdfs\\";
            
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path + dept + ".pdf"));
                doc.open();
                Paragraph catalogue = new Paragraph("                                                                catalog \n");
                doc.add(catalogue);
                Paragraph starline = new Paragraph("*******************************************************************************************************\n");
                doc.add(starline);
                Paragraph p3 = new Paragraph("\n department Name:  " + dept);
                doc.add(p3);
                doc.add(starline);
                PdfPTable tb = new PdfPTable(3);
                tb.addCell("titre");
                tb.addCell("sujet");
                tb.addCell("duree");
                for (int i = 0; i < stages.size(); i++) {
                    String titre = stages.get(i).getTitle();
                    String sujet = stages.get(i).getSujet();
                    String duree = stages.get(i).getDuree();
                    
                    tb.addCell(titre);
                    tb.addCell(sujet);
                    tb.addCell(duree);
                }
                doc.add(tb);
                doc.add(starline);
                JOptionPane.showMessageDialog(null, "pdf has been created");
            } catch (DocumentException | FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            
        }
        

    }//GEN-LAST:event_btnprintActionPerformed

    private void btnmanageinscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmanageinscActionPerformed
        // TODO add your handling code here:
        new regestirationtrainers().setVisible(true);
    }//GEN-LAST:event_btnmanageinscActionPerformed

    private void btnmanagecandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmanagecandidatActionPerformed
        // TODO add your handling code here:
        new manage_candidat(hiraemail).setVisible(true);
    }//GEN-LAST:event_btnmanagecandidatActionPerformed

    private void btnmanagestagaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmanagestagaireActionPerformed
        // TODO add your handling code here:

        new manage_trainers().setVisible(true);
        
    }//GEN-LAST:event_btnmanagestagaireActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new logIn().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(espace_hera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(espace_hera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(espace_hera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(espace_hera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new espace_hera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmanagecandidat;
    private javax.swing.JButton btnmanageinsc;
    private javax.swing.JButton btnmanagestagaire;
    private javax.swing.JButton btnprint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logout;
    private javax.swing.JTextField txtdept;
    // End of variables declaration//GEN-END:variables
}