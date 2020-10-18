/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import hr.edunova.horvat.controller.ObradaVozac;
import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.utility.MyException;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.Imaging;

/**
 * 
 * @author Josip
 */
public class Vozaci extends javax.swing.JFrame {

    private ObradaVozac obrada;
    private Vozac entitet;
    
    
    ImageIcon createIcon = new ImageIcon("slike"+ File.separator+ "ikonice" + File.separator+"DatabaseDodajIcon.png");
    ImageIcon updateIcon = new ImageIcon("slike"+ File.separator+ "ikonice" + File.separator+"updateIcon.png");
    ImageIcon deleteIcon = new ImageIcon("slike"+ File.separator+ "ikonice" + File.separator+"deleteIcon.png");
    ImageIcon searchIcon = new ImageIcon("slike"+ File.separator+ "ikonice" + File.separator+"searchIcon.png");
    ImageIcon cleanIcon = new ImageIcon("slike"+ File.separator+ "ikonice" + File.separator+"Metlica.png");
    /**
     * Creates new form Vozaci
     */
    public Vozaci() {
        initComponents();
        obrada = new ObradaVozac();
        setTitle(Aplikacija.operater.getImeIPrezime()+ " - Vozaci ");
        ucitajPodatke();
        dodajSliku();
        
       
        DatePickerSettings datePickerSettings = new DatePickerSettings( new Locale("hr", "HR", "HR"));
        datePickerSettings.setFormatForDatesCommonEra("dd.MM.yyyy");
        //datePickerSettings.setLocale(Locale.forLanguageTag("hr-HR-x-1variant-HR"));
        Locale.setDefault( new Locale("hr"));
        dpDatumRodjenja.setLocale(new Locale("hr"));
        dpDatumRodjenja.setSettings(datePickerSettings);
       
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        pnlPodaci = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        txtOib = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPoruka = new javax.swing.JLabel();
        dpDatumRodjenja = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        chbVerificiran = new javax.swing.JCheckBox();
        lblSlika = new javax.swing.JLabel();
        btnObrisiSliku = new javax.swing.JButton();
        btnIzmijeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        txtUvjet = new javax.swing.JTextField();
        btnTrazilica = new javax.swing.JButton();
        btnOcisti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lstPodaci.setBorder(new javax.swing.border.MatteBorder(null));
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        pnlPodaci.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Ime");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtOib.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtIme.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setText("Prezime");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setText("OIB");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setText("Email");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblPoruka.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPoruka.setForeground(new java.awt.Color(204, 0, 0));

        jLabel5.setText("Datum Rodjenja");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        chbVerificiran.setText("Osiguran");
        chbVerificiran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblSlika.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSlikaMouseClicked(evt);
            }
        });
        lblSlika.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblSlikaKeyPressed(evt);
            }
        });

        btnObrisiSliku.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnObrisiSliku.setText("X");
        btnObrisiSliku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiSlikuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPodaciLayout.createSequentialGroup()
                                .addComponent(dpDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(chbVerificiran))
                            .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlPodaciLayout.createSequentialGroup()
                                    .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                            .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblSlika, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiSliku)
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSlika, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiSliku, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbVerificiran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        btnIzmijeni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIzmijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmijeniActionPerformed(evt);
            }
        });

        btnDodaj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        txtUvjet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUvjetKeyReleased(evt);
            }
        });

        btnTrazilica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrazilicaActionPerformed(evt);
            }
        });

        btnOcisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcistiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnOcisti, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzmijeni, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOcisti, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(btnIzmijeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(btnTrazilica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
      if(evt.getValueIsAdjusting()){
          return;
      }
     entitet=lstPodaci.getSelectedValue();
      if(entitet== null){
          return;
      }
        txtIme.setText(entitet.getIme());
        txtPrezime.setText(entitet.getPrezime());
        txtOib.setText(entitet.getOib());
        txtEmail.setText(entitet.getEmail());
        chbVerificiran.setSelected(entitet.getVerificiran());
        
        dpDatumRodjenja.setDate(entitet.getDatumRodjenja().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
       
        
        File slika = new File("slike"+ File.separator+ "vozaci"+ 
                File.separator + entitet.getId()+ ".png");
        if(!slika.exists()){
            slika = new File("slike"+ File.separator + "nepoznato.jpg");
            
        }
          try {
            ImageIcon ii = new ImageIcon(Imaging.getBufferedImage(slika)
            .getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            lblSlika.setIcon(ii);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       
        lblPoruka.setText("");
        entitet = new Vozac();
        
        postaviVrijednostiUEntitet();
        
       
       
        try{
        obrada.create();
        ucitajPodatke();
        ocistiPolja();
        }catch(MyException e){
           postaviPoruku(e.getPoruka());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmijeniActionPerformed
      entitet= lstPodaci.getSelectedValue();
      if(entitet==null){
          return;
      }
      postaviVrijednostiUEntitet();
      
      try{
          obrada.update();
          ucitajPodatke();
          ocistiPolja();
      }catch(MyException e){
          postaviPoruku(e.getPoruka());
      }
        
    }//GEN-LAST:event_btnIzmijeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        entitet= lstPodaci.getSelectedValue();
          if(entitet==null){
            return;
         }
          obrada.setEntitet(entitet);
        
        try{
          obrada.delete();
          ucitajPodatke();
          ocistiPolja();
      }catch(MyException e){
          postaviPoruku(e.getPoruka());
      }
       
    }//GEN-LAST:event_btnObrisiActionPerformed

     private void postaviPoruku(String poruka ){
        lblPoruka.setText(poruka);
        OcistiPoruku op = new OcistiPoruku();
        op.start();
      
    }
    
    private class OcistiPoruku extends Thread{

        @Override
        public void run() {
          try {
            Thread.sleep(3*1000);
        } catch (InterruptedException ex) {
      
        }
          lblPoruka.setText("");
        }
        
    }
    
    private void txtUvjetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitajPodatke();
        }
    }//GEN-LAST:event_txtUvjetKeyReleased

    private void btnTrazilicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrazilicaActionPerformed
        ucitajPodatke();
    }//GEN-LAST:event_btnTrazilicaActionPerformed

    private void btnOcistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcistiActionPerformed
      ocistiPolja();
    }//GEN-LAST:event_btnOcistiActionPerformed

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjetActionPerformed

    private void lblSlikaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSlikaMouseClicked
        if(entitet== null){
            return;
          }
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            
            try {
                BufferedImage bi = Imaging.getBufferedImage(jfc.getSelectedFile());
                File slika = new File("slike"+ File.separator
                + "vozaci"+ File.separator + entitet.getId()+ ".png");
                ImageFormat format = ImageFormats.PNG;
                Map<String, Object> param = new HashMap<>();
                Imaging.writeImage(bi, slika, format, param);
                
                ImageIcon ii = new ImageIcon(Imaging.getBufferedImage(slika)
                .getScaledInstance(100, 150, Image.SCALE_DEFAULT));
                lblSlika.setIcon(ii);
               
                   
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }//GEN-LAST:event_lblSlikaMouseClicked

    private void lblSlikaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSlikaKeyPressed
            }//GEN-LAST:event_lblSlikaKeyPressed

    private void btnObrisiSlikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiSlikuActionPerformed
       
        Path imagePath = Paths.get("slike"+ File.separator
                + "vozaci"+ File.separator + entitet.getId()+ ".png");
          try {
            Files.delete(imagePath);
        } catch (IOException ex) {
                    
        }
          File slika = new File("slike"+ File.separator + "nepoznato.jpg");
       
       try {
            ImageIcon ii = new ImageIcon(Imaging.getBufferedImage(slika)
            .getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            lblSlika.setIcon(ii);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_btnObrisiSlikuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmijeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiSliku;
    private javax.swing.JButton btnOcisti;
    private javax.swing.JButton btnTrazilica;
    private javax.swing.JCheckBox chbVerificiran;
    private com.github.lgooddatepicker.components.DatePicker dpDatumRodjenja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JLabel lblSlika;
    private javax.swing.JList<Vozac> lstPodaci;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    private void ucitajPodatke() {

        DefaultListModel<Vozac> m = new DefaultListModel<>();
        obrada.getPodaci(txtUvjet.getText()).forEach(s-> m.addElement(s));
        // Za svaki s, model dodaj mi element tog s iz obrada(Obrada proizvodjac)
        // Ovaj forEach  je  one liner koji zamjenjuje petlje 
        
        lstPodaci.setModel(m);
        // ispravak greske na m: Design-> lstPodaci->code-> TypeParametars postaviti u proizvodjac
    }
    
    public void dodajSliku(){
           
       Image image = createIcon.getImage();
       Image imageScale = image.getScaledInstance(btnDodaj.getWidth(), btnDodaj.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon  scaledIcon = new ImageIcon(imageScale);
       btnDodaj.setIcon(scaledIcon);
       
       Image image1 = updateIcon.getImage();
       Image imageScale1 = image1.getScaledInstance(btnIzmijeni.getWidth(), btnIzmijeni.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon  scaledIcon1 = new ImageIcon(imageScale1);
       btnIzmijeni.setIcon(scaledIcon1);
       
       Image image2 = deleteIcon.getImage();
       Image imageScale2 = image2.getScaledInstance(btnObrisi.getWidth(), btnObrisi.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon  scaledIcon2 = new ImageIcon(imageScale2);
       btnObrisi.setIcon(scaledIcon2);
       
        Image trazilica = searchIcon.getImage();
       Image imageScale3 = trazilica.getScaledInstance(btnTrazilica.getWidth(), btnTrazilica.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon  scaledIcon3 = new ImageIcon(imageScale3);
       btnTrazilica.setIcon(scaledIcon3);
       
       Image metlica = cleanIcon.getImage();
       Image imageScale4 = metlica.getScaledInstance(btnOcisti.getWidth(), btnOcisti.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon  scaledIcon4 = new ImageIcon(imageScale4);
       btnOcisti.setIcon(scaledIcon4);
    }

    private void ocistiPolja() {
  for(Component c: pnlPodaci.getComponents()){
            if( c instanceof JTextField){
                ((JTextField) c).setText("");
            }
            if(c instanceof JCheckBox){
                ((JCheckBox) c).setSelected(false);
            }
            if(c instanceof DatePicker){
               (( DatePicker) c).clear();
            }
        }
        
    }

    private void postaviVrijednostiUEntitet() {
       entitet.setIme(txtIme.getText());
        entitet.setPrezime(txtPrezime.getText());
        entitet.setOib(txtOib.getText());
        entitet.setEmail(txtEmail.getText());
        entitet.setVerificiran(chbVerificiran.isSelected());
        
        
         try{
        entitet.setDatumRodjenja(Date.from(dpDatumRodjenja.getDate().atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant()));
        }catch(Exception e){
            entitet.setDatumRodjenja(null);
        }
        
        obrada.setEntitet(entitet);
    }
}
