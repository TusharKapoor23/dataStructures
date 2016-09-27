package datastructures;
class LinkedList{
    private Node head;
    public LinkedList(){
        head = new Node(null);
    }
    
    public void add(Object data){
        Node temp = new Node(data);
        Node current = head;
        if(current.getData() == null){
            current.setData(data);
        }
        else{
            while(current.getNext()!= null){
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }
    
    public void remove(){
        head = head.getNext();
    }
    
    public void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }      
}
class Node{
    Node next;
    Object data;
    public Node(Object value){
        next = null;
        data = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node value) {
        next = value;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object value) {
        data = value;
    } 
}
public class DataStructures {
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.display();
        ll.remove();
        ll.display();
    }
}
