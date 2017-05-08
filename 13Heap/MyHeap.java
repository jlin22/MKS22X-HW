import java.util.io.*;
public class MyHeap{
    private ArrayList<String> ary;
    private int size;
    private boolean min;
    public MyHeap(){
	ary = new ArrayList<String>();
	ary.add("");
	size = 0;
    }
    public MyHeap(boolean h){
	if (h){
	    ary = new ArrayList<String>();
	    ary.add("");
	    size = 0;
	    min = false;
	}
	else{
	    ary = new ArrayList<String>();
	    ary.add("");
	    size = 0;
	    min = true;;
	}
    }
    public void add(String s){
	ary.add(s);
	size++;
	int i = size;
	if (min){
	    while (ary[i]<ary[i/2] && i != 1){
		pushUp(i);
		i = i/2;
	    }
	}
	else{
	    while(ary[i] > ary[i/2] && i!= 1){
		pushup(i);
		i = i/2;
	    }
	}		
    }
    public String remove(){
	String x = ary[1];
	String y = ary[size];
	ary[1] = ary[size];
	size--;
	i = 1;
	while (i <= size/2){
	    if (min){
		if (ary[i] > ary[2i] && ary[i] > ary[2i+1]){
		    pushDown(i);
		    if (ary[2i] = y){
			i = 2i;
		    }
		    else{
			i = 2i+1;
		    }
		}
		else{
		    return x;
		}
	    }
	    else{
		if (ary[i] <ary[2i] && ary[i] < ary[2i+1]){
		    pushDown(i);
		    if (ary[2i] = y){
			i = 2i;
		    }
		    else{
			i = 2i+1;
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
	return ary.get(size);
    }
    private void pushUp(int x){
	int temp = ary[x/2];
	ary[x/2] = ary[x];
	ary[x] = temp;
    }
    private void pushDown(int x){
	int temp = ary[x];
	int a = ary[2x];
	int b = ary[2x+1];
	if (min){
	    //5,3,4
	    if (a <= b){
		ary[x] = a;
		ary[2x] = temp;
	    }
	    else{
		ary[x] = b;
		ary[2x+1] = temp;
	    }
	}	
	else{
	    //3,7,5
	    if (a >= b){
		ary[x] = a;
		ary[2x] = temp;
	    }
	    else{
		ary[x] = b;
		ary[2x+1] = temp;
	    }
	}
    }
    
    
}
