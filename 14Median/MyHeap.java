import java.util.*;
public class MyHeap{
    private int[]ary;
    private int size;
    private boolean min;
    public MyHeap(){
	ary=new int[1];
	ary[0]=0;
	size=0;
	min=true;
    }
    public MyHeap(boolean h){
        ary=new int[1];
	ary[0]=0;
	size=0;
	if(h){
	    min=false;
	}
	else{
	    min=true;
	}
    }
    public int size(){
	return size;
    }
    public int peek(){
	if(size == 0){
	    return 0;
	}
	return ary[1];
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
    public int remove(){
	int x = ary[1];
	int y=ary[size];
	ary[1]=ary[size];	
	size--;
	int i=1;
	while (i<=size/2){
	    if(min){
		if(ary[i]>=ary[2*i]&&ary[i]>=ary[2*i+1]){
		    pushDown(i);
		    if(ary[2*i]==y){
			i=2*i;
		    }
		    else{
			i=2*i+1;
		    }
		}
		else{
		    return x;
		}
	    }
	    else{
		if(ary[i]<ary[2*i]&&ary[i]<ary[2*i+1]){
		    pushDown(i);
		    if(ary[2*i]==y){
			i=2*i;
		    }
		    else{
			i=2*i+1;
		    }		    
		}
		else{
		    return x;
		}
	    }
	}		
	return x;
    }
    private void pushDown(int x){
	int temp = ary[x];
	int a=ary[2*x];
	int b=ary[2*x+1];
	if(min){
	    if(a<=b){
		ary[x]=a;
		ary[2*x]=temp;
	    }
	    else{
		ary[x]=b;
		ary[2*x+1]=temp;
	    }
	}
	else{
	    if (a>=b){
		ary[x]=a;
		ary[2*x]=temp;
	    }
	}
	      
		       
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
	x.remove();
	x.add(5625);
	System.out.println(x);
    }
}
