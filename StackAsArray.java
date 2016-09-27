package datastructures;

class Stack{
    private final int size = 5;
    int arr[] = new int[size];
    int top = -1;
    public void push(int data){
        if(top < size -1){
            top++;
            arr[top] = data;
        }
        else{
            System.out.println("Stack overflow");
        }
    }
    public void pop(){
        if(top >= 0){
            top--;
        }
        else{
            System.out.println("Stack Underflow");
        }
    }
    public void display(){
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }
}
public class StackAsArray {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.display();
        s.pop();
        s.display();
    }
}
