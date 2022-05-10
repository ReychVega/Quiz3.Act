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
    public Node first;
    //Constructor
    public Node(Object data){
       
        this.data = data;
        this.prev = this.next = null;
    }
    
     public void display(Node reference) throws ListException{
       
            Node aux=reference;
            while(aux!=null){
             System.out.println(aux.data+"");
             aux=aux.next;
            }
         
        
        }
     
      public void inverse(Node reference) throws ListException{
          
          for (int i = size(reference); i >= 1; i--) {//* <
            System.out.println(getNode(i,reference).data);
           //   System.out.println(i);
          }
            
//          System.out.println(getNode(1,reference).data);
//          System.out.println("s "+size(reference));

        }
      
      
       public Node getNode(int index, Node reference) throws ListException {
        int i = 1; //posicion del 1er elemento
        Node aux = reference;
        while(aux!=null&&!util.Utility.equals(index, i)){
            aux = aux.next;
            i++;
        }
        //sale cuando aux==null o encontro el elemento
        if(aux!=null&&util.Utility.equals(index, i)){
            return aux;
        }
        return null; //el elemento no existe
    }

        public int size(Node reference) throws ListException {
       
        Node aux = reference;//reference
        int counter = 0;
        while(aux!=null){
           counter++;
           aux = aux.next;
        }
        return counter;
    }
   
}
