import java.util.*;
public class MyDeque{
    String[] list;
    int front;
    int back;
    int size;
    public MyDeque(){
	list = new String[10];
	front = 0;
	back = 0;
	size = 0;
    }
    private void grow(){
	if ((back > front && back - front == list.length-1)||(front > back && back + list.length-front == list.length-1)){
	    String[] x = new String[list.length*2];
	    if (back > front){
		for (int i = 0; i < list.length; i++){
		    x[i] = list[i];
		}
		list = x;
	    }
	    else{
		for (int b = 0; b <= back; b++){
		    x[b] = list[b];
		}
		for (int f = list.length-1; f >= front; f--){
		    x[list.length+f]=list[f];
		}
		front +=list.length;
		list = x;
	    }
	}
	    
    }
    public void addFirst(String x){
	if (x == null){
	    throw new NullPointerException();
	}
	size++;
	grow();
	if (size == 1){
	    list[front]=x;
	    return;
	}
	if (front == 0){
	    front = list.length-1;
	}
	else{
	    front = (front-1)%list.length;
	}
	list[front] = x;
    }
    public void addLast(String x){
	if (x == null){
	    throw new NullPointerException();
	}
	size++;
	grow();
	if (size==1){
	    list[back]=x;
	    return;
	}
	if (back == list.length-1){
	    back = 0;
	}
	else{   
	    back = (back+1)%list.length;
	}
	list[back] = x; 
    }
    public String removeFirst(){
	if (back == front && size != 1){
	    throw new NoSuchElementException();
	}
	size--;
	String x = list[front];
	if (front == list.length-1){
	    front = 0;
	}
	else{
	    front = (front+1)%list.length;
	}
	return x;
    }
    public String removeLast(){
	if (back == front && size != 1){
	    throw new NoSuchElementException();
	}
	size--;
	String x = list[back];
	if (back == 0){
	    back = list.length-1;
	}
	else{   
	    back = (back-1)%list.length;
	}
	return x;
    }
    public String getFirst(){
	if (back == front&&size!=1){
	    throw new NoSuchElementException();
	}
	return list[front];
    }
    public String getLast(){
	if (back == front&&size!=1){
	    throw new NoSuchElementException();
	}
	return list[back];
    }
    public static void main(String[]a){
	MyDeque x = new MyDeque();
	for (int i = 0; i < 100; i++){
	    x.addFirst(""+i);
	}
	for (int i = 0; i < 100; i++){
	    System.out.println(x.removeFirst());
	}
    }
    
}
