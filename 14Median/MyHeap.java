import java.util.*;
public class MyHeap{
    private int[]ary;
    private int size;
    private boolean min;
    public MyHeap(){
	ary=new int[1];
	ary[0]=0;
	size=0;
    }
    public MyHeap(boolean h){
        ary=new int[1];
	ary[0]=0;
	size=0;
	if(h){
	    min=false;
	}
    }
    public void add(int s){
        int[]x=new int[2*(size+1)];
	for (int y = 0; y <size+1;y++){
	    x[y]=ary[y];
	}
	ary=x;
	ary[size+1]=s;
	size++;
	int i = size;
	if (size > 1){
	    if(min){
		while(ary[i]<ary[i/2]&&i>1){
		    pushUp(i);
		    i=i/2;
		}
	    }
	    else{
		while(ary[i]>ary[i/2]&&i>1){
		    pushUp(i);
		    i=i/2;
		}
	    }
	}
    }
    public int remove(int x){
	return x;
    }
    private void pushDown(int x){
    }
    private void pushUp(int x){
	int temp=ary[x/2];
	ary[x/2]=ary[x];
	ary[x]=temp;
    }
    public String toString(){
	String a = "[";
	for (int i = 1; i <= size; i++){
	    a+= ary[i]+",";
	}
	return a+"]";
    }
    public static void main(String[]a){
	MyHeap x = new MyHeap(false);//max heap
	x.add(1225);
	x.add(625);
	x.add(3025);
	x.add(5625);
	System.out.println(x);
    }
}
