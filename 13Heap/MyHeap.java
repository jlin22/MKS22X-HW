import java.util.*;
public class MyHeap{
    private String[] ary;
    private int size;
    private boolean min;
    public MyHeap(){
	ary = new String[1];
	ary[0] = "h";
	size = 0;
	min=false;
    }
    public MyHeap(boolean h){
	if (h){
	    ary = new String[1];
	    ary[0]="h";
	    size = 0;
	    min = false;
	}
	else{
	    ary = new String[1];
	    ary[0] = "h";
	    size = 0;
	    min = true;;
	}
    }
    public void add(String s){
        String[]x=new String[2*(size+1)];
	for (int y = 0; y < size+1; y++){
	    x[y]=ary[y];
	}
	ary=x;
	ary[size+1]=s;
	size++;
	int i = size;
	if (size > 1){
	    if (min){
		while (ary[i].compareTo(ary[i/2])<0 && i > 1){
		    pushUp(i);
		    i = i/2;
		}
	    }
	    else{
		while(ary[i].compareTo( ary[i/2])>0 && i> 1){
		    pushUp(i);
		    i = i/2;
		}
	    }		
	}
    }
    public String remove(){
	String x = ary[1];
	String y = ary[size];
	ary[1] = ary[size];
	size--;
	int i = 1;
	while (i <= size/2){
	    if (min){
		if (ary[i].compareTo(ary[2*i])>=0 && ary[i].compareTo(ary[2*i+1])>=0){
		    pushDown(i);
		    if (ary[2*i] == y){
			i = 2*i;
		    }
		    else{
			i = 2*i+1;
		    }
		}
		else{
		    return x;
		}
	    }
	    else{
		if (ary[i].compareTo(ary[2*i])<=0 && ary[i].compareTo(ary[2*i+1])<=0){
		    pushDown(i);
		    if (ary[2*i] == y){
			i = 2*i;
		    }
		    else{
			i = 2*i+1;
		    }
		}
		else{
		    return x;
		}
	    }
	}	        			    
	return x;
    }
    public String peek(){
	return ary[1];
    }
    private void pushUp(int x){
	String temp = ary[x/2];
	ary[x/2] = ary[x];
	ary[x] = temp;
    }
    private void pushDown(int x){
	String temp = ary[x];
	String a = ary[2*x];
	String b = ary[2*x+1];
	if (min){
	    //5,3,4
	    if (a.compareTo(b)<=0){
		ary[x] = a;
		ary[2*x] = temp;
	    }
	    else{
		ary[x] = b;
		ary[2*x+1] = temp;
	    }
	}	
	else{
	    //3,7,5
	    if (a.compareTo(b)>=0){
		ary[x] = a;
		ary[2*x] = temp;
	    }
	    else{
		ary[x] = b;
		ary[2*x+1] = temp;
	    }
	}
    }
    public String toString(){
	String a = "[";
	for (int i = 1; i < size+1; i++){
	    a+= ary[i] + ",";
	}
	return a+"]";
    }
    /*public static void main(String[]a){
	MyHeap h = new MyHeap(false);
	h.add("haha");
	h.add("xd");
	h.add("a");
	h.remove();
	System.out.println(h);
    }*/
    
    
}
