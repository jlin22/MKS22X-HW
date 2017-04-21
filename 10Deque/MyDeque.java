public class MyDeque{
    String[] list;
    int front;
    int back;
    public MyDeque(){
	list = new String[1];
	front = 0;
	back = 0;
    }
    private void grow(){
	if ((back-front)%5 == list.size - 1){
	    String[] x = new String[list.size*2];
	    for (int i = 0; i < list.size; i++){
		x[i] = list[i];
	    }
	    list = x;
	}
    }
    public void addFirst(String x){
	if (x == null){
	    throw new NullPointerException();
	}
	grow();	
	front = (front-1)%list.size;
	list[front] = x;
    }
    public void addLast(String x){
	if (x == null){
	    throw new NullPointerException();
	}
	grow();	
	back = (back+1)%list.size;
	list[back] = x; 
    }
    public String removeFirst(){
	if (back == front){
	    throw new NoSuchElementException();
	}
	int x = list[front];
	front = (front+1)%list.size;
	return x;
    }
    public String removeLast(){
	if (back == front){
	    throw new NoSuchElementException();
	}
	int x = list[back];
	back = (back-1)%list.size;
	return x;
    }
    public String getFirst(){
	if (back == front){
	    throw new NoSuchElementException();
	}
	return list[first];
    }
    public String getLast(){
	if (back == front){
	    throw new NoSuchElementException();
	}
	return list[back];
    }
    
}
