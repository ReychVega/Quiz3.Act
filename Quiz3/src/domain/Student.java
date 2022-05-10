/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class Student implements Person {
    private String id;
    private String name;
    private int age;
    private String address;

    public Student() {
    }
    
    
    
    public Student(String id,String name, int age, String address) {
    this.name=name;
    this.id=id;
    this.age=age;
    this.address=address;
    }

    public String getId() {
        return id;
    }
    
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(SinglyLinkedList list,int index,Student other) {
            if (list.isEmpty()) {
                list.add(other);//añade el elemento
            return true;
        }else{
                try {
                    if (index<=list.size()) {
                        
                        String s = ""+ list.getNode(index).data;
                        if (s.contains(other.getId())) {
                            return false;//no se puede insertar
                        } else {
                            index++;
                            equals(list,index,other);
                        }
                    }
                } catch (ListException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        list.add(other);
        return true;//si llega a aquí, se puede añadir
    }
  
    public double studyHours(){
        return getAge()/2;
    }
    
    public String toString(){
        return "Student {" + "id=" + getId() + ", name=" + getName() + ", age=" + getAge() +", study hours= "
                + studyHours()+ ", address="+getAddress();
    }
    
}
