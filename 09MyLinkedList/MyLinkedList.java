public class MyLinkedList{
    private LNode start;
    private int size;
    public MyLinkedList(){
	size = 0;
    }
    public boolean add(int value){
	size++;
	//start = new LNode(value,start);
	return true;
    }
    public int size(){
	return size;
    }
    public String toString(){
	String s = "[";
	LNode current = start;
	while (current.next != null){
	    s += current.value + ",";
	    current = current.next;
	}
	s+= current.value + "]";
	return s;
    }
    private class LNode{
	private int value;
	private LNode next;
	private LNode(int v, LNode n){
	    value = v;
	    next = n;
	}
    }
    public static void main(String[]a){
	MyLinkedList x = new MyLinkedList();
	x.add(1);
	x.add(67);
	System.out.println(x);
    }
    
}
