package datastructures;
class ArrayQueue{
    private final int size = 5;
    int arr[] = new int[size];
    int top = -1;
    int rear =0;
    public void push(int data){
        top++;
        if(top > size -1){
            System.out.println("Stack Overflow");
        }
        else{
            arr[top] = data;
        }
    }
    public void pop(){
        if(top >= rear){
            rear++;
        }
        else{
            System.out.println("Underflow");
        }
    }
    public void display(){
        for (int i = rear; i <= top ; i++) {
            System.out.println(arr[i]);
        }
    }
}
class QueueAsArray {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        aq.push(1);
        aq.push(2);
        aq.push(3);
        aq.push(4);
        aq.push(5);
        aq.display();
        aq.pop();
        aq.display();
    }
}
