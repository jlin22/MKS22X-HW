public class FrontierPriorityQueue implements Frontier{
    public class MyHeap{
	private Location[] ary;
	private int size;
	private boolean min;
	public MyHeap(boolean h){
	    ary = new int[1];
	    ary[0] = 0;
	    size = 0;
	    if (h){
		min = false;
	    }
	    else{
		min = true;
	    }
	}
	public void add(Location x){
	    Location[]x = new Location[2*(size+1)];
	    for(int y = 0; y<size+1;y++){
		x[y]=ary[y];
	    }
	    ary=x;
	    ary[size+1]=s;
	    size++;
	    int i = size;
	    if(size > 1){
		if (min){
		    while(ary[i].compareTo(ary[i/2])<0&&i>1){
			pushUp(i);
			i=i/2;
		    }
		}
		else{
		    while(ary[i].compareTo(ary[i/2])>0&&i>1){
			pushUp(i);
			i=i/2;
		    }
		}
	    }
	}
	public Location remove(){
	    Location x = ary[1];
	    Location y = ary[size];
	    ary[1]= ary[size];
	    size--;
	    int i = 1;
	    while(i<=size/2){
		if (min){
		    if(ary[i].compareTo(ary[2*i])>=0&&ary[i].compareTo(ary[2*i+1])>=0){
			pushDown(i);
			if(ary[2*i]==y){
			    i=2*i;
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
		    if(ary[i].compareTo(ary[2*i])<=0&&ary[i].compareTo(ary[2*i+1])<=0){
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
	private void pushUp(int x){
	    Location temp = ary[x/2];
	    ary[x/2] = ary[x];
	    ary[x]= temp;
	}       	
	private void pushDown(int x){
	    Location temp = ary[x];
	    Location a = ary[2*x];
	    Location b = ary[2*x+1];
	    if(min){
		if (a.compareTo(b)<=0){
		    ary[x]=a;
		    ary[2*x]=temp;
		}
		else{
		    ary[x]=b;
		    ary[2*x+1] =temp;
		}
	    }
	    else{
		if(a.compareTo(b)>=0){
		    ary[x]=a;
		    ary[2*x]=temp;
		}
		else{
		    ary[x]=b;
		    ary[2*x+1]=temp;
		}
	    }
	}
    }
    public int size(){
    }
    public void add(Location x){
    }
    public Location next(){
    }
}
