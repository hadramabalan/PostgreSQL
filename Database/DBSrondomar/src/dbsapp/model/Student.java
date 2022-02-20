
package dbsapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "student")
public class Student implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer studId;
    
    @Column(name="firstname", nullable=false)
    public String first;
    
    @Column(name="lastname",nullable=false)
    public String last;
    
    @Column(name="street",nullable=false)
    public String street;
    
    @Column(name="city",nullable=false)
    public String city;
    
    @Column(name="state",nullable=false)
    public String state;
    
    @Column(name="ssn",nullable=false)
    public String ssn;
    
    @Column(name="studentId",nullable=false)
    public String studentId;
    
    @Column(name="phone",nullable=false)
    public String phone;
    
    @Column(name="ZIP",nullable=false)
    public String ZIP;
    
    @ManyToMany(mappedBy = "students")
    List<Exam> exams = new ArrayList<>();
    
    public Student(){}


    
}
    
    
    
    

