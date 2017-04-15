import java.util.*;
public class MyLinkedList{
    private LNode head,tail;
    private int size;
    public MyLinkedList(){
	size = 0;
    }
    public int size(){
	return size;
    }
    private LNode getNthNode(int n){
	int i;
	LNode c;
	if (n < size / 2){
	    i = 0;
	    c = head;
	    while (i<n){
		c = c.next;
		i++;
	    }
	}
	else{
	    i = size - 1;
	    c = tail;
	    while (i > n){
		c = c.prev;
		i--;
	    }
	}
	return c;
    }
    private void addAfter(LNode location, LNode toBeAdded){
	if (size == 0){
	    head = toBeAdded;
	    tail = toBeAdded;
	    size++;
	}
	else if (location == tail){
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	    tail = toBeAdded;
	    size++;
	}
	else{
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next = toBeAdded;
	    toBeAdded.next.prev=toBeAdded;
	    size++;
	}
    }
    private void remove(LNode target){
	if (target.next == null && target.prev == null){
	    target = null;
	}
	if (target == head){
	    head = target.next;
	    head.prev = null;
	}
	if (target == tail){
	    tail = target.prev;
	    tail.next = null;
	}
	else{
	    target.next.prev = target.prev;
	    target.prev.next = target.next;
	}
    }
    public String toString(){
	String x = "[";
	LNode c = head;
	while (c != null){
	    x += c;
	    if (c != tail){
		x+= ",";
	    }
	    c = c.next;
	}	    
	return x + "]";
    }
    public boolean add(int value){
	LNode x = new LNode(value);
	addAfter(tail,x);
	return true;
    }
    public int get(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	return getNthNode(index).value;
    }
    public int set(int index, int v){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	int x = getNthNode(index).value;
	getNthNode(index).value = v;
	return x;
    }
    public int indexOf(int v){
	for (int i = 0; i < size;i++){
	    if (getNthNode(i).value == v){
		return i;
	    }
	}
	return -1;
    }
    public int remove(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	int x = getNthNode(index).value;
        remove(getNthNode(index));
	return x;
    }
    public void add(int i, int v){
	if (i < 0 || i > size){
	    throw new IndexOutOfBoundsException();
	}
	LNode x = new LNode(v);
	addAfter(getNthNode(i), x);
    }
	
    /*
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
	}*/
    private class LNode{
	LNode next,prev;
	int value;
	public LNode(int value){
	    this.value = value;
	}
	public String toString(){
	    return value+"";
	}
    }
    public static void main(String[]a){
	MyLinkedList x = new MyLinkedList();
	x.add(10);
	x.add(169);
	x.add(196);
	System.out.println(x.set(0,999));
	System.out.println(x.get(1));
	System.out.println(x.indexOf(999));
	System.out.println(x.indexOf(0));
	System.out.println(x.remove(2));
	x.add(1,55);
	System.out.println(x);
	/*
	x.add(67);
	System.out.println(x.set(1,99));

	System.out.println(x.indexOf(99));
	*/
    }
    
}
