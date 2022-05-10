/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class Node {
    public Object data;
    public Node next; //apuntador al sgte node
    public Node prev; //apuntador al nodo anterior
        private Node first; //apunta al inicio de la lista

    //Constructor
    public Node(Object data){
        this.first=(Node)data;
        this.data = data;
        this.prev = this.next = null;
    }
    
    
     public void display(Node reference) throws ListException{
         if (!isEmpty()) {
             Node aux=this.first;
             for (int i = 1; i <= size(); i++) {
                 System.out.println(i+" "+getNode(i).data);
             }
             
             
         }
        
        }
     
      public boolean isEmpty() {
        return first==null;
    }
     
      public int size() throws ListException {
        if(isEmpty())
            throw new ListException("Node Linked List is empty");
        Node aux = first;
        int counter = 0;
        while(aux!=null){
           counter++;
           aux = aux.next;
        }
        return counter;
    }
      
      public Node getNode(int index) throws ListException {
        if (isEmpty()) {
            throw new ListException("Node Linked List is empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while (aux!=null) {
            if (util.Utility.equals(i, index)) {
                return aux;
            }
            i++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        if (util.Utility.equals(i, index)) {
            return aux;
        }
        return null; //si llega aqui no encontro el nodo
    }

       
}
