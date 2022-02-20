
package dbsapp;

import dbsapp.model.Exam;
import dbsapp.model.Student;
import dbsapp.model.Placement;
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


//Class for CRD of the placement relationship
public class Placements extends javax.swing.JPanel {
        Menu menu;
        EntityManagerFactory emf;
        EntityManager em;
        EntityTransaction et;
        public List<String> placementExams = new ArrayList<>();
        public List<String> placementStudents = new ArrayList<>();
        
        public List<Integer> exams;
        public List<Integer> students;



    
    public Placements(Menu menu) {
        this.menu = menu;
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        initComponents();
        getData();
        
        //Sets the options of the combo boxes to existing student Ids and school names
        setJComboBox1();
        setJComboBox2();
        
        setContent();   
}
    
    //Retrieves the data about placement entities from the database
    private void getData(){
        TypedQuery<Placement> q1 = em.createQuery(
            "SELECT p FROM Placement AS p",
            Placement.class
        );
        List<Placement> placements = q1.getResultList();
        
        for (Placement p : placements) {
            placementExams.add(em.find(Exam.class, p.getExam()).name);
            placementStudents.add(em.find(Student.class, p.getStudent()).studentId);
        }
    }
    
    //Sets the items of the first combo box to values of exam names
    private void setJComboBox1(){
         Query q1 = em.createQuery("SELECT d.name FROM Exam AS d",
            Exam.class
        );
        exams = q1.getResultList();
        String[] examArray = new String[exams.size()];
        examArray = exams.toArray(examArray);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(examArray));
    }
    
    //Sets the items of the second combo box to values of students' IDs
    private void setJComboBox2(){
       Query q1 = em.createQuery("SELECT e.studentId FROM Student AS e",
            Student.class
        );
        students = q1.getResultList();
        String[] studentArray = new String[students.size()];
        studentArray = students.toArray(studentArray);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(studentArray));
    }
    
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Placement");

        jLabel2.setText("Exam");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Student");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Add new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Create new");

        jLabel5.setText("Existing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 976, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel6.setText("Exam");

        jLabel7.setText("Student");

        jButton2.setText("Back to menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel3)
                        .addGap(75, 75, 75)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(133, 133, 133)
                                    .addComponent(jLabel7))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Creates a new relationship instance
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
                et.begin();
                String selectedExam = (String) jComboBox1.getSelectedItem();
                String selectedStudent = (String) jComboBox2.getSelectedItem();
                TypedQuery<Exam> q1 = em.createQuery("SELECT d FROM Exam AS d WHERE (d.name = :ExamName)",
                    Exam.class
                );
                TypedQuery<Student> q2 = em.createQuery("SELECT e FROM Student AS e WHERE (e.studentId = :StudentId)",
                    Student.class
                );
                q1.setParameter("ExamName", selectedExam);
                q2.setParameter("StudentId", selectedStudent);
                Exam d = q1.getSingleResult();
                d.students.add(q2.getSingleResult());
                em.merge(d);
                em.persist(d);
                et.commit();
                JOptionPane.showMessageDialog(menu.frame, "Relationship succesfully created");
            } catch (Exception ex) {
                Logger.getLogger(Placements.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(menu.frame, "Error. Couldn't create the relationship. Check if it doesn't exist already");
            }
            Placements cm = new Placements(this.menu);
            menu.frame.setContentPane(cm);
            menu.frame.pack();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        menu.frame.setContentPane(this.menu);
    }//GEN-LAST:event_jButton2ActionPerformed

    //Sets the content of the relationship list
    private void setContent(){
        this.removeAll();
        jPanel1.setLayout(new GridBagLayout());
            jPanel1.setBorder(LineBorder.createBlackLineBorder());

            // Add panel to frame
            GridBagConstraints frameConstraints = new GridBagConstraints();
            frameConstraints.gridx = 0;
            frameConstraints.gridy = 1;
            frameConstraints.weighty = 1;
            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            JButton[] btns = new JButton[exams.size()];
            int i;
            for(int j=0;j<placementExams.size();j++){
                        addExamAndStudent(textFieldConstraints, j);
                        addDeleteBtns(btns, textFieldConstraints, j);
                    }

                jPanel1.updateUI();
    }
    
    private void addExamAndStudent(GridBagConstraints constraints, Integer index){
        JLabel examLabel = new JLabel();
        examLabel.setText(placementExams.get(index).toString());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel1.add(examLabel, constraints);
        
        JLabel studentLabel = new JLabel();
        studentLabel.setText(placementStudents.get(index).toString());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridy = index;
        jPanel1.add(studentLabel, constraints);        
    }
    
    private void addDeleteBtns(JButton[] btns, GridBagConstraints constraints, Integer index){
       btns[index] = new JButton("Delete");
       btns[index].setName(String.valueOf(index));
       constraints.fill = GridBagConstraints.HORIZONTAL;
       constraints.weightx = 2;
       constraints.insets = new Insets(10, 10, 10, 10);
       constraints.gridy = index;
       btns[index].addActionListener(new ActionListener() { 
           public void actionPerformed(ActionEvent e) {
               JButton btn = (JButton)e.getSource();
               int btnIndex =  Integer.parseInt(btn.getName());
                try {
                   et.begin();
                   String selectedExam = placementExams.get(btnIndex);
                    String selectedStudent = placementStudents.get(btnIndex);
                    TypedQuery<Exam> q1 = em.createQuery("SELECT d FROM Placement AS d WHERE (d.name = :ExamName)",
                        Exam.class
                    );
                    TypedQuery<Student> q2 = em.createQuery("SELECT e FROM Student AS e WHERE (e.studId = :StudentId)",
                        Student.class
                    );
                    q1.setParameter("ExamName", selectedExam);
                    q2.setParameter("StudentId", selectedStudent);
                    Exam d = q1.getSingleResult();
                    d.students.remove(q2.getSingleResult());
                    em.merge(d);
                    em.persist(d);
                    et.commit();
                    JOptionPane.showMessageDialog(menu.frame, "The relationship was successfully deleted");
                    Placements cm = new Placements(menu);
                    menu.frame.setContentPane(cm);
                    menu.frame.pack();
               } catch (Exception ex) {
                   Logger.getLogger(Placements.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(menu.frame, "Couldn't delete the selected relationship");
                       }
           }});
       jPanel1.add( btns[index], constraints);  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
