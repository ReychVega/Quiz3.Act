/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class CircularDoublyLinkedList implements List {

    private Node first; //apunta al inicio de la lista
    private Node last; //apunta al ult nodo de la lista

    //Constructor
    public CircularDoublyLinkedList() {
        this.first = this.last = null;
    }

    @Override
    public int size() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int counter = 0;
        while (aux != last) {
            counter++;
            aux = aux.next;
        }
        //sale del while cuando aux esta en el ult nodo
        return counter + 1;
    }

    public void sortId(CircularDoublyLinkedList list) throws ListException {//Ordena por Id
      if(isEmpty()){
            throw new ListException("Circular Linked List is empty");  
            }else{
           
           for(int i=1;i<=list.size();i++){
    	     for(int j=i+1;j<=list.size();j++){
    		if(util.Utility.cambio(getNode(i).data, getNode(j).data)){
    		   Object aux=getNode(i).data;
                    getNode(i).data=getNode(j).data;
    		    getNode(j).data=aux;
                   // System.out.println("i "+getNode(i).data+"  j "+getNode(j).data);
    		}//if
            }//for j
        }//for i
           
        }
    }
    
    @Override
    public void clear() {
        this.first = this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        while (aux != last) {
            if (util.Utility.equals(aux.data, element)) {
                return true;
            }
            aux = aux.next;
        }
        //sale del while cuando aux esta en el ult nodo
        return util.Utility.equals(aux.data, element);
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;

            //hago el enlace circular
            last.next = first;
            //hago el doble enlace
            first.prev = last;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        //hago el enlace circular y doble
        last.next = first;
        first.prev = last;
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {

        Node nodoCreado = new Node(element);
        if (isEmpty()) {
            first = nodoCreado;
        } else {
            //caso 2 es nulo o no es nulo
            if (util.Utility.greaterT(first.data, element)) {
                nodoCreado.next = first;
                first = nodoCreado;
            } else {
                //CASO 3
                Node prev = first;
                Node aux = first.next;
                boolean newAdded = false;
                while (aux != null && newAdded) {
                    if (util.Utility.lessT(element, aux.data)) {
                        prev.next = nodoCreado;
                        nodoCreado.next = aux;
                        newAdded = true;
                    }
                    prev = aux;
                    aux = aux.next;
                }
                //si llega aqui se agrega al final de la lista
                if (!newAdded) {
                    prev.next = nodoCreado;
                }
            }
        }

    }

    @Override
    public void remove(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        //caso 1. El elemento a suprimir es el primero
        if (util.Utility.equals(first.data, element)) {
            first = first.next;
        } //case 2. El elemento a suprimir puede estar donde sea
        else {
            Node prev = first; //elemento anterior
            Node aux = first.next; //elemento sgte
            while (aux != last && !util.Utility.equals(aux.data, element)) {
                prev = aux; //actualizo anterior
                aux = aux.next;
            }
            //se sale cuando alcanza aux==last
            //o cuando encuentra el elemento a suprimir
            if (util.Utility.equals(aux.data, element)) {
                //desenlanza el nodo
                prev.next = aux.next;
                //mantengo el doble enlace
                aux.next.prev = prev; //opcion 1
                //otra alternativa, opcion 2
                //Node aux2 = aux.next;
                //aux2.prev = prev;

                //debo asegurarme q last apunte al ultimo nodo
                //entendiendo que aux esta en el nodo a suprimir
                if (aux == last) { //estamos en el ultimo nodo
                    last = prev;
                }
            }
        }
        //mantengo el enlace circular y doble
        last.next = first;
        first.prev = last;
        //q pasa si solo queda un nodo
        //y es el q quiero eliminar
        if (first == last && util.Utility.equals(first.data, element)) {
            clear(); //anulo la lista
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Object element = first.data;
        first = first.next;
        //hago el enlace circular y doble
        last.next = first;
        first.prev = last;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {

        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node prev = first;
        Node aux = first.next;
        while (aux != last) {
            prev = aux;
            aux = aux.next;
        }

        prev.next = aux.next;
        //Desenlazo el doble enlace que apuntaba al último nodo
        aux.next.prev = prev;

        last = prev;

//Sigo manteniendo el formato de lista circular doblemente enlazada
        last.next = first;
        first.prev = last;

        return prev;

    }

    @Override
    public void sort() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        for (int i = 1; i <= size(); i++) {
            for (int j = i + 1; j <= size(); j++) {
                if (util.Utility.lessT(getNode(j).data, getNode(i).data)) {
                    Object aux = getNode(i).data;
                    getNode(i).data = getNode(j).data;
                    getNode(j).data = aux;
                }//if
            }//for j
        }//for i
    }

    @Override
    public int indexOf(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int index = 1;
        while (aux != last) {
            if (util.Utility.equals(aux.data, element)) {
                return index;
            }
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux apunta a last (al ultimo nodo)
        if (util.Utility.equals(aux.data, element)) {
            return index;
        }
        return -1; //indica q el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return last.data; //es el ultimo en la lista
    }

    @Override
    public Object getPrev(Object element) throws ListException {

        Object res = -1;//Por el momento no existe
        if (isEmpty()) {
            throw new ListException("Doubly Linked List is empty");
        }
        Node posicion = first.next;
        Node ant = first;
        
        //Valido si el elemento es igual al ant, o sea, al first
        
        if(util.Utility.equals(ant.data, element)){
            
            ant = ant.prev;//Si es el primero entonces el ant que está en first, se vaya a last
            res = ant.data;
        }
        
        
        while (posicion != last && !util.Utility.equals(posicion.data, element)) {

            ant = posicion;
            posicion = posicion.next; //Avanzo en la lista

        }

        if (util.Utility.equals(posicion.data, element)) {

            res = ant.data;

        }
        

        return res;

    }

    @Override
    public Object getNext(Object element) throws ListException {
        Object res = -1;//Por el momento no existe
        if (isEmpty()) {
            throw new ListException("Doubly Linked List is empty");
        }
        Node aux = first;
        while (aux != last && !util.Utility.equals(aux.data, element)) {//recorre la lista mientras no llegue a nulo o al elemento
            aux = aux.next;
        }
        //sale cuando aux==last o encontro el elemento
        if (aux != last && util.Utility.equals(aux.data, element)) {
            aux = aux.next;//res o la salida es igual al apuntador del elemento siguiente del elemento actual
            res = aux.data;
        } else {

            //cuando resulta que el elementoencontrado es el last o ultimo
            if (aux == last && util.Utility.equals(aux.data, element)) {

                aux = aux.next;
                res = aux.data;

            }

        }

        return res;

    }

    @Override
    public Node getNode(int index) throws ListException {
        if (isEmpty()) {
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while (aux != last) {
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

    public List getTitleList(CircularDoublyLinkedList list, String title) throws ListException {
        CircularDoublyLinkedList listByTitle = new CircularDoublyLinkedList();
        listByTitle.first = null;//para no sobre escribir en esta lista.
        listByTitle.last = null;

        for (int i = 1; i <= list.size(); i++) {
            Employee e = (Employee) getNode(i).data;
            if (e.getTitle() == title) {
                listByTitle.add(getNode(i).data);
            }
        }

        return listByTitle;

    }
    
    public void addInSortedList(Object element, CircularDoublyLinkedList list) throws ListException {//hacer
        if (isEmpty()) {
            add(element);
        }else{
        Node prev=this.first;
         Node aux=first.next;
        Node newNode = new Node(element);
        for(int i=1;i<list.size();i++){
    		if(util.Utility.lessT(getNode(i).data, element)){
    		   prev=getNode(i);
                    aux = getNode(i + 1);
                    System.out.println("i    "+prev.data +"  j      "+aux.data);
                //System.out.println("en medio "+util.Utility.lessT(prev.data, element)+" ** "+util.Utility.lessT(element, aux.data));
                }
                    if (util.Utility.igualCompareTo(getNode(i).data, element)) {
                        prev=getNode(i);
                        aux = getNode(i + 1);
                  //      System.out.println("i    "+prev.data +"  j      "+aux.data);
                    //    System.out.println("en medio pero igual "+util.Utility.lessT(prev.data, element)+" ** "+util.Utility.lessT(element, aux.data));

                }//if
                    
                     }//for i
                        //System.out.println("first "+util.Utility.lessT(prev.data, element)+" ** "+util.Utility.lessT(element, aux.data));
            //caso 1. va introducido en la lista
            if (util.Utility.lessT(prev.data, element) && util.Utility.lessT(element, aux.data)) {
                newNode.next = aux;
                prev.next = newNode;
                }else{//caso 2.  va de ultimo en orden alfabetico
                    if ((util.Utility.lessT(prev.data, element) && !util.Utility.lessT(element, aux.data))) {
                        list.addLast(element);
                      //  System.out.println(" last " + util.Utility.lessT(prev.data, element) + "  " + util.Utility.greaterT(element, aux.data));
                    } else {//caso 3, va de primero
                        if (util.Utility.lessT(element, prev.data)) {
                        //    System.out.println(" first " + util.Utility.lessT(prev.data, element) + "  " + util.Utility.greaterT(element, aux.data));
                            newNode.next = first;
                            last.next = newNode;
                            first = newNode;
                        } else {
                            if (util.Utility.igualCompareTo(prev.data, element)) {//caso 4, si son iguales
                          //      System.out.println(" medio e igual " + util.Utility.lessT(prev.data, element) + "  " + util.Utility.greaterT(element, aux.data));

                                newNode.next = aux;
                                prev.next = newNode;

                        }
                    }
                }
            }
  
        }
    }


    //metodo con dos parametros, minimo y maximo
    public CircularDoublyLinkedList ageList(CircularDoublyLinkedList list, int low, int high) throws ListException {//Muestra a los empleados entre un determinado rango de edad; 
        CircularDoublyLinkedList resultList = new CircularDoublyLinkedList();//creamos una nueva lista 
        for (int i = 1; i < list.size(); i++) {
            Employee e = (Employee) list.getNode(i).data;
            if (e.getAge() >= low && e.getAge() <= high) {
                resultList.add(e);//Si cumple el rango agregue el empleado a la lista
            }
        }

        return resultList;

    }

    //metodo con una sola entrada, el minimo
    public CircularDoublyLinkedList ageList(CircularDoublyLinkedList list, int low) throws ListException {//Muestra a los empleados entre un determinado rango de edad; 
        CircularDoublyLinkedList resultList = new CircularDoublyLinkedList();//creamos una nueva lista 
        for (int i = 1; i < list.size(); i++) {
            Employee e = (Employee) list.getNode(i).data;
            if (e.getAge() >= low) {
                resultList.add(e);//Si cumple que es mayor o igual al minimo agregue el empleado a la lista
            }
        }

        return resultList;

    }

    @Override
    public String toString() {
        String result = "Circular Doubly Linked List Content\n";
        Node aux = first;
        while (aux != last) {
            result += aux.data + "\n";
            aux = aux.next;
        }
        //agregamos la info del ultimo nodo
        return result + "\n" + aux.data;
    }

}
