public class RunningMedian{
    private MyHeap max,min;
    //max || min
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
    }
    public void add(int x){
	if (max.size()==1&&min.size()==0){
	    if (x<max.peek()){
		int i = max.peek();
		max.remove();
		max.add(x);
		min.add(i);
	    }
	    else{
		min.add(x);
	    }
	}
	else if(max.size()==0&&min.size()==1){
	    if(x>min.peek()){
		int i = min.peek();
		min.remove();
		min.add(x);
		max.add(i);
	    }
	    else{
		max.add(x);
	    }	    	    	    				
	}
	else{
	    if (min.size()>max.size()){
		max.add(x);
	    }
	    else if(min.size()<max.size()){
		min.add(x);
	    }
	    else{
		if(x<max.peek()){
		    max.add(x);
		}
		else if(x>min.peek()){
		    min.add(x);
		}		    
	    }
	}
       
    }
    public String x(){
	return max.toString()+min.toString();
    }
    public double getMedian(){
        if (min.size() > max.size()){
	    return min.peek();
	}
	else if(max.size() > min.size()){
	    return max.peek();
	}
	else{
	    return ((double)max.peek() + (double)min.peek())/2;
	}
	      
    }
    /*public static void main(String[]a){
	RunningMedian x =new RunningMedian();
	x.add(4);
	x.add(3);
	x.add(7);
	x.add(1);
	System.out.println(x.getMedian());
    }*/
}
