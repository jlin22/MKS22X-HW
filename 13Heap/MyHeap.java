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
    }
    public String remove(){
	size--;
	return ary.remove(size);
    }
    public String peek(){
	return ary.get(size);
    }
    private void pushUp(){	
    }
    private void pushDown(){
    }
    
    
}
