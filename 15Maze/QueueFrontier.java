import java.util.LinkedList;
public class QueueFrontier implements Frontier{
    private LinkedList<Location> front;
    public QueueFrontier(){
	front = new LinkedList<Location>();
    }
    public void add(Location x){
	front.add(x);
	
    }
    public Location next(){
	return front.removeLast();
    }
    public int size(){
	return front.size();
    }
    /*public static void main(String[]a){
	Location x = new Location(0,0,null,0,5,false);
	Location y = new Location(1,1,x,4,0,false);
	QueueFrontier z = new QueueFrontier();
	z.add(x);
	z.add(y);
	System.out.println(z.size());
	System.out.println(z.next());
	System.out.println(z.next());
    }*/
}
