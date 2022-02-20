package dbsapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Exm", uniqueConstraints = {
       @UniqueConstraint(columnNames = {"name"}) })
public class Exam implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer examId;

    @Column(name="name", nullable=false)
    public String name;

    @Column(name="subjects", nullable=false)
    public String subjects;

    @Column(name="programwebsite", nullable = false)
    public String programWebsite;

    @Column(name="school", nullable = false)
    public String school;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "placement", 
        joinColumns = { @JoinColumn(name = "examid") }, 
        inverseJoinColumns = { @JoinColumn(name = "studid") }
    )
    public List<Student> students;
    
    public Exam(){}
  
}
