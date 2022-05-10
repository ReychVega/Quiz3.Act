/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import domain.CircularLinkedList;
import domain.Course;
import domain.DoublyLinkedList;
import domain.SinglyLinkedList;
import domain.Student;

/**
 *
 * @author usuario
 */
public class Quiz3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SinglyLinkedList s=new SinglyLinkedList();
        s.add(new Student("1", "Karla", 20, "San José"));
        s.add(new Student("2", "Carlos", 22, "San José"));
        s.add(new Student("3", "Laura", 20, "Paraíso"));
        s.add(new Student("4", "Paula", 18, "Turrialba"));
        s.add(new Student("5", "Carlos", 21, "Limón"));
        
        DoublyLinkedList d=new DoublyLinkedList();
        
        d.add(new Course("50","Informática.",4));
        d.add(new Course("20","Inglés.",4));
        d.add(new Course("1","Agronomía.",4));
        d.add(new Course("40","Informática.",4));
        d.add(new Course("80","Inglés.",4));
        
        CircularLinkedList c;
       /*
c. CircularLinkedList c, con 5 objetos tipo Employee (lab-5)
d. CircularDoublyLinkedList d, con 5 objetos tipo JobPosition (lab-5)*/
        
    }
    
}
