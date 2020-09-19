/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.view;

import hr.edunova.horvat.controller.ObradaOperater;
import hr.edunova.horvat.model.Operater;
import java.awt.event.KeyEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Josip
 */
public class Autorizacija extends javax.swing.JFrame {

    /**
     * Creates new form Autorizacija
     */
    public Autorizacija() {
        initComponents();
        // Fokus strijelice za unos ce biti na Email
        txtEmail.requestFocus();
        
        txtEmail.setText("josiph988@gmail.com");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pswLozinka = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Email");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Lozinka");

        pswLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswLozinkaKeyReleased(evt);
            }
        });

        jCheckBox1.setText("Zapamti me");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Prijavi se");

        btnPrijava.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnPrijava)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1))
                        .addComponent(pswLozinka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(pswLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(btnPrijava))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
      //Desni klik events key- key released  
      // provjera koji key je pritisnut
      // System.out.println(evt.getKeyCode()); 
      if(evt.getKeyCode() == KeyEvent.VK_ENTER && !txtEmail.getText().trim().isEmpty()){
          // kad na Email stisnes enter focus prelazi na lozinku
          pswLozinka.requestFocus();
                  
      }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void pswLozinkaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswLozinkaKeyReleased
     // kad na lozinki stisnes enter i lozinka je duza od 0 zoves metodu prijavi se
     if (evt.getKeyCode() == KeyEvent.VK_ENTER && pswLozinka.getPassword().length>0){
            prijaviSe();
        }
    }//GEN-LAST:event_pswLozinkaKeyReleased

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
     prijaviSe();
     // Kada pritisnem btn prijava ulazim u metodu koja provjerava jesu li uvijeti za prijavu zadovoljeni
    }//GEN-LAST:event_btnPrijavaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pswLozinka;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables

    private void prijaviSe() {
        // ovdje se prekida metoda ako je :
        if(txtEmail.getText().trim().isEmpty()){
            txtEmail.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Email je obavezno unijeti");
            return;
        }
        try{
            InternetAddress emAddress = new InternetAddress(txtEmail.getText());
            emAddress.validate();
        }catch(AddressException ex){
            txtEmail.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Email nije ispravan");
            return;

        }
          if(pswLozinka.getPassword().length==0){
            pswLozinka.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Lozinka je obavezna");
            return;
            // nakon ove metode siguran si da su vrijednosti unesene i mozes na kontroler
        }
          
          ObradaOperater oo = new ObradaOperater();
          Operater operater = oo.autoriziraj(txtEmail.getText(), pswLozinka.getPassword());
          if(operater==null){
              JOptionPane.showMessageDialog(rootPane, "Ne ispravna kombinacija email i lozinka");
              return;
          }
          Aplikacija.operater = operater;
          
          new Izbornik().setVisible(true);
          dispose();
        
    }
    
   
    
}
