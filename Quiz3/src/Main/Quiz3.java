/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import domain.CircularDoublyLinkedList;
import domain.CircularLinkedList;
import domain.Course;
import domain.DoublyLinkedList;
import domain.Employee;
import domain.JobPosition;
import domain.SinglyLinkedList;
import domain.Student;
import java.util.Date;

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
        
        CircularLinkedList c=new CircularLinkedList();
        c.add(new Employee(178118522,"Castillo","José","Abogado.",new Date(84,8,3)));
        c.add(new Employee(116134986,"Alvarado","José","Gerente.",new Date(95,8,3)));
        c.add(new Employee(194685164,"Molina","José","Profesor.",new Date(80,8,3)));
        c.add(new Employee(802080018,"Solano","Sebas","Desarrollador Web.",new Date(84,8,3)));
        c.add(new Employee(117190806,"Rojas","Miguel","Cajero.",new Date(90,8,3)));

         CircularDoublyLinkedList b= new CircularDoublyLinkedList ();
         b.add(new JobPosition("Gerente.", 150));
         b.add(new JobPosition("Cajero.", 100));
         b.add(new JobPosition("Desarrollador Web.", 100));
         b.add(new JobPosition("Profesor.", 48));
         b.add(new JobPosition("Abogado.", 40));
         
         //coment

    }
    
}
