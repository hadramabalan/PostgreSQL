/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsapp.model;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Martin
 */

@Entity
@Table(name="placement")
public class Placement implements Serializable{

    //Composite primary key embedded from its own class
    @EmbeddedId
    public CompositePK pk;
      
    
    
    public Placement(){
        this.pk = null;
    }
    
    public Integer getStudent(){
        return pk.student;
    }
    
    public Integer getExam(){
        return pk.exam;
    }
    
    public void setStudent(Integer studId){
        if(pk == null){
            pk = new CompositePK();
        }
        pk.student = studId;
    }
    
    public void setExam(Integer examId){
        if(pk == null){
            pk = new CompositePK();
        }
        pk.exam = examId;
    }
}


