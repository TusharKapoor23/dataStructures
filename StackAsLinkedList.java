package datastructures;
class LinkedStack{
    private Node head;
    public LinkedStack(){
        head = new Node(null);
    }
    public void push(Object data){
        Node temp = new Node(data);
        Node current = head;
        if(current.getData() == null){
            current.setData(data);
        }
        else{
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }
    public void pop(){
        Node current = head;
        while(current.getNext().getNext() != null){
            current = current.getNext();
        }
        current.setNext(null);
    }
    public void display(){
        Node current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
            
    }
}
public class StackAsLinkedList {
    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();
        ls.push("1");
        ls.push("2");
        ls.push("3");
        ls.push("4");
        ls.push("5");
        ls.display();
        ls.pop();
        ls.display();
        
    }
}