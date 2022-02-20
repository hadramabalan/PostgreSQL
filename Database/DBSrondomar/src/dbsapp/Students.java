
package dbsapp;

import dbsapp.model.Exam;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

//Class for displaying all the students in a selected exams
public class Students extends javax.swing.JPanel {
    
    Menu menu;
    Exam d;
    EntityManagerFactory emf;
    EntityManager em;

    public Students(Menu menu, Exam d) {
        initComponents();
        this.menu = menu;
        this.d = d;
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        
        
        //Sets the name of the label to the exam's name
        jLabel1.setText(d.name);
        createTable();
    }
    
    //Creates table of the exam's students
    public void createTable(){
            jPanel1.setLayout(new GridBagLayout());
            jPanel1.setBorder(LineBorder.createBlackLineBorder());
            GridBagConstraints frameConstraints = new GridBagConstraints();
            frameConstraints.gridx = 0;
            frameConstraints.gridy = 1;
            frameConstraints.weighty = 1;
            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            System.out.println(d.students);
            
            //Iterates through the list of students and creates rows with their full name and student ID
            for(int j=0;j< d.students.size();j++){
                        JLabel nameLabel = new JLabel();
                        nameLabel.setText(d.students.get(j).first + " " + d.students.get(j).last);
                        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                        textFieldConstraints.weightx = 1;
                        textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                        textFieldConstraints.gridy = j;
                        jPanel1.add(nameLabel, textFieldConstraints);
                        
                        JLabel idLabel = new JLabel();
                        idLabel.setText(d.students.get(j).studentId);
                        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                        textFieldConstraints.weightx = 1;
                        textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                        textFieldConstraints.gridy = j;
                        jPanel1.add(idLabel, textFieldConstraints);
                        
            }
            
            emf.close();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jButton1.setText("Back to menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Student name");

        jLabel3.setText("Student Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3)))))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Takes the user back to menu
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu.frame.setContentPane(menu);
        menu.frame.pack();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
