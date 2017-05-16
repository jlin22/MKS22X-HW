public class StackFrontier implements Frontier{
    private Stack front;
    public StackFrontier(){
	front = new Stack();
    }
    public void add(Location x){
	front.push(x);
    }
    public Location next(){
    }
    public int size(){
    }
	
}
