import java.util.*;
public class Main
{
    int size=5;
    int a[] = new int[size];
    int top=-1;
    
    void push(int x){
        if(top==size-1)
        {
            int b[] = new int[size*2];
            for(int i=0;i<=top;i++)
            b[i]=a[i];
            b[++top]=x;
            a=b;
            return ;
        }
        else{
            a[++top]=x;
        }
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("Underflow");
            return;
        }
        else{
            --top;
        }
    }
    void peek()
    {
        if(top==-1)
        {
            System.out.println("The stack has no element");
            return ;
        }
        else{
            System.out.println("Top--> "+a[top]);
        }
    }
    void display(){
        if(top==-1)
        {
            System.out.println("The stack has no element");
            return ;
        }else{
            
            for(int i=0;i<=top;i++)
            System.out.print(a[i]+ " ");
            System.out.println();
        }
    }
    
    
	public static void main(String[] args) {
	    Main main = new Main();
		main.push(10);
		main.push(20);
		main.push(30);
		main.push(40);
		main.push(50);
		main.push(60);
		main.peek();
		main.display();
		main.pop();
		main.display();
	}
}
