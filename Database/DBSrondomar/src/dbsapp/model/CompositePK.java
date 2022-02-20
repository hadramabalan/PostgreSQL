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



//Class for the supervision's composite primary key
@Embeddable
public class CompositePK implements Serializable{
    @Column(name="studid",nullable=false)
    public Integer student;
    
    @Column(name="examid",nullable=false)
    public Integer exam;
    
   
    public CompositePK(){
        this.student = null;
        this.exam = null;
    }
    
    
}
