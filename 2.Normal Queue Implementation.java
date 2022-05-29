import java.util.*;
public class Main
{
    static int q[] = new int[5];
    static int front = 0;
    static int size = 0;
	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		display();
		peek();
		remove();
		display();
		peek();
	}
	static void add(int data){
	    if(size == q.length){
	        System.out.println("OverFlow");
	        return;
	    }else{
	        int rear = (front + size) % q.length;
	        q[rear] = data;
	        size++;
	    }
	}
	static void remove(){
	    if(size == 0){
	        System.out.println("UnderFlow");
	        return;
	    }else{
	        front = (front + size) % q.length;
	        System.out.println("Removed data : "+q[front]);
	        front++;
	        size--;
	    }
	}
	static void peek(){
	    if(size == 0){
	        System.out.println("UnderFlow");
	        return;
	    }else{
	        System.out.println("Peek data : "+q[front]);
	    }
	}
	static void display(){
	    if(size == 0){
	        System.out.println("No element found");
	        return;
	    }else{
	        for(int i=0;i<size;i++){
	            int idx = (front + i) % q.length;
	            System.out.print(q[idx]+" ");
	        }
	        System.out.println();
	    }
	}
}
