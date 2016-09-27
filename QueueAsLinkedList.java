package datastructures;
class LinkedQueue{
    private Node head;
    public LinkedQueue(){
        head = new Node(null);
    }
    public void push(Object data){
        Node current = head;
        Node temp = new Node(data);
        if(head.getData() == null){
            head.setData(data);
        }
        else{
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(temp);
                
        }
    }
    public void pop(){
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
public class QueueAsLinkedList {
    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.push("1");
        lq.push("2");
        lq.push("3");
        lq.push("4");
        lq.push("5");
        lq.display();
        lq.pop();
        lq.display();
    }
}
