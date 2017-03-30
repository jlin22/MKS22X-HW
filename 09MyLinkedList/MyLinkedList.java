public class MyLinkedList{
    private LNode start;
    private int size;
    public MyLinkedList(){
	size = 0;
    }
    public boolean add(int value){
 	size++;
	LNode c = start;
	if (c == null){
	    start = new LNode(value,start);
	    return true;
	}
	while (c.next != null){
	    c = c.next;
	}
	c.next = new LNode(value,null);
	return true;
    }
    public int size(){
	return size;
    }
    public int get(int i){
	LNode c = start;
	while (i != 0){
	    i--;
	    c = c.next;
	}
	return c.value;
    }
    public int set(int i, int v){
	LNode c = start;
	while (i != 0){
	    i--;
	    c = c.next;
	}
	int x = c.value;
	c.value = v;
	return x;
    }
    public int indexOf(int v){
	LNode c = start;
	int i = 0;
	while (c != null){
	    if (c.value == v){
		return i;
	    }
	    c = c.next;
	    i++;
	}
	return -1;
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
	System.out.println(x.set(1,99));
	System.out.println(x);
	System.out.println(x.indexOf(99));

    }
    
}
