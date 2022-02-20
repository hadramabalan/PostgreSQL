/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsapp;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


//Class for the navigation in the app
public class Menu extends javax.swing.JPanel {
    
    public static JFrame frame;

    
    public static void main(String args[]) {
        
        //Sets the frame for the app
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame();
                frame.setTitle("EasyExam");
                Menu m = new Menu();
                frame.setContentPane(m);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
        );
    }
    
    public Menu() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dptButton = new javax.swing.JButton();
        placementButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        newDptButton = new javax.swing.JButton();

        dptButton.setText("Exams");
        dptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dptButtonActionPerformed(evt);
            }
        });

        placementButton.setText("Placements");
        placementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placementButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        newDptButton.setText("Create Exam");
        newDptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(newDptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(placementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(433, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(newDptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(placementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    
//Opens a list of Exams
    private void dptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dptButtonActionPerformed
        Exams cd = new Exams(this);
        frame.setContentPane(cd);
        frame.pack();
    }//GEN-LAST:event_dptButtonActionPerformed
    
//Closes the app
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitButtonActionPerformed

//Opens a list of placements
    private void placementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placementButtonActionPerformed
        Placements p = new Placements(this);
        frame.setContentPane(p);
        frame.pack();  
    }//GEN-LAST:event_placementButtonActionPerformed

//Opens a form for creating a new exam
    private void newDptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDptButtonActionPerformed
        CreateExam cd = new CreateExam(this);
        frame.setContentPane(cd);
        frame.pack();
    }//GEN-LAST:event_newDptButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dptButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton newDptButton;
    private javax.swing.JButton placementButton;
    // End of variables declaration//GEN-END:variables
}
