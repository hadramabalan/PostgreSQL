
package dbsapp;

import dbsapp.model.Exam;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


//Form for displaying all existing exams and manipulation with them
public class Exams extends javax.swing.JPanel {
    Menu menu;
    List<Exam> exams = new ArrayList<>();
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;




    
    public Exams(Menu menu) {
        this.menu = menu;
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        et = em.getTransaction();

        initComponents();
        createTable();
    }

    
    //Creates table with existing exams
    private void createTable(){
            exams = getExams();
        
            jPanel2.setLayout(new GridBagLayout());
            jPanel2.setBorder(LineBorder.createBlackLineBorder());
            GridBagConstraints frameConstraints = new GridBagConstraints();
            frameConstraints.gridx = 0;
            frameConstraints.gridy = 1;
            frameConstraints.weighty = 1;
            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            JButton[] deleteBtns = new JButton[exams.size()];
            JButton[] editBtns = new JButton[exams.size()];
            JButton[] studentsBtns = new JButton[exams.size()];
            
            //Shows a message if no exams exist
            if(exams.size() == 0){
                JLabel emptyLabel = new JLabel();
                emptyLabel.setText("No exams have been created yet");
                jPanel2.add(emptyLabel, textFieldConstraints);
        }
            
            //Iterates through the list of exams and creates rows with their name, websites and action buttons
            for(int j=0;j< exams.size();j++){
                        setNameAndWebsite(textFieldConstraints, j);
                        addStudentBtns(studentsBtns, textFieldConstraints, j);
                        addEditBtns(editBtns, textFieldConstraints, j);
                        addDeleteBtns(deleteBtns, textFieldConstraints, j);
                    }

                jPanel2.updateUI();
    }
    
    //Retrieves existing exams from the database
    private List<Exam> getExams(){
         TypedQuery<Exam> q1 = em.createQuery("SELECT d FROM Exam AS d",
        Exam.class
        );
         
        return q1.getResultList();
    }
    
    private void setNameAndWebsite(GridBagConstraints constraints, Integer index){
        JLabel nameLabel = new JLabel();
        nameLabel.setText(exams.get(index).name);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel2.add(nameLabel, constraints);
                        
        JLabel phoneLabel = new JLabel();
        phoneLabel.setText(exams.get(index).programWebsite);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel2.add(phoneLabel, constraints);
    }
    
    private void addStudentBtns(JButton[] studentsBtns, GridBagConstraints constraints, Integer index){
        studentsBtns[index] = new JButton("See students");
        studentsBtns[index].setName(String.valueOf(index));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel2.add(studentsBtns[index], constraints);    
        
        //Opens a window with exam's students
        studentsBtns[index].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                int btnIndex =  Integer.parseInt(btn.getName());
                menu.frame.setContentPane(new Students(menu, exams.get(btnIndex)));
                menu.frame.pack();
                emf.close();
            }});        
    }
    
    private void addEditBtns(JButton[] editBtns, GridBagConstraints constraints, Integer index){
        editBtns[index] = new JButton("See detail/edit");
        editBtns[index].setName(String.valueOf(index));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel2.add(editBtns[index], constraints);    
        
        //Opens a new edit form for the selected exam
        editBtns[index].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                int btnIndex =  Integer.parseInt(btn.getName());
                emf.close();
                menu.frame.setContentPane(new EditExam(menu, exams.get(btnIndex)));
                menu.frame.pack();
            }});        
    }
    
        private void addDeleteBtns(JButton[] deleteBtns, GridBagConstraints constraints, int index) {
        deleteBtns[index] = new JButton("Delete");
        deleteBtns[index].setName(String.valueOf(index));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel2.add(deleteBtns[index], constraints);   
        
        //Deletes the selected exam
        deleteBtns[index].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                try {
                    JButton btn = (JButton)e.getSource();
                    int btnIndex =  Integer.parseInt(btn.getName());
                    et.begin();
                    Exam toRemove = em.find(Exam.class, exams.get(btnIndex).examId);
                    em.remove(toRemove);
                    et.commit();
                    JOptionPane.showMessageDialog(menu.frame, "Exam successfully deleted");
                } catch (Exception ex) {
                    Logger.getLogger(Exams.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(menu.frame, "Couldn't delete selected exam");
                }
                menu.frame.setContentPane(new Exams(menu));
                menu.frame.pack();
            }});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jLabel1.setText("Exams");

        jLabel6.setText("Name");

        jLabel7.setText("Website");

        jButton2.setText("Back to menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Create new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu.frame.setContentPane(new CreateExam(menu));
        menu.frame.pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Takes the user back to the menu
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        menu.frame.setContentPane(this.menu);
        menu.frame.pack();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables


}
