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
import domain.ListException;
import domain.Node;
import domain.SinglyLinkedList;
import domain.Student;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ListException {
        
        
        
        SinglyLinkedList a=new SinglyLinkedList();
        a.add(new Student("1", "Karla", 20, "San José"));
        a.add(new Student("2", "Carlos", 22, "San José"));
        a.add(new Student("3", "Laura", 20, "Paraíso"));
        a.add(new Student("4", "Paula", 18, "Turrialba"));
        a.add(new Student("5", "Carlos", 21, "Limón"));
        
        DoublyLinkedList b=new DoublyLinkedList();
        
        b.add(new Course("50","Informática.",4));
        b.add(new Course("20","Inglés.",4));
        b.add(new Course("1","Agronomía.",4));
        b.add(new Course("40","Informática.",4));
        b.add(new Course("80","Inglés.",4));
        
        CircularLinkedList c=new CircularLinkedList();
        c.add(new Employee(178118522,"Castillo","José","Abogado.",new Date(84,8,3)));
        c.add(new Employee(116134986,"Alvarado","José","Gerente.",new Date(95,8,3)));
        c.add(new Employee(194685164,"Molina","José","Profesor.",new Date(80,8,3)));
        c.add(new Employee(802080018,"Solano","Sebas","Desarrollador Web.",new Date(84,8,3)));
        c.add(new Employee(117190806,"Rojas","Miguel","Cajero.",new Date(90,8,3)));

         CircularDoublyLinkedList d= new CircularDoublyLinkedList ();
         d.add(new JobPosition("Gerente.", 150));
         d.add(new JobPosition("Cajero.", 100));
         d.add(new JobPosition("Desarrollador Web.", 100));
         d.add(new JobPosition("Profesor.", 48));
         d.add(new JobPosition("Abogado.", 40));
         
         //coment
    Node reference=new Node(new Student("97", "Karla", 20, "San José"));
    
            DoublyLinkedList list =new DoublyLinkedList();

    
        Node aux;// nodo auxiliar para guardar los .next
        reference.next = (Node) a.getFirst();//a first
        aux = reference.next;
        aux.next = (Node) a.getLast();//a last
        aux = aux.next;
        aux.next = (Node) b.getFirst();//b first
        aux = aux.next;
        aux.next = (Node) b.getLast();//b last
        aux = aux.next;
        aux.next = (Node) c.getFirst();//c first
        aux = aux.next;
        aux.next = (Node) c.getLast();//b last
        aux = aux.next;
        aux.next = (Node) d.getFirst();//d first
       
    /**
     *
     */
        
    }}